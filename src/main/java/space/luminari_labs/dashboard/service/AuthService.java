package space.luminari_labs.dashboard.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import space.luminari_labs.dashboard.dto.AuthRequest;
import space.luminari_labs.dashboard.dto.AuthResponse;
import space.luminari_labs.dashboard.entity.Rol;
import space.luminari_labs.dashboard.entity.Usuario;
import space.luminari_labs.dashboard.repository.IRolRepository;
import space.luminari_labs.dashboard.repository.IUsuarioRepository;
import space.luminari_labs.dashboard.security.JwtService;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthService {

    @Value("${google.client.id}")
    private String googleClientId;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    public AuthResponse authenticateWithGoogle(AuthRequest request) throws Exception {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(googleClientId))
                .build();

        GoogleIdToken idToken = verifier.verify(request.getIdToken());
        
        if (idToken == null) {
            throw new RuntimeException("Invalid ID token.");
        }
        
        GoogleIdToken.Payload payload = idToken.getPayload();
        String email = payload.getEmail();
        String name = (String) payload.get("given_name");
        String familyName = (String) payload.get("family_name");

        if (name == null) name = "";
        if (familyName == null) familyName = "";

        // Find user or create new one
        Optional<Usuario> optionalUsuario = usuarioRepository.findByCorreoElectronico(email);
        Usuario usuario;

        if (optionalUsuario.isEmpty()) {
            usuario = new Usuario();
            usuario.setCorreoElectronico(email);
            usuario.setNombre(name);
            usuario.setApellidos(familyName);
            usuario.setEstadoActivo(true);
            
            // Assign default role (e.g., USUARIO)
            Rol defaultRol = rolRepository.findByNombre("USUARIO").orElseGet(() -> {
                Rol newRol = new Rol("USUARIO");
                return rolRepository.save(newRol);
            });
            usuario.setRol(defaultRol);
            
            usuario = usuarioRepository.save(usuario);
        } else {
            usuario = optionalUsuario.get();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getCorreoElectronico());
        String jwtToken = jwtService.generateToken(userDetails);

        return new AuthResponse(jwtToken, usuario.getCorreoElectronico(), usuario.getNombre(), usuario.getApellidos());
    }
}

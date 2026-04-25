package space.luminari_labs.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.luminari_labs.dashboard.dto.AuthRequest;
import space.luminari_labs.dashboard.dto.AuthResponse;
import space.luminari_labs.dashboard.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/google")
    public ResponseEntity<?> authenticateWithGoogle(@RequestBody AuthRequest authRequest) {
        try {
            AuthResponse response = authService.authenticateWithGoogle(authRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error de autenticación: " + e.getMessage());
        }
    }
}

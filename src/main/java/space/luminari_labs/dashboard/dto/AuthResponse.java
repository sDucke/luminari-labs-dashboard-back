package space.luminari_labs.dashboard.dto;

public class AuthResponse {
    private String token;
    private String email;
    private String nombre;
    private String apellidos;

    public AuthResponse() {
    }

    public AuthResponse(String token, String email, String nombre, String apellidos) {
        this.token = token;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}

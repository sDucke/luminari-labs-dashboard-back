package space.luminari_labs.dashboard.dto;

public class AuthRequest {
    private String idToken;

    public AuthRequest() {
    }

    public AuthRequest(String idToken) {
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}

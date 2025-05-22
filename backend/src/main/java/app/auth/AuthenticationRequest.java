package app.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}

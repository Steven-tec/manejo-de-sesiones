package service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImplement implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Mejor usar false para no crear una nueva sesión si no existe
        if (session == null) {
            return Optional.empty();
        }

        String userName = (String) session.getAttribute("username");
        return Optional.ofNullable(userName); // Devuelve vacío si userName es null
    }
}

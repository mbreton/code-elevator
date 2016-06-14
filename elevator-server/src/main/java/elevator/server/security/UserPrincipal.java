package elevator.server.security;

import java.security.Principal;

class UserPrincipal implements Principal {
    private final String email;

    UserPrincipal(String email) {
        this.email = email;
    }

    @Override
    public String getName() {
        return email;
    }
}

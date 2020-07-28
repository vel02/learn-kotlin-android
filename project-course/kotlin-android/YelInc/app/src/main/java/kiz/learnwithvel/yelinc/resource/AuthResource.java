package kiz.learnwithvel.yelinc.resource;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AuthResource {

    @NonNull
    public final AuthStatus status;
    @Nullable
    public final String message;

    public AuthResource(@NonNull AuthStatus status, @Nullable String message) {
        this.status = status;
        this.message = message;
    }

    public static AuthResource authenticated(@Nullable String message) {
        return new AuthResource(AuthStatus.AUTHENTICATED, message);
    }

    public static AuthResource verification(@Nullable String message) {
        return new AuthResource(AuthStatus.VERIFICATION, message);
    }

    public static AuthResource unauthenticated(@Nullable String message) {
        return new AuthResource(AuthStatus.UNAUTHENTICATED, message);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;

        if (obj.getClass() != getClass()) {
            return false;
        }

        AuthResource resource = (AuthResource) obj;

        if (resource.status != status) {
            return false;
        }

        if (resource.message != null) {
            if (message == null) {
                return false;
            }
            return resource.message.equals(message);
        } else return false;

    }

    public enum AuthStatus {AUTHENTICATED, VERIFICATION, UNAUTHENTICATED}

}

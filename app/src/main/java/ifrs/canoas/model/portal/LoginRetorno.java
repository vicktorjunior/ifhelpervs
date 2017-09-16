package ifrs.canoas.model.portal;

/**
 * Created by marcio on 27/08/17.
 */

public class LoginRetorno {
    private String error;
    private String token = "Nenhum";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toString() {
        return token + " " + error;
    }
}

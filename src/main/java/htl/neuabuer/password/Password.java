package htl.neuabuer.password;

public class Password {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public boolean check(String test) {
        return test.equals(password);
    }
}

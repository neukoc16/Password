package htl.neuabuer.password;

public class Password implements Runnable {

    private final String password;

    public Password(String password) {
        this.password = password;
    }

    public boolean check(String test) {
        return test.equals(password);
    }

    @Override
    public void run() {

    }
}

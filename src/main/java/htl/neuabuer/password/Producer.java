package htl.neuabuer.password;

import java.util.Scanner;

public class Producer implements Runnable {

    private final Password pw;
    private final Scanner sc = new Scanner(System.in);
    private final String in = sc.nextLine();

    public Producer(Password pw) {
        this.pw = pw;
    }

    @Override
    public void run() {
        if (in != null) {
            System.out.format("Das Passwort ist: ", pw.check(in));
        } else {
            System.out.println("Kein Passwort eingegeben");
        }
    }

}

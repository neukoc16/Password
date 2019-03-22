package htl.neuabuer.password;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            pw.check(in);
        } else {
            try {
                pw.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

package htl.neuabuer.password;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        LinkedList<Password> pws = new LinkedList<>();
        Password pw = new Password(JOptionPane.showInputDialog("Enter Password:"));
        Producer p = new Producer(pw, pws);
        Consumer c = new Consumer(pw, pws);
        new Thread(p).start();
        new Thread(c).start();
    }
}

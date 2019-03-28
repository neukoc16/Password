package htl.neuabuer.password;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Producer implements Runnable {

    private Password pw;
    private LinkedList<Password> list;

    public Producer(LinkedList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            pw = new Password(JOptionPane.showInputDialog("Enter Password:"));
            synchronized (list) {
                if (pw != null) {
                    list.add(pw);
                    list.notifyAll();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}

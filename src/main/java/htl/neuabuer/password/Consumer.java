package htl.neuabuer.password;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    private Password pw;
    private final LinkedList<Password> list;
    private final LinkedList<String> pws = new LinkedList<>();
    File file = new File("./pwds.txt");

    public Consumer(LinkedList list) {
        this.list = list;
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                pws.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            synchronized (list) {
                if (list.isEmpty()) {
                    System.out.println("List empty!");
                    try {
                        list.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    continue;
                } else {
                    pw = list.remove(0);
                    list.notifyAll();
                }
            }
            for (String password : pws) {
                if (pw.check(password)) {
                    System.out.println("FOUND -> " + password);
                    break;
                }
            }
        }
    }
}

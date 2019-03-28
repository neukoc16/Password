package htl.neuabuer.password;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Password> pws = new LinkedList<>();
        Producer p = new Producer(pws);
        Consumer c = new Consumer(pws);
        new Thread(p).start();
        new Thread(c).start();
    }
}

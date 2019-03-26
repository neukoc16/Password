package htl.neuabuer.password;

import java.util.LinkedList;

public class Producer implements Runnable {

    private Password pw;
    private LinkedList<Password> list;

    public Producer(Password pw, LinkedList list) {
        this.pw = pw;
        this.list = list;
    }

    @Override
    public void run() {
        list.add(pw);
    }

}

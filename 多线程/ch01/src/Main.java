/*public class Main {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread");
    }
}*/


/*
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread");
    }
}*/


public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("start new thread"));
        t.start();
    }
}
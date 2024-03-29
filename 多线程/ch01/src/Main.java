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


/*
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("start new thread"));
        t.start();
    }
}*/


public class Main {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread(() -> {
            System.out.println("thread run...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("thread end.");
            }
        });
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("main end...");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        var c1 = new Counter();
        var c2 = new Counter();

        new Thread(c1::add).start();

        new Thread(c1::dec).start();

        new Thread(c2::add).start();

        new Thread(c2::dec).start();
    }
}

class Counter {
    private int count = 0;

    public void add() {
        synchronized (this) {
            count += 1;
        }
    }

    public void dec() {
        synchronized (this) {
            count -= 1;
        }
    }

    public int get() {
        return count;
    }
}
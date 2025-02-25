public class ThreadPrint {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread numberThread = new Thread(new NumberPrinter(lock));
        Thread letterThread = new Thread(new LetterPrinter(lock));

        numberThread.start();
        letterThread.start();
    }
}

class NumberPrinter implements Runnable {
    private final Object lock;
    private static int number = 1;

    public NumberPrinter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (number <= 52) {
            synchronized (lock) {
                System.out.print(number);
                number++;
                System.out.print(number);
                number++;
                lock.notify();
                try {
                    if (number <= 52) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class LetterPrinter implements Runnable {
    private final Object lock;
    private static char letter = 'A';

    public LetterPrinter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (letter <= 'Z') {
            synchronized (lock) {
                System.out.print(letter + " ");
                letter++;
                lock.notify();
                try {
                    if (letter <= 'Z') {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
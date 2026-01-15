
public class WarmUp1 {
    private static int counter = 0;

    public static final int NUMTHREADS = 10;
    private static Object temp = new Object();

    public static void counterIncrement() {
        synchronized (temp) {
            counter++;

        }
    }

    public static void main(String[] args) {
        Thread[] threadsArray = new Thread[NUMTHREADS];

        for (int i = 0; i < NUMTHREADS; i++) {
            threadsArray[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        counterIncrement();
                    }
                }
            });
            threadsArray[i].start();
        }

        for (Thread t : threadsArray) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("final value of counter = " + counter);
    }
}
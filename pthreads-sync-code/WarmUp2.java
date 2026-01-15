public class WarmUp2 {

    private static int NUMTHREAD = 10;
    public static void main(String[] args) {
        Thread[] threadArray = new Thread[NUMTHREAD];

        for (int i = 0; i < NUMTHREAD; i++) {
            threadArray[i] = new Thread(new Worker(i));
            threadArray[i].start();
        }

        for (int i = 0; i < NUMTHREAD; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("I am the main Thread");
        
    }

    private static class Worker implements Runnable {
        
        private int id;

        public Worker(int id) {
            this.id = id;
        }
        
        @Override
        public void run() {
            System.out.println("I am thread " + this.id);
        }
    }
}

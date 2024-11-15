package lab.mohit.concurrency;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderV2 implements Runnable {

        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
//        Runnable reader = () -> {
//            while(!ready) {
//                Thread.yield();
//            }
//            System.out.println(number);
//        };
        Thread readerTrhead = new Thread(new ReaderV2());
        readerTrhead.start();
        number = 42;
        number = 41;
        number = 20;
        number = 23;
        ready = true;
    }
}

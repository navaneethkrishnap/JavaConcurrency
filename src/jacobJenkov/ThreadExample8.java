package jacobJenkov;

import java.security.PrivateKey;

public class ThreadExample8 {
    public static class StoppableRunnable implements Runnable{
        private boolean stopRequest = false;

        public synchronized void requestStop(){
            this.stopRequest = true;
        }

        public synchronized boolean isStopRequested(){
            return this.stopRequest;
        }

        private void sleep(long millis){
            try{
                Thread.sleep(millis);
            } catch (InterruptedException e){
                System.out.println("interrupted.");
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while (!stopRequest){
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppableRunnable stopped.");
        }
    }

    public static void main(String[] args) {

        StoppableRunnable stopRun = new StoppableRunnable();
        Thread thread = new Thread(stopRun, "stopRun_test");
        thread.start();

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }

        System.out.println("requesting stop");
        stopRun.requestStop();
        System.out.println("stop requested.");
    }
}

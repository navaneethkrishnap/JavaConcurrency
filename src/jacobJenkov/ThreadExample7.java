package jacobJenkov;

public class ThreadExample7 {
    public static void main(String[] args) {
        Runnable runnable =  () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
            System.out.println(threadName + " finished.");
        };

        Thread threadEx = new Thread(runnable, "sleep_example");
        threadEx.start();
    }

}

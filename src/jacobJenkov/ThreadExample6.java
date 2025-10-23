package jacobJenkov;

public class ThreadExample6 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running.");
        };

        Thread thread = new Thread(runnable, "example thread");
        thread.start();
        Thread thread2 = new Thread(runnable, "example2 thread");
        thread2.start();

    }
}

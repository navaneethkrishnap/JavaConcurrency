package basics;

public class JoinDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            for(int i = 1; i <= 5; i++){
                System.out.println("Child thread: "+ i);
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    System.out.println("Child thread interrupted.");
                }
            }
        });

        t1.start();
        try{
            t1.join();
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted while waiting..");
        }
        System.out.println("Main thread resumes after child finishes.");
    }
}

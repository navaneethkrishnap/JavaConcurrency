package basics;

public class NewThread1 extends Thread{
    NewThread1(){
        super("Demo Thread");
        System.out.println("Child thread: "+ this);
        start();
    }

    @Override
    public void run(){
        try{
            for(int i = 5; i >0; i--){
                System.out.println("Child thread: "+ i);
                Thread.sleep(500);
            }
        } catch(InterruptedException e){
            System.out.println("Child thread interrupted.");
        }
        System.out.println("Exiting child thread...");
    }
}

class ExtendThread{
    public static void main(String[] args) {
        new NewThread1();
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Main thread: "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting...");
    }
}

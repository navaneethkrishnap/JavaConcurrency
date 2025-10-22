package basics;

class NewThread2 implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread2(String name){
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: "+ t);
        suspendFlag = false;
        t.start();
    }

    public void run(){
        try{
            for(int i = 15; i > 0; i--){
                System.out.println(name + ": "+ i);
                Thread.sleep(200);
                synchronized (this){
                    while(suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        System.out.println(name + " exiting..");
    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread2 ob1 = new NewThread2("one");
        NewThread2 ob2 = new NewThread2("two");

        try{
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("suspending thread one...");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("resuming thread one...");
            ob2.mysuspend();
            System.out.println("suspending thread two...");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("resuming thread two...");
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted.");
        }

        try{
            System.out.println("waiting for threads to finish");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e){
            System.out.println("main thread interrupted");
        }
        System.out.println("Main thread exiting,...");
    }
}

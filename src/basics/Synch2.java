package basics;

class CallMe1{
    // synchronised and race condition is not eliminated here
    void call(String msg){
        System.out.print("["+ msg);
        try{
            Thread.sleep(1000);

        } catch (InterruptedException e){
            System.out.println("interrupted");
        }
        System.out.println("]");
    }
}

class Caller1 implements Runnable{
    String msg;
    CallMe target;
    Thread t;

    public Caller1(CallMe tar,  String s){
        target = tar;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run(){
        // synchronised and race condition is eliminated
        synchronized (target){
            target.call(msg);
        }
    }
}

public class Synch2 {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller1 ob1 = new Caller1(target,"hello");
        Caller1 ob2 = new Caller1(target, "synchronised");
        Caller1 ob3 = new Caller1(target, "world");

        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}

package interThread;
class QFixed{
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while(!valueSet){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("interrupted exception caught");
            }
        }
        System.out.println("got: "+n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while(valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("put: "+ n);
        notify();
    }
}


class Producer1 implements Runnable{
    QFixed q;

    Producer1(QFixed q){
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run(){
        int i = 0;
        while(true){
            q.put(i++);
        }
    }
}

class Consumer1 implements Runnable{
    QFixed q;

    Consumer1(QFixed q){
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run(){
        while(true){
            q.get();
        }
    }
}
public class PCFixed {
    public static void main(String[] args) {
        QFixed q1 = new QFixed();
        new Producer1(q1);
        new Consumer1(q1);
    }
}

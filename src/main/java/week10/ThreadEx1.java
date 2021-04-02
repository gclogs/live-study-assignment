package week10;

public class ThreadEx1 extends Thread {

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}

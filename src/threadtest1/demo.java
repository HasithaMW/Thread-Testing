package threadtest1;

class MyClass implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId()+" "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class demo{
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyClass());
		t1.start();
		
		Thread t2 = new Thread(new MyClass());
		t2.start();
	}

}

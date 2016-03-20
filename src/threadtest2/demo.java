package threadtest2;

public class demo {
	
	static int count = 0;
	
	public static synchronized void increment(){
		count++;
	}
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000000; i++) {
//					System.out.println(Thread.currentThread().getId()+" "+i);
					increment();
				}
			}
		});
		
Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10000000; i++) {
//					System.out.println(Thread.currentThread().getId()+" "+i);
					increment();
				}
			}
		});

		
		
		
		t.start();
		t1.start();
		
		try {
			t.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(count);
	}

}

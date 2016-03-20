package threadtest;

class MyClass extends Thread{

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		
		for(int i=0; i<10; i++){
			System.out.println(Thread.currentThread().getId()+ " "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}

public class demo {
	
	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.start();
		
		MyClass myClass1 = new MyClass();
		myClass1.start();
	}

}

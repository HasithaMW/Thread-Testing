package threadsafety.test1;

public class ThreadSafe1 {
	
	 public static void main(String[] args) throws InterruptedException {
	     
	        ProcessingThread1 pt = new ProcessingThread1();
	        Thread t1 = new Thread(pt, "t1");
	        t1.start();
	        Thread t2 = new Thread(pt, "t2");
	        t2.start();
	        //wait for threads to finish processing
	        t1.join();
	        t2.join();
	        System.out.println("Processing count="+pt.getCount());
	    }
	 
	}
	 
	class ProcessingThread1 implements Runnable{
	    private int count;
	     
	    @Override
	    public void run() {
	        increese();
	    }
	    
	    private synchronized void increese(){		// This is thread safe.
//	    private void increese(){		// This is not thread safe.
	    	for(int i=1; i< 5; i++){
	            processSomething(i);
	            count++;
	        }
	    }
	 
	    public int getCount() {
	        return this.count;
	    }
	 
	    private void processSomething(int i) {
	        // processing some job
	        try {
	            Thread.sleep(i*1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
	

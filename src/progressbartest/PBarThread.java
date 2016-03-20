package progressbartest;

import javax.swing.JProgressBar;

public class PBarThread implements Runnable {

	private JProgressBar progressBar;
	private int count;
	private int time;
	
	
	public PBarThread(JProgressBar progressBar, int count, int time) {
		this.progressBar = progressBar;
		this.count = count;
		this.time = time;
	}
	
	@Override
	public void run() {
		for(int i=0;i<count;i++){
			progressBar.setValue(i);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}

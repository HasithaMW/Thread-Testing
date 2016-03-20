package progressbartest;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ProgressBarApp extends JFrame {
	
	JProgressBar progressBar1;
	JProgressBar progressBar2;
	
	JButton btnStart1;
	JButton btnPause1;
	JButton btnStart2;
	JButton btnPause2;
	
//	JTextField txtCount1;
//	JTextField txtTime1;
//	
//	JTextField txtCount2;
//	JTextField txtTime2;
	
	Thread thread1;
	Thread thread2;
	
	public ProgressBarApp() {
		setTitle("Progress Bar App");
		setLocation(200,200);
		setSize(318, 400);
		
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		
		btnStart1 = new JButton("Start");
		btnStart2 = new JButton("Start");
		btnPause1 = new JButton("Pause");
		btnPause2 = new JButton("Pause");
		
//		txtCount1 = new JTextField(10);
//		txtCount2 = new JTextField(10);
//		txtTime1 = new JTextField(10);
//		txtTime2 = new JTextField(10);
		
		progressBar1 = new JProgressBar();
		progressBar2 = new JProgressBar();
		
		btnStart1.addActionListener(e ->{
			
//			String count = txtCount1.getText();
//			String time = txtTime1.getText();
//			
//			if(count!="" && time != ""){
				PBarThread thread = new PBarThread(progressBar1, Integer.parseInt("100"), Integer.parseInt("100"));
				thread1 = new Thread(thread);
				thread1.start();
				btnStart1.setEnabled(false);
				btnPause1.setEnabled(true);
//			}
			
		});
		
		btnPause1.addActionListener(e->{
				thread1.suspend();;
				btnPause1.setEnabled(false);
				btnStart1.setEnabled(true);
		});
		
		btnStart2.addActionListener(e ->{
			
//			String count = txtCount1.getText();
//			String time = txtTime1.getText();
//			
//			if(count!="" && time != ""){
				PBarThread thread = new PBarThread(progressBar2, Integer.parseInt("100"), Integer.parseInt("200"));
				thread2 = new Thread(thread);
				thread2.start();
				btnStart2.setEnabled(false);
				btnPause2.setEnabled(true);
//			}
			
		});
		
		btnPause2.addActionListener(e->{
				thread2.suspend();
				btnPause2.setEnabled(false);
				btnStart2.setEnabled(true);
		});
		
		
//		con.add(txtCount1);
//		con.add(txtTime1);
		con.add(progressBar1);
		con.add(btnStart1);
		con.add(btnPause1);
//		con.add(txtCount2);
//		con.add(txtTime2);
		con.add(progressBar2);
		con.add(btnStart2);
		con.add(btnPause2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ProgressBarApp app = new ProgressBarApp();
	}

}

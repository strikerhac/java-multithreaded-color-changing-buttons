package multithreading;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;

public class thread_buttons extends Thread{
	int r = 0;
	int g = 0;
	int b = 0;
	private JButton button;
	private int sleep;
	thread_buttons(int sleep,JButton button){
		this.sleep = sleep;
		this.button = button;
	}
	
	Random rand = new Random();
	
	     public void run()
	     {
	     
	      while(true){

	    	  r = ThreadLocalRandom.current().nextInt(0, 250);
	    	  g = ThreadLocalRandom.current().nextInt(0, 250);
	    	  b = ThreadLocalRandom.current().nextInt(0, 250);
		      button.setBackground(new java.awt.Color(r,g,b));
		      try {
				Thread.sleep(sleep);
		      } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		      	}
	      }
	      
	     }
	    
}

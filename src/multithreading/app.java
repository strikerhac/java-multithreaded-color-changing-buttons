package multithreading;

import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;

public class app {
	private int flashTime = 0;
	private int noOfItems = 0;
	private String url;
	
    public app (String url) {
    	this.url = url;
    }
    
	public JFrame getFrame(){
		JFrame f = new JFrame("Button_Frame");
		f.setSize(400,400);  
	    f.setLayout(new FlowLayout());  
	    f.setVisible(true); 
		return f;
	}
	
	public JButton getButton(){
		JButton button = new JButton("button");      
		return button;
	}
	
	public JFrame addButton(JButton button, JFrame frame) {
		frame.add(button);
		thread_buttons tb = new thread_buttons(flashTime,button);
	    tb.start();
		return frame;
	}
	
	public void getProperties() {
		config_singelton.get_File_url();
		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream(url);


			// load a properties file
			prop.load(input);

			// get the property value and print it out
			flashTime = Integer.parseInt(prop.getProperty("flashTime"));
			noOfItems = Integer.parseInt(prop.getProperty("noOfItems"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	public int getnoOfItems() {
		getProperties();
		return noOfItems;
	}
	
    
}

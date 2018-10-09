package multithreading;
import javax.swing.*;  

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class main {
	public static void main(String args[]){
		String url = args[0];
		System.out.println(url);
		app a = new app(url);
		int noOfItems = a.getnoOfItems();
		JFrame frame = a.getFrame();
		
		for (int i = 0; i < noOfItems; i++){
			JButton button = a.getButton();
			frame = a.addButton(button,frame);
		}
		
	}
}

package buildertest;

import java.awt.Color;
import java.util.Random;

import javax.swing.JLabel;


public class Question {
	
	int creat(JLabel lblNewLabel){
		int rancolor = 0;
		int rantext = 0;
		Random rand = new Random();
		
		while(rancolor == rantext) {
			 rancolor = rand.nextInt(6);
			 rantext = rand.nextInt(6);
		}
		
		switch(rancolor) {
		  case(0): lblNewLabel.setForeground(Color.RED);
		  break;
		  case(1): lblNewLabel.setForeground(Color.BLUE);
		  break;
		  case(2): lblNewLabel.setForeground(Color.GREEN);
		  break;
		  case(3): lblNewLabel.setForeground(Color.YELLOW);
		  break;
		  case(4): lblNewLabel.setForeground(Color.BLACK);
		  break;
		  case(5): lblNewLabel.setForeground(Color.WHITE);
		  break;
		}
		
		switch(rantext) {
		  case(0): lblNewLabel.setText("紅色");
		  break;
		  case(1): lblNewLabel.setText("藍色");
		  break;
		  case(2): lblNewLabel.setText("綠色");
		  break;
		  case(3): lblNewLabel.setText("黃色");
		  break;
		  case(4): lblNewLabel.setText("黑色");
		  break;
		  case(5): lblNewLabel.setText("白色");
		  break;
		}
		return rancolor;	
	}
}

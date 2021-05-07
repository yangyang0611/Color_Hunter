package buildertest;

import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SimpleTask extends TimerTask{

	int i = 0;
	public String name;
	public int score; 
	
	public int check(JLabel lblNewLabel) {
		if(lblNewLabel.getText() == "Game over !") return 1;
		else return 0;
		//String inputname = JOptionPane.showInputDialog(" Time's up! please enter your name! ");
   }
	
	public void run(){
        //cancel();
		name = JOptionPane.showInputDialog(" Time's up! Your score is "+score+"! please enter your name! ");
		if(name != null) {
			Store store =new Store();
			store.add_Score(name, score,"文字顏色猜猜");
		}
	}
}

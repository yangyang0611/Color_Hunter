package buildertest;

import java.util.*; 
import java.io.*;

public class Store {
	private ArrayList<Information> information =new ArrayList<>();
	private String currentDir="";
	public Store() {
		currentDir=System.getProperty("user.dir");		
		//cleanUp();		//清除file
	}	
	//game end use
	public void add_Score(String name,int score,String game_name) {	
		information=get_Data(game_name);		
		Information I =new Information(name,score);	
		
		for(int num=information.size()-1;num>=0;num--) {		
			if(I.get_score()<information.get(num).get_score() || I.get_score()>=information.get(0).get_score()) {
				boolean high=false;
				//the most rank to 100
				if(num==100) {
					return;
				}
				if(I.get_score()>=information.get(0).get_score()) {
					num=0;
					high=true;
					System.out.println("get");
				}
				//length same
				if(information.size()-1 ==num ) {
					if(num==0) {
						information.add(information.get(0));
						information.set(0, I);						
					}
					else {
						information.add(I);
					}
					
					break;
				}
				 
				
				
				boolean back=false;
				Information last=null;	
				int push=information.size()-1;
				for(;push>num;push--) {					
					//check size
					if(information.size()<100 &&!back) {		
						last=information.get(information.size()-1);
						information.add(last);
						back=true;
					}
					//insert the score
					if(push==num+1) {
						if(high==true) {
							information.set(1, information.get(0));
							information.set(0, I);
						}
						else {
							information.set(push, I);
						}				
						break;
					}
					//the lower score move back
					else{
						information.set(push, information.get(push-1));
					}
					
				}
				break;
			}			
		}
		//store the data
		store_Data(game_name);
	}
	
	public void store_Data(String game_name) {
		try {
			File file=new File(currentDir+"\\"+game_name+".obj");
			  if (!file.exists()) {
		            file.getParentFile().mkdir();
		            file.createNewFile();
		        }		
            FileOutputStream fos = new FileOutputStream(currentDir+"\\"+game_name+".obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println(information.size()+"------");
            oos.writeObject(information);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//score board use
	@SuppressWarnings("unchecked")
	public ArrayList<Information> get_Data(String game_name)  {
		try {		    
			File file=new File(currentDir+"\\"+game_name+".obj");
			  if (!file.exists()) {
		            file.getParentFile().mkdir();
		            file.createNewFile();
		            information.clear();
		            information.add(new Information("---",0));
		            store_Data(game_name);
		        }	
			  System.out.println(currentDir+"\\"+game_name+".obj");
			  
            FileInputStream fis = new FileInputStream(currentDir+"\\"+game_name+".obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
				information = (ArrayList<Information>) ois.readObject();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
          
          ois.close();
	           
        } catch (IOException e) {
            e.printStackTrace();
        }
		return information;
	}
	// administrator mode
	public void cleanUp(){
		information.clear();
		File file=new File(currentDir+"\\文字顏色猜猜"+".obj");
		File file2=new File(currentDir+"\\猜不同顏色"+".obj");
		if(file.exists() && file2.exists()) {
			file.delete();
			file2.delete();
		}
		
	}
	
}
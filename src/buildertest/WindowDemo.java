package buildertest;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.io.File;

public class WindowDemo {

	private JFrame frame;
	public JPanel mainPanel;
	public JPanel finddifferPanel;
	public JPanel pickcolorPanel;
	public JPanel recordPanel;
	
	///////////////////////////////////////////
	///////////////////////////////////////////
	//find differ//////////////////////////////
	JButton buttonStart;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton button10;
	JButton button11;
	JButton button12;
	JButton button13;
	JButton button14;
	JButton button15;
	JButton button16;
	JButton button17;
	JButton button18;
	JButton button19;
	JButton button20;
	JButton button21;
	JButton button22;
	JButton button23;
	JButton button24;
	JButton button25;
	JButton buttonExit;
	
	JButton buttonReStart;
	
	JLabel levelLabel;
	JLabel timeLabel;
	JLabel marksLabel;
	JLabel lblNewLabel_2;
	
	boolean clicked = false;
	
	ScheduledExecutorService exec;
	Runnable task;
	
	int level = 0, marks = 0;
	int secondsToWait = 30;
	int exitisclicked = 0;
	//find differ//////////////////////////////
	///////////////////////////////////////////
	//pick color///////////////////////////////
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	JButton btnNewButton;
	
	JLabel lblNewLabel;
	JLabel score_tile;
	JLabel score;
	JLabel check;
	
	SimpleTask tt;
	//pick color///////////////////////////////
	///////////////////////////////////////////
	//record///////////////////////////////////
	
	ArrayList<Information> inform;
	Store store = new Store();
	
	//record///////////////////////////////////
	///////////////////////////////////////////
	///////////////////////////////////////////
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowDemo window = new WindowDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 500, 500);
		frame.getContentPane().add(layeredPane);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		layeredPane.add(mainPanel, 0, 0);
		mainPanel.setBounds(0, 0, 500, 500);
		mainPanel.setBackground(new Color(13, 68, 113));
		
		finddifferPanel = new JPanel();
		finddifferPanel.setLayout(null);
		finddifferPanel.setBounds(0, 0, 500, 500);
		finddifferPanel.setBackground(new Color(100, 100, 100));
		
		pickcolorPanel = new JPanel();
		pickcolorPanel.setLayout(null);
		pickcolorPanel.setBounds(0, 0, 500, 500);
		pickcolorPanel.setBackground(new Color(100, 100, 100));
		
		recordPanel = new JPanel();
		recordPanel.setLayout(null);
		recordPanel.setBounds(0, 0, 500, 500);
		recordPanel.setBackground(new Color(100, 100, 100));
		
		frame.setTitle("Color Game");
		
		JButton startfinddiffer = new JButton("猜不同顏色");
		mainPanel.add(startfinddiffer);
		startfinddiffer.setBounds(100, 320, 110, 30);
		
		JButton startpickcolor = new JButton("文字顏色猜猜");
		mainPanel.add(startpickcolor);
		startpickcolor.setBounds(300, 320, 110, 30);
		
		JButton record = new JButton("紀錄");
		mainPanel.add(record);
		record.setBounds(210, 440, 100, 30);
		
		JLabel instruction1 = new JLabel();
		instruction1.setBounds(85, 355, 150, 70);
		instruction1.setText("<html><body><p align=\"center\">找出不同的顏色，看看你<br/>的眼力能帶你到哪一關!<br/>偷偷告訴你，綠色超難!!<br/>限時30秒</p></body></html>");
		instruction1.setForeground(Color.WHITE);
		mainPanel.add(instruction1);
		JLabel instruction2 = new JLabel();
		instruction2.setBounds(285, 355, 150, 70);
		instruction2.setText("<html><body><p align=\"center\">當文字自己的顏色和文字<br/>說明的顏色不同時，你還<br/>能選對文字自己的顏色嗎?<br/>限時30秒</p></body></html>");
		instruction2.setForeground(Color.WHITE);
		mainPanel.add(instruction2);
		
		//gif
		String currentDir=System.getProperty("user.dir");
		{
			try {
				System.out.println(currentDir+"\\test.png");			
				Icon icons = new ImageIcon(currentDir+"\\src\\buildertest\\pics\\cat.gif");
				JLabel label = new JLabel(icons,JLabel.CENTER);
				label.setBounds(100, 120, 300, 200);
				mainPanel.add(label);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Read gif error");
			}
		}
		currentDir=System.getProperty("user.dir");
		{
			try {
				System.out.println(currentDir+"\\test.png");			
				Icon icons = new ImageIcon(currentDir+"\\src\\buildertest\\pics\\ColorGame.gif");
				JLabel label = new JLabel(icons,JLabel.CENTER);
				label.setBounds(50, 30, 400, 100);
				mainPanel.add(label);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Read gif error");
			}
		}
		
		
		///////////////////////////////////////////
		///////////////////////////////////////////
		//find differ//////////////////////////////
		startfinddiffer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finddifferPanel = new JPanel();
				finddifferPanel.setLayout(null);
				//layeredPane.add(finddifferPanel, 0, 1);
				finddifferPanel.setBounds(0, 0, 500, 500);
				finddifferPanel.setBackground(new Color(150, 202, 244));
				layeredPane.add(finddifferPanel, 100, 1);
				frame.setTitle("猜不同顏色");
				//=====================================
				button1 = new JButton();
				button2 = new JButton();
				button3 = new JButton();
				button4 = new JButton();
				button5 = new JButton();
				button6 = new JButton();
				button7 = new JButton();
				button8 = new JButton();
				button9 = new JButton();
				button10 = new JButton();
				button11 = new JButton();
				button12 = new JButton();
				button13 = new JButton();
				button14 = new JButton();
				button15 = new JButton();
				button16 = new JButton();
				button17 = new JButton();
				button18 = new JButton();
				button19 = new JButton();
				button20 = new JButton();
				button21 = new JButton();
				button22 = new JButton();
				button23 = new JButton();
				button24 = new JButton();
				button25 = new JButton();
				
				clicked = false;
				
				level = 0;
				marks = 0;
				secondsToWait = 30;
				exitisclicked = 0;
				//=====================================
				
				buttonStart = new JButton("Start");                 // level 1
				buttonStart.setForeground(new Color(0, 0, 0));
				buttonStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {  // blue
						button1.setBackground(new java.awt.Color(0,0,205));  // 1 different
						button2.setBackground(new java.awt.Color(0,0,255));
						button3.setBackground(new java.awt.Color(0,0,255));
						button4.setBackground(new java.awt.Color(0,0,255));
						button5.setBackground(new java.awt.Color(0,0,255));
						button6.setBackground(new java.awt.Color(0,0,255));
						button7.setBackground(new java.awt.Color(0,0,255));
						button8.setBackground(new java.awt.Color(0,0,255));
						button9.setBackground(new java.awt.Color(0,0,255));
						button10.setBackground(new java.awt.Color(0,0,255));
						button11.setBackground(new java.awt.Color(0,0,255));
						button12.setBackground(new java.awt.Color(0,0,255));
						button13.setBackground(new java.awt.Color(0,0,255));
						button25.setBackground(new java.awt.Color(0,0,255));
						button15.setBackground(new java.awt.Color(0,0,255));
						button16.setBackground(new java.awt.Color(0,0,255));
						button17.setBackground(new java.awt.Color(0,0,255));
						button18.setBackground(new java.awt.Color(0,0,255));
						button19.setBackground(new java.awt.Color(0,0,255));
						button20.setBackground(new java.awt.Color(0,0,255));
						button21.setBackground(new java.awt.Color(0,0,255));
						button22.setBackground(new java.awt.Color(0,0,255));
						button23.setBackground(new java.awt.Color(0,0,255));
						button24.setBackground(new java.awt.Color(0,0,255));
						button14.setBackground(new java.awt.Color(0,0,255));
						levelLabel.setText("1");
						level = 2;
						buttonStart.setEnabled(false);
						
						exec = Executors.newScheduledThreadPool(1);
						task = new Runnable() {
							 public void run() {
						            secondsToWait--;
						            timeLabel.setText(secondsToWait + "");
						            if (secondsToWait == 0) {
						                //JOptionPane.showMessageDialog(frame, "Time's up!");
						                buttonDisable();
						                exec.shutdown();
						                String name = JOptionPane.showInputDialog("Time's up! please enter your name! ");
										if(name != null) {
											Store store =new Store();
											store.add_Score(name, marks,"猜不同顏色");
										}
						            }
						            else if(clicked == true) {
						            	buttonDisable();
						            	exec.shutdown();
						            }
						            else if(exitisclicked == 1) {
						            	exitisclicked = 0;
						            	exec.shutdown();
						            }
						        }
						};	
						timeLabel.setText(secondsToWait + "");
					    exec.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS);			
					}
				});
				buttonStart.setBounds(300, 360, 100, 30);
				//frmColor.getContentPane().add(buttonStart);
				finddifferPanel.add(buttonStart);
				
				button1 = new JButton("");
				button1.setBackground(UIManager.getColor("Button.background"));
				button1.setForeground(new Color(0, 0, 0));
				button1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                      // level 2 
						if(level == 2) {                                              // orange                
							button1.setBackground(new java.awt.Color(255,217,80));
							button2.setBackground(new java.awt.Color(255,217,80));
							button3.setBackground(new java.awt.Color(255,217,80));
							button4.setBackground(new java.awt.Color(255,217,80));
							button5.setBackground(new java.awt.Color(255,217,80));
							button6.setBackground(new java.awt.Color(255,217,80));
							button7.setBackground(new java.awt.Color(255,217,80));
							button8.setBackground(new java.awt.Color(255,217,80));
							button9.setBackground(new java.awt.Color(255,217,80));
							button10.setBackground(new java.awt.Color(255,217,80));
							button11.setBackground(new java.awt.Color(255,217,80));
							button12.setBackground(new java.awt.Color(255,217,80));
							button13.setBackground(new java.awt.Color(255,217,80));
							button14.setBackground(new java.awt.Color(255,217,80));    
							button15.setBackground(new java.awt.Color(255,217,80));
							button16.setBackground(new java.awt.Color(255,217,80));
							button17.setBackground(new java.awt.Color(255,217,80));
							button18.setBackground(new java.awt.Color(255,217,80));
							button19.setBackground(new java.awt.Color(255,217,80));
							button20.setBackground(new java.awt.Color(255,217,80));
							button21.setBackground(new java.awt.Color(255,217,80));
							button22.setBackground(new java.awt.Color(255,217,80));
							button23.setBackground(new java.awt.Color(255,217,80));
							button24.setBackground(new java.awt.Color(255,217,80));
							button25.setBackground(new java.awt.Color(255,204,51));	 // 25 different
							levelLabel.setText("2");
							marks++;
							marksLabel.setText("" + marks);
							level = 3;
						}
					}
				});		
				button1.setBounds(100, 50, 60, 60);
				//frmColor.getContentPane().add(button1);
				finddifferPanel.add(button1);
				
				button25 = new JButton("");
				button25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                     // level 3 
						if(level == 3) {                                             // melon_green
							button1.setBackground(new java.awt.Color(240,255,240));
							button2.setBackground(new java.awt.Color(240,255,240));
							button3.setBackground(new java.awt.Color(240,255,240));
							button4.setBackground(new java.awt.Color(240,255,240));
							button5.setBackground(new java.awt.Color(240,255,240));
							button6.setBackground(new java.awt.Color(240,255,240));
							button7.setBackground(new java.awt.Color(240,255,240));
							button8.setBackground(new java.awt.Color(245,255,250));  // 8 different
							button9.setBackground(new java.awt.Color(240,255,240));
							button10.setBackground(new java.awt.Color(240,255,240));
							button11.setBackground(new java.awt.Color(240,255,240));
							button12.setBackground(new java.awt.Color(240,255,240));
							button13.setBackground(new java.awt.Color(240,255,240));
							button14.setBackground(new java.awt.Color(240,255,240));
							button15.setBackground(new java.awt.Color(240,255,240));
							button16.setBackground(new java.awt.Color(240,255,240));
							button17.setBackground(new java.awt.Color(240,255,240));
							button18.setBackground(new java.awt.Color(240,255,240));
							button19.setBackground(new java.awt.Color(240,255,240));
							button20.setBackground(new java.awt.Color(240,255,240));
							button21.setBackground(new java.awt.Color(240,255,240));
							button22.setBackground(new java.awt.Color(240,255,240));
							button23.setBackground(new java.awt.Color(240,255,240));
							button24.setBackground(new java.awt.Color(240,255,240));
							button25.setBackground(new java.awt.Color(240,255,240));
							levelLabel.setText("3");
							marks++;
							marksLabel.setText("" + marks);
							level = 4;
						}
					}
				});
				button25.setBounds(340, 290, 60, 60);
				//frmColor.getContentPane().add(button25);
				finddifferPanel.add(button25);
				
				button8 = new JButton("");
				button8.setBackground(UIManager.getColor("Button.background"));
				button8.addActionListener(new ActionListener() {    
					public void actionPerformed(ActionEvent e) {                     // level 4 
						if(level ==4) {                                              // purple
							button1.setBackground(new java.awt.Color(148,0,211));
							button2.setBackground(new java.awt.Color(148,0,211));
							button3.setBackground(new java.awt.Color(148,0,211));
							button4.setBackground(new java.awt.Color(148,0,211));
							button5.setBackground(new java.awt.Color(148,0,211));
							button6.setBackground(new java.awt.Color(148,0,211));
							button7.setBackground(new java.awt.Color(148,0,211));
							button8.setBackground(new java.awt.Color(148,0,211));
							button9.setBackground(new java.awt.Color(148,0,211));
							button10.setBackground(new java.awt.Color(148,0,211));
							button11.setBackground(new java.awt.Color(148,0,211));
							button12.setBackground(new java.awt.Color(148,0,211));
							button13.setBackground(new java.awt.Color(148,0,211));
							button25.setBackground(new java.awt.Color(148,0,211));
							button15.setBackground(new java.awt.Color(148,0,211));
							button16.setBackground(new java.awt.Color(153,50,204));  // 16 different
							button17.setBackground(new java.awt.Color(148,0,211));
							button18.setBackground(new java.awt.Color(148,0,211));
							button19.setBackground(new java.awt.Color(148,0,211));
							button20.setBackground(new java.awt.Color(148,0,211));
							button21.setBackground(new java.awt.Color(148,0,211));
							button22.setBackground(new java.awt.Color(148,0,211));
							button23.setBackground(new java.awt.Color(148,0,211));
							button24.setBackground(new java.awt.Color(148,0,211));
							button14.setBackground(new java.awt.Color(148,0,211));
							levelLabel.setText("4");
							marks++;
							marksLabel.setText("" + marks);
							level = 5;
						}
					}	
				});
				button8.setBounds(220, 110, 60, 60);
				//frmColor.getContentPane().add(button8);
				finddifferPanel.add(button8);
				
				button16 = new JButton("");
				button16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                     // level 5 
						if(level == 5) {                                             // ugly yellow
							button1.setBackground(new java.awt.Color(204,204,51));
							button2.setBackground(new java.awt.Color(204,204,51));
							button3.setBackground(new java.awt.Color(204,204,51));
							button4.setBackground(new java.awt.Color(204,204,51));
							button5.setBackground(new java.awt.Color(204,204,51));
							button6.setBackground(new java.awt.Color(204,204,51));
							button7.setBackground(new java.awt.Color(204,204,51));
							button8.setBackground(new java.awt.Color(204,204,51));
							button9.setBackground(new java.awt.Color(204,204,102));  // 9 different
							button10.setBackground(new java.awt.Color(204,204,51));
							button11.setBackground(new java.awt.Color(204,204,51));
							button12.setBackground(new java.awt.Color(204,204,51));
							button13.setBackground(new java.awt.Color(204,204,51));
							button14.setBackground(new java.awt.Color(204,204,51));
							button15.setBackground(new java.awt.Color(204,204,51));
							button16.setBackground(new java.awt.Color(204,204,51));
							button17.setBackground(new java.awt.Color(204,204,51));
							button18.setBackground(new java.awt.Color(204,204,51));
							button19.setBackground(new java.awt.Color(204,204,51));
							button20.setBackground(new java.awt.Color(204,204,51));
							button21.setBackground(new java.awt.Color(204,204,51));
							button22.setBackground(new java.awt.Color(204,204,51));
							button23.setBackground(new java.awt.Color(204,204,51));
							button24.setBackground(new java.awt.Color(204,204,51));
							button25.setBackground(new java.awt.Color(204,204,51));	
							levelLabel.setText("5");
							marks++;
							marksLabel.setText("" + marks);
							level = 6;
						}
					}
				});
				button16.setBounds(100, 230, 60, 60);
				//frmColor.getContentPane().add(button16);
				finddifferPanel.add(button16);
				
				button9 = new JButton("");
				button9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {              // level 6
						if(level == 6) {                                         // black
							button1.setBackground(new java.awt.Color(0,0,0));
							button2.setBackground(new java.awt.Color(0,0,0));
							button3.setBackground(new java.awt.Color(0,0,0));
							button4.setBackground(new java.awt.Color(0,0,0));
							button5.setBackground(new java.awt.Color(0,0,0));
							button6.setBackground(new java.awt.Color(0,0,0));
							button7.setBackground(new java.awt.Color(0,0,0));
							button8.setBackground(new java.awt.Color(0,0,0));
							button9.setBackground(new java.awt.Color(0,0,0));
							button10.setBackground(new java.awt.Color(0,0,0));
							button11.setBackground(new java.awt.Color(0,0,0));
							button12.setBackground(new java.awt.Color(0,0,102));  // 12 different
							button13.setBackground(new java.awt.Color(0,0,0));
							button14.setBackground(new java.awt.Color(0,0,0));
							button15.setBackground(new java.awt.Color(0,0,0));
							button16.setBackground(new java.awt.Color(0,0,0));	
							button17.setBackground(new java.awt.Color(0,0,0));
							button18.setBackground(new java.awt.Color(0,0,0));
							button19.setBackground(new java.awt.Color(0,0,0));
							button20.setBackground(new java.awt.Color(0,0,0));
							button21.setBackground(new java.awt.Color(0,0,0));
							button22.setBackground(new java.awt.Color(0,0,0));
							button23.setBackground(new java.awt.Color(0,0,0));
							button24.setBackground(new java.awt.Color(0,0,0));
							button25.setBackground(new java.awt.Color(0,0,0));
							levelLabel.setText("6");
							marks++;
							marksLabel.setText("" + marks);
							level = 7;		
					}
					}
				});
				button9.setBounds(280, 110, 60, 60);
				//frmColor.getContentPane().add(button9);
				finddifferPanel.add(button9);
				
				button12 = new JButton("");
				button12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                     // level 7
						if(level == 7) {                                             // light yellow
							button1.setBackground(new java.awt.Color(255,255,153));
							button2.setBackground(new java.awt.Color(255,255,153));
							button3.setBackground(new java.awt.Color(255,255,153));
							button4.setBackground(new java.awt.Color(255,255,153));
							button5.setBackground(new java.awt.Color(255,255,102));  // 5 different
							button6.setBackground(new java.awt.Color(255,255,153));
							button7.setBackground(new java.awt.Color(255,255,153));
							button8.setBackground(new java.awt.Color(255,255,153));
							button9.setBackground(new java.awt.Color(255,255,153));
							button10.setBackground(new java.awt.Color(255,255,153));
							button11.setBackground(new java.awt.Color(255,255,153));
							button12.setBackground(new java.awt.Color(255,255,153));
							button13.setBackground(new java.awt.Color(255,255,153));
							button14.setBackground(new java.awt.Color(255,255,153));
							button15.setBackground(new java.awt.Color(255,255,153));
							button16.setBackground(new java.awt.Color(255,255,153));
							button17.setBackground(new java.awt.Color(255,255,153));
							button18.setBackground(new java.awt.Color(255,255,153));
							button19.setBackground(new java.awt.Color(255,255,153));
							button20.setBackground(new java.awt.Color(255,255,153));
							button21.setBackground(new java.awt.Color(255,255,153));
							button22.setBackground(new java.awt.Color(255,255,153));
							button23.setBackground(new java.awt.Color(255,255,153));
							button24.setBackground(new java.awt.Color(255,255,153));
							button25.setBackground(new java.awt.Color(255,255,153));
							levelLabel.setText("7");
							marks++;
							marksLabel.setText("" + marks);
							level = 8;		
						}
					}
				});
				button12.setBounds(160, 170, 60, 60);
				//frmColor.getContentPane().add(button12);
				finddifferPanel.add(button12);
				
				button5 = new JButton("");
				button5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                   // level 8
						if(level == 8) {                                           // green
							button1.setBackground(new java.awt.Color(102,255,51)); 
							button2.setBackground(new java.awt.Color(102,255,51));   
							button3.setBackground(new java.awt.Color(102,255,51)); 
							button4.setBackground(new java.awt.Color(51,255,0));   // 4 different
							button5.setBackground(new java.awt.Color(102,255,51)); 
							button6.setBackground(new java.awt.Color(102,255,51)); 
							button7.setBackground(new java.awt.Color(102,255,51)); 
							button8.setBackground(new java.awt.Color(102,255,51)); 
							button9.setBackground(new java.awt.Color(102,255,51)); 
							button10.setBackground(new java.awt.Color(102,255,51)); 
							button11.setBackground(new java.awt.Color(102,255,51)); 
							button12.setBackground(new java.awt.Color(102,255,51)); 
							button13.setBackground(new java.awt.Color(102,255,51)); 
							button14.setBackground(new java.awt.Color(102,255,51)); 
							button15.setBackground(new java.awt.Color(102,255,51)); 
							button16.setBackground(new java.awt.Color(102,255,51)); 
							button17.setBackground(new java.awt.Color(102,255,51)); 
							button18.setBackground(new java.awt.Color(102,255,51)); 
							button19.setBackground(new java.awt.Color(102,255,51)); 
							button20.setBackground(new java.awt.Color(102,255,51)); 
							button21.setBackground(new java.awt.Color(102,255,51)); 
							button22.setBackground(new java.awt.Color(102,255,51)); 
							button23.setBackground(new java.awt.Color(102,255,51)); 
							button24.setBackground(new java.awt.Color(102,255,51)); 
							button25.setBackground(new java.awt.Color(102,255,51)); 
							levelLabel.setText("8");
							marks++;
							marksLabel.setText("" + marks);
							level = 9;			
						}
					}
				});
				button5.setBounds(340, 50, 60, 60);
				//frmColor.getContentPane().add(button5);
				finddifferPanel.add(button5);
				
				button4 = new JButton("");
				button4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                    // level 9
						if(level == 9) {                                            // auburn
							button1.setBackground(new java.awt.Color(102,51,102));
							button2.setBackground(new java.awt.Color(102,51,102));
							button3.setBackground(new java.awt.Color(102,51,102));
							button4.setBackground(new java.awt.Color(102,51,102));
							button5.setBackground(new java.awt.Color(102,51,102));
							button6.setBackground(new java.awt.Color(102,51,102));
							button7.setBackground(new java.awt.Color(102,51,102));
							button8.setBackground(new java.awt.Color(102,51,102));
							button9.setBackground(new java.awt.Color(102,51,102));
							button10.setBackground(new java.awt.Color(102,51,102));
							button11.setBackground(new java.awt.Color(102,0,102));  // 11 different
							button12.setBackground(new java.awt.Color(102,51,102));
							button13.setBackground(new java.awt.Color(102,51,102));
							button14.setBackground(new java.awt.Color(102,51,102));
							button15.setBackground(new java.awt.Color(102,51,102));
							button16.setBackground(new java.awt.Color(102,51,102));
							button17.setBackground(new java.awt.Color(102,51,102));
							button18.setBackground(new java.awt.Color(102,51,102));
							button19.setBackground(new java.awt.Color(102,51,102));
							button20.setBackground(new java.awt.Color(102,51,102));
							button21.setBackground(new java.awt.Color(102,51,102));
							button22.setBackground(new java.awt.Color(102,51,102));
							button23.setBackground(new java.awt.Color(102,51,102));
							button24.setBackground(new java.awt.Color(102,51,102));
							button25.setBackground(new java.awt.Color(102,51,102));
							levelLabel.setText("9");
							marks++;
							marksLabel.setText("" + marks);
							level = 10;	
						}
					}
				});
				button4.setBounds(280, 50, 60, 60);
				//frmColor.getContentPane().add(button4);
				finddifferPanel.add(button4);
				
				button11 = new JButton("");
				button11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {                       // level 10
						if(level == 10) {                                              // skin
							button1.setBackground(new java.awt.Color(255,204,102)); 
							button2.setBackground(new java.awt.Color(255,204,102)); 
							button3.setBackground(new java.awt.Color(255,204,102)); 
							button4.setBackground(new java.awt.Color(255,204,102)); 
							button5.setBackground(new java.awt.Color(255,204,102)); 
							button6.setBackground(new java.awt.Color(255,204,102)); 
							button7.setBackground(new java.awt.Color(255,204,102)); 
							button8.setBackground(new java.awt.Color(255,204,102)); 
							button9.setBackground(new java.awt.Color(255,204,102)); 
							button10.setBackground(new java.awt.Color(255,204,102)); 
							button11.setBackground(new java.awt.Color(255,204,102)); 
							button12.setBackground(new java.awt.Color(255,204,102)); 
							button13.setBackground(new java.awt.Color(255,204,102)); 
							button14.setBackground(new java.awt.Color(255,204,102)); 
							button15.setBackground(new java.awt.Color(255,204,102)); 
							button16.setBackground(new java.awt.Color(255,204,102)); 
							button17.setBackground(new java.awt.Color(255,204,102)); 
							button18.setBackground(new java.awt.Color(255,204,153));   // 18 different
							button19.setBackground(new java.awt.Color(255,204,102)); 
							button20.setBackground(new java.awt.Color(255,204,102)); 
							button21.setBackground(new java.awt.Color(255,204,102)); 
							button22.setBackground(new java.awt.Color(255,204,102)); 
							button23.setBackground(new java.awt.Color(255,204,102)); 
							button24.setBackground(new java.awt.Color(255,204,102)); 
							button25.setBackground(new java.awt.Color(255,204,102)); 
							levelLabel.setText("10");
							marks ++;
							marksLabel.setText("" + marks);	
							level = 0;
						}
					}
				});
				button11.setBounds(100, 170, 60, 60);
				//frmColor.getContentPane().add(button11);
				finddifferPanel.add(button11);
				
				button18 = new JButton("");                                          // level finished
				button18.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(level == 0) {
							clicked = true;
							marks = 10;
							marksLabel.setText("" + marks);	
							String name = JOptionPane.showInputDialog("Well done you had completed all the level! please enter your name! ");
							if(name != null) {
								Store store =new Store();
								store.add_Score(name, marks,"猜不同顏色");
							}
						}
					}
				});
				button18.setBounds(220, 230, 60, 60);
				//frmColor.getContentPane().add(button18);
				finddifferPanel.add(button18);
				
				button2 = new JButton("");
				button2.setBounds(160, 50, 60, 60);
				//frmColor.getContentPane().add(button2);
				finddifferPanel.add(button2);
				
				button3 = new JButton("");
				button3.setBounds(220, 50, 60, 60);
				//frmColor.getContentPane().add(button3);
				finddifferPanel.add(button3);
				
				button6 = new JButton("");
				button6.setBounds(100, 110, 60, 60);
				//frmColor.getContentPane().add(button6);
				finddifferPanel.add(button6);
				
				button21 = new JButton("");
				button21.setBounds(100, 290, 60, 60);
				//frmColor.getContentPane().add(button21);
				finddifferPanel.add(button21);
				
				button7 = new JButton("");
				button7.setBounds(160, 110, 60, 60);
				//frmColor.getContentPane().add(button7);
				finddifferPanel.add(button7);
				
				button17 = new JButton("");
				button17.setBounds(160, 230, 60, 60);
				//frmColor.getContentPane().add(button17);
				finddifferPanel.add(button17);
				
				button22 = new JButton("");
				button22.setBounds(160, 290, 60, 60);
				//frmColor.getContentPane().add(button22);
				finddifferPanel.add(button22);
				
				button23 = new JButton("");
				button23.setBounds(220, 290, 60, 60);
				//frmColor.getContentPane().add(button23);		
				finddifferPanel.add(button23);
				
				button13 = new JButton("");
				button13.setBounds(220, 170, 60, 60);
				//frmColor.getContentPane().add(button13);	
				finddifferPanel.add(button13);
				
				button14 = new JButton("");
				button14.setBounds(280, 170, 60, 60);
				//frmColor.getContentPane().add(button14);
				finddifferPanel.add(button14);
				
				button19 = new JButton("");
				button19.setBounds(280, 230, 60, 60);
				//frmColor.getContentPane().add(button19);
				finddifferPanel.add(button19);
				
				button24 = new JButton("");
				button24.setBounds(280, 290, 60, 60);
				//frmColor.getContentPane().add(button24);	
				finddifferPanel.add(button24);
				
				button20 = new JButton("");
				button20.setBounds(340, 230, 60, 60);
				//frmColor.getContentPane().add(button20);
				finddifferPanel.add(button20);
				
				button15 = new JButton("");
				button15.setBounds(340, 170, 60, 60);
				//frmColor.getContentPane().add(button15);
				finddifferPanel.add(button15);
				
				button10 = new JButton("");
				button10.setBounds(340, 110, 60, 60);
				//frmColor.getContentPane().add(button10);
				finddifferPanel.add(button10);
				
				timeLabel = new JLabel("30");
				timeLabel.setBounds(150, 370, 50, 20);
				//frmColor.getContentPane().add(timeLabel);
				finddifferPanel.add(timeLabel);
				
				marksLabel = new JLabel("0");
				marksLabel.setBounds(150, 400, 50, 20);
				//frmColor.getContentPane().add(marksLabel);
				finddifferPanel.add(marksLabel);
				
				JLabel lblNewLabel = new JLabel("Time:");
				lblNewLabel.setBounds(100, 370, 50, 20);
				//frmColor.getContentPane().add(lblNewLabel);
				finddifferPanel.add(lblNewLabel);
				
				JLabel lblMarks = new JLabel("Marks:");
				lblMarks.setBounds(100, 400, 50, 20);
				//frmColor.getContentPane().add(lblMarks);
				finddifferPanel.add(lblMarks);
				
				/*JButton buttonPause = new JButton("Pause");
				buttonPause.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {				
						Object[] options = {"Yes","No"};
						int n = JOptionPane.showOptionDialog(frmColor, "Continue?","Pause", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
						while(n ==  1) {   // choose no
							 n = JOptionPane.showOptionDialog(frmColor, "Continue?","Pause", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
						}
					}
				});
				buttonPause.setBounds(543, 290, 99, 27);
				frmColor.getContentPane().add(buttonPause);*/
				
				JLabel lblNewLabel_1 = new JLabel("sec");
				lblNewLabel_1.setBounds(190, 370, 50, 20);
				//frmColor.getContentPane().add(lblNewLabel_1);
				finddifferPanel.add(lblNewLabel_1);
				
				lblNewLabel_2 = new JLabel("Level : ");
				lblNewLabel_2.setBounds(100, 20, 50, 20);
				//frmColor.getContentPane().add(lblNewLabel_2);
				finddifferPanel.add(lblNewLabel_2);
				
				levelLabel = new JLabel("0");
				levelLabel.setBounds(200, 20, 50, 20);
				//frmColor.getContentPane().add(levelLabel);
				finddifferPanel.add(levelLabel);
				
				buttonExit = new JButton("Exit");
				buttonExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//System.exit(0);
						exitisclicked = 1;
						layeredPane.removeAll();
						layeredPane.add(mainPanel);
						frame.setTitle("Color Game");
					}
				});
				buttonExit.setForeground(Color.BLACK);
				buttonExit.setBounds(300, 400, 100, 30);
				//frmColor.getContentPane().add(buttonExit);
				finddifferPanel.add(buttonExit);

				
				buttonReStart = new JButton("ReStart");
				buttonReStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// application.restart
					}
				});
				buttonReStart.setForeground(Color.BLACK);
				//buttonReStart.setBounds(300, 440, 100, 30);
				//frmColor.getContentPane().add(buttonReStart);
				//finddifferPanel.add(buttonReStart);
			}
		});
		
		//find differ//////////////////////////////
		///////////////////////////////////////////
		//pick color///////////////////////////////
		startpickcolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pickcolorPanel = new JPanel();
				pickcolorPanel.setLayout(null);
				//pickcolorPanel.add(finddifferPanel, 0, 1);
				pickcolorPanel.setBounds(0, 0, 500, 500);
				pickcolorPanel.setBackground(new Color(150, 202, 244));
				layeredPane.add(pickcolorPanel, 100, 1);
				frame.setTitle("文字顏色猜猜");
				//=====================================
				
				btnNewButton_1 = new JButton("請按下");
				btnNewButton_2 = new JButton("開始歐");
				lblNewLabel = new JLabel("歡迎");
				score_tile = new JLabel();
				score = new JLabel();
				check = new JLabel();
				
				btnNewButton = new JButton("START");
				btnNewButton.setBounds(190, 280, 100, 30);
				pickcolorPanel.add(btnNewButton);
				
				score_tile.setBounds(210, 50, 100, 30);
				score_tile.setText( "score: ");
				score.setBounds(270, 50, 100, 30);
				score.setText("0");
				
				pickcolorPanel.add(score_tile);
				pickcolorPanel.add(score);
				
				lblNewLabel.setFont(new java.awt.Font(Font.DIALOG, 1, 50));
				lblNewLabel.setBounds(190, 200, 120, 60);
				pickcolorPanel.add(lblNewLabel);
				
				btnNewButton_1.setBounds(100, 350, 100, 45);
			    pickcolorPanel.add(btnNewButton_1);
				
				btnNewButton_2.setBounds(290, 350, 100, 45);
				pickcolorPanel.add(btnNewButton_2);
				
				btnNewButton_1.setEnabled(false);
				btnNewButton_2.setEnabled(false);
				
				tt = new SimpleTask();
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						btnNewButton_1.setEnabled(true);
						btnNewButton_2.setEnabled(true);
						if(tt != null) {
							tt.cancel();
						}
						Timer timer = new Timer();
						tt = new SimpleTask();
						timer.schedule(tt, 30000);
						Random rand = new Random();
						int colornum = 0;
					    int choose = 0;
					    String scores = "0";
					    choose = rand.nextInt(2);
						Question creater_1 = new Question();
						//score.setBounds(560, 50, 100, 30);
						score.setText(scores);
						
					    colornum = creater_1.creat(lblNewLabel);
						
						if( choose == 0 ) {// button1 0
							check.setText("0");
							
							switch(colornum) {
							case(0): btnNewButton_1.setText("紅色");
							break;
						    case(1): btnNewButton_1.setText("藍色");
						    break;
						    case(2): btnNewButton_1.setText("綠色");
						    break;
						    case(3): btnNewButton_1.setText("黃色");
						    break;
						    case(4): btnNewButton_1.setText("黑色");
						    break;
						    case(5): btnNewButton_1.setText("白色");
						    break;
						    }
							
							switch(lblNewLabel.getText()){
							case("紅色"):  btnNewButton_2.setText("紅色");
							break;
							case("藍色"):  btnNewButton_2.setText("藍色");
							break;
							case("綠色"):  btnNewButton_2.setText("綠色");
							break;
							case("黃色"): btnNewButton_2.setText("黃色");
							break;
							case("黑色"): btnNewButton_2.setText("黑色");
							break;
							case("白色"): btnNewButton_2.setText("白色");
							break;
							}
						}
						
						else { // button2 1
							check.setText("1");
							switch(colornum){
							case(0): btnNewButton_2.setText("紅色");
							break;
							case(1): btnNewButton_2.setText("藍色");
							break;
							case(2): btnNewButton_2.setText("綠色");
							break;
							case(3): btnNewButton_2.setText("黃色");
							break;
							case(4): btnNewButton_2.setText("黑色");
							break;
							case(5): btnNewButton_2.setText("白色");
							break;
							}
							
							switch(lblNewLabel.getText()){
							case("紅色"): btnNewButton_1.setText("紅色");
							break;
							case("藍色"): btnNewButton_1.setText("藍色");
							break;
							case("綠色"): btnNewButton_1.setText("綠色");
							break;
							case("黃色"): btnNewButton_1.setText("黃色");
							break;
							case("黑色"): btnNewButton_1.setText("黑色");
							break;
							case("白色"): btnNewButton_1.setText("白色");
							break;
							}
						}
						btnNewButton.setBounds(520, 20, 100, 30);
						btnNewButton.setText("RESTART");
					}
				});
				
			   btnNewButton_1.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e) { 
					   //START button
					   int colornum = 0;
					   int choose = 0;
					   int get = 0;
						
					   get = Integer.valueOf(score.getText());
					   tt.score = get;
					  
					   Random rand = new Random();
					   choose = rand.nextInt(2);
						
					   Question creater_2 = new Question();
					   
					   if(check.getText() != "0") {
						   lblNewLabel.setText("Game over !");
						   lblNewLabel.setBounds(100, 200, 300, 60);
						   tt.cancel();
						   btnNewButton_1.setEnabled(false);
						   btnNewButton_2.setEnabled(false);
						   String inputname = JOptionPane.showInputDialog("please enter your name!");
						   if(inputname != null) {
								Store store =new Store();
								store.add_Score(inputname, tt.score,"文字顏色猜猜");
						   }
					   }
					  
					   else{
						   colornum = creater_2.creat(lblNewLabel);
						   if(choose == 0) { // button1 0
							   check.setText("0");	
							   switch(colornum){
							   case(0): btnNewButton_1.setText("紅色");
							   break;
							   case(1): btnNewButton_1.setText("藍色");
							   break;
							   case(2): btnNewButton_1.setText("綠色");
							   break;
							   case(3): btnNewButton_1.setText("黃色");
							   break;
							   case(4): btnNewButton_1.setText("黑色");
							   break;
							   case(5): btnNewButton_1.setText("白色");
							   break;
							   }		
							   
							   switch(lblNewLabel.getText()){
							   case("紅色"): btnNewButton_2.setText("紅色");
							   break;
							   case("藍色"): btnNewButton_2.setText("藍色");
							   break;
							   case("綠色"): btnNewButton_2.setText("綠色");
							   break;
							   case("黃色"): btnNewButton_2.setText("黃色");
							   break;
							   case("黑色"): btnNewButton_2.setText("黑色");
							   break;
							   case("白色"): btnNewButton_2.setText("白色");
							   break;
							   }
						   }
							
						   else { // button2 1
							   check.setText("1");
							   switch(colornum){
							   case(0): btnNewButton_2.setText("紅色");
							   break;
							   case(1): btnNewButton_2.setText("藍色");
							   break;
							   case(2): btnNewButton_2.setText("綠色");
							   break;
							   case(3): btnNewButton_2.setText("黃色");
							   break;
							   case(4): btnNewButton_2.setText("黑色");
							   break;
							   case(5): btnNewButton_2.setText("白色");
							   break;
							   }
							   
							   switch(lblNewLabel.getText()){
							   case("紅色"): btnNewButton_1.setText("紅色");
							   break;
							   case("藍色"): btnNewButton_1.setText("藍色");
							   break;
							   case("綠色"): btnNewButton_1.setText("綠色");
							   break;
							   case("黃色"): btnNewButton_1.setText("黃色");
							   break;
							   case("黑色"): btnNewButton_1.setText("黑色");
							   break;
							   case("白色"): btnNewButton_1.setText("白色");
							   break;
							   }
						   }
						   get++;
						   tt.score = get;
						   score.setText(String.valueOf(get));  
					   }			
				   }	
			   });
			   
			   btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { //START button
						int colornum = 0;
					    int choose = 0;
					    int get = 0;
					    get = Integer.valueOf(score.getText());
					    tt.score = get;
					    
					    Random rand = new Random();
					    choose = rand.nextInt(2);	
					    Question creater_2 = new Question();
							
					    if(check.getText() != "1") {
					    	lblNewLabel.setText("Game over !");
					    	lblNewLabel.setBounds(100, 200, 300, 60);
					    	tt.cancel();
					    	btnNewButton_1.setEnabled(false);
							btnNewButton_2.setEnabled(false);
					    	String inputname = JOptionPane.showInputDialog("please enter your name!");
					    	if(inputname != null) {
								Store store =new Store();
								store.add_Score(inputname, tt.score,"文字顏色猜猜");
					    	}
					    }
						else {
							colornum = creater_2.creat(lblNewLabel);
							if( choose == 0 ) { // button1 0
								check.setText("0");	
								switch(colornum) {
								case(0): btnNewButton_1.setText("紅色");
								break;
								case(1): btnNewButton_1.setText("藍色");
								break;
								case(2): btnNewButton_1.setText("綠色");
								break;
								case(3): btnNewButton_1.setText("黃色");
								break;
								case(4): btnNewButton_1.setText("黑色");
								break;
								case(5): btnNewButton_1.setText("白色");
								break;
								}		
								
								switch(lblNewLabel.getText()) {
								case("紅色"):  btnNewButton_2.setText("紅色");
								break;
								case("藍色"):  btnNewButton_2.setText("藍色");
								break;
								case("綠色"):  btnNewButton_2.setText("綠色");
								break;
								case("黃色"): btnNewButton_2.setText("黃色");
								break;
								case("黑色"): btnNewButton_2.setText("黑色");
								break;
								case("白色"): btnNewButton_2.setText("白色");
								break;
								}
							}
							
							else { // button2 1
								check.setText("1");
								switch(colornum) {
								case(0): btnNewButton_2.setText("紅色");
								break;
								case(1): btnNewButton_2.setText("藍色");
								break;
								case(2): btnNewButton_2.setText("綠色");
								break;
								case(3): btnNewButton_2.setText("黃色");
								break;
								case(4): btnNewButton_2.setText("黑色");
								break;
								case(5): btnNewButton_2.setText("白色");
								break;
								}
								
								switch(lblNewLabel.getText()){
								case("紅色"): btnNewButton_1.setText("紅色");
								break;
								case("藍色"): btnNewButton_1.setText("藍色");
								break;
								case("綠色"): btnNewButton_1.setText("綠色");
								break;
								case("黃色"): btnNewButton_1.setText("黃色");
								break;
								case("黑色"): btnNewButton_1.setText("黑色");
								break;
								case("白色"): btnNewButton_1.setText("白色");
								break;
					    		}
							}
							get++;
							tt.score = get;
							score.setText(String.valueOf(get));
						}
					}
			   	});
			   	buttonExit = new JButton("Exit");
				buttonExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//exitisclicked = 1;
						layeredPane.removeAll();
						layeredPane.add(mainPanel);
						tt.cancel();
						frame.setTitle("Color Game");
					}
				});
				buttonExit.setForeground(Color.BLACK);
				buttonExit.setBounds(350, 10, 100, 30);
				//frmColor.getContentPane().add(buttonExit);
				pickcolorPanel.add(buttonExit);
			}
		});
		
		//pick color///////////////////////////////
		///////////////////////////////////////////
		//record///////////////////////////////////
		record.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				recordPanel = new JPanel();
				recordPanel.setLayout(null);
				//layeredPane.add(recordPanel, 0, 1);
				recordPanel.setBounds(0, 0, 500, 500);
				recordPanel.setBackground(new Color(13, 68, 113));
				layeredPane.add(recordPanel, 100, 1);
				frame.setTitle("紀錄");
				//=====================================
				
				//frame = new JFrame();
				//frame.setBounds(100, 100, 450, 432);
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
				recordPanel.setLayout(new GridLayout(0, 1, 0, 0));
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);		
				tabbedPane.setFont(new Font("微軟正黑體", Font.BOLD, 18));
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				tabbedPane.setBackground(Color.PINK);
				
				//frame.getContentPane().add(tabbedPane);
				recordPanel.add(tabbedPane);
				
				//The score of two game ---遊戲名稱改的話要改這裡
				tabbedPane.addTab("文字顏色猜猜", to_Tag("文字顏色猜猜")) ;
				tabbedPane.addTab("猜不同顏色", to_Tag("猜不同顏色"));
				
				buttonExit = new JButton("Exit");
				buttonExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.removeAll();
						layeredPane.add(mainPanel);
						frame.setTitle("Color Game");
					}
				});
				buttonExit.setForeground(Color.BLACK);
				buttonExit.setBounds(380, 5, 100, 20);
				layeredPane.add(buttonExit, 100, 0);
			}
		});
		
		//record///////////////////////////////////
		///////////////////////////////////////////
		///////////////////////////////////////////
		
	}
	
	
	///////////////////////////////////////////
	///////////////////////////////////////////
	///////////////////////////////////////////
	public void buttonDisable() {
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
		button10.setEnabled(false);
		button11.setEnabled(false);
		button12.setEnabled(false);
		button13.setEnabled(false);
		button14.setEnabled(false);
		button15.setEnabled(false);
		button16.setEnabled(false);
		button17.setEnabled(false);
		button18.setEnabled(false);
		button19.setEnabled(false);
		button20.setEnabled(false);
		button21.setEnabled(false);
		button22.setEnabled(false);
		button23.setEnabled(false);
		button24.setEnabled(false);
		button25.setEnabled(false);
    }
	
	public JPanel add_Record_to_View(int i,String playername,int playerscore) {	
		JPanel addJ = new JPanel();		
		addJ.setBounds(0, 0+50*i, frame.getWidth(), 50);
		addJ.setLayout(null);
		//rank
		JLabel rank = new JLabel(String.valueOf(i+1));
		rank.setFont(new Font("標楷體", Font.BOLD, 25));
		rank.setForeground(Color.WHITE);
		rank.setBounds(10, 0, 45, 50);
		addJ.add(rank);
		//name
		JLabel name = new JLabel(playername);
		name.setBounds(80, 0, 200, 50);
		name.setFont(new Font("標楷體", Font.BOLD, 23));
		name.setForeground(Color.WHITE);
		addJ.add(name);
		//score
		JLabel score = new JLabel(String.valueOf(playerscore));
		score.setBounds(280, 0, 90, 50);
		score.setFont(new Font("標楷體", Font.BOLD, 23));
		score.setForeground(Color.WHITE);
		addJ.add(score);
		addJ.setBackground(Color.DARK_GRAY);
		return addJ;
	}
	
	public JScrollPane to_Tag(String game_name) {
		inform=store.get_Data(game_name);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400,50*inform.size()));	
		
		///load the record
		for(int i=0;i<inform.size();++i) {
			if(inform.size()==0) {
				break;
			}
			panel.add(add_Record_to_View(i,inform.get(i).get_name(),inform.get(i).get_score()));							
		}

		scrollPane.setViewportView(panel);
		return scrollPane;
	}
}
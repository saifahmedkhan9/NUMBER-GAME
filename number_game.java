import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.String.*;

class number_game implements ActionListener
{
	JFrame jfr;
	JButton jb[];
	JMenu menu;
	JMenuBar menubar;
	JMenuItem menuitem,menuitem1;
	int i=0,j=0,k=0;
	char b[]=new char[10];
	char a[][]=new char[8][8];
	String swap=new String("");
	String user = JOptionPane.showInputDialog("Enter Your Name :");
	char val1[]={'1','2','3','4','8','5','7','6'};
	char val[]=new char[9];
	Random rand=new Random();
	int r=rand.nextInt(9);
	number_game()
	{
		
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				if(r==8)
				{
					r=0;
					j--;
				}
				else
				{
					a[i][j]=val1[r++];
				}
				if(i==2 && j==2)
				{
					a[i][j]='*';
				}

			}
		}
		i=0;
		jb=new JButton[10];
		jfr=new JFrame("NUMBER GAME");
		for(k=0;k<3;k++)
		{	
			for(j=0;j<3;j++)
			{
				jb[i]=new JButton();
				jb[i].setText(String.valueOf(a[k][j]));
				jfr.add(jb[i]);
				jb[i].addActionListener(this);
				i++;
			}
		}
		menubar=new JMenuBar();
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		menubar.add(menu);
		menuitem = new JMenuItem("Restart",KeyEvent.VK_R);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		menuitem.addActionListener(this);
		menu.add(menuitem);
		//Next Menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_N);
		menubar.add(menu);
		jfr.setJMenuBar(menubar);
		menuitem1=new JMenuItem("About Game",KeyEvent.VK_A);
		menuitem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menuitem1.addActionListener(this);
		menu.add(menuitem1);
		jfr.setLayout(new GridLayout(3,3,0,0));
		jfr.setSize(400,400);
		jfr.setVisible(true);

		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		Random rand=new Random();
		r=rand.nextInt(9);
		if(e.getSource()==menuitem)
		{
			for(i=0;i<3;i++)
			{
				for(j=0;j<3;j++)
				{
					if(r==8)
					{
						r=0;
						j--;
					}
					else
					{
						a[i][j]=val1[r++];
					}
					if(i==2 && j==2)
					{
						a[i][j]='*';
					}

				}
			}
			i=0;
			for(k=0;k<3;k++)
			{	
				for(j=0;j<3;j++)
				{
					jb[i].setText(String.valueOf(a[k][j]));
					i++;
				}
			}
			k=0;
			j=0;
		}

		if(e.getSource()==menuitem1)
		{

			String p1="<html><body width='";
			String p2="'><h1>HOW TO PLAY!</h1>" +
                    "<p>You have to arrange the number in the Series :<br>" +
                    " {1,2,3,4,5,6,7,8,*}" +
                    " by swapping the number with star('*').<br>";
            int width= 175;
            String s=p1+width+p2;
            final ImageIcon icon = new ImageIcon("E:\\saif\\assignment\\extra programs\\image\\num_game.jpg");
            JOptionPane.showMessageDialog(null,s,"About",JOptionPane.INFORMATION_MESSAGE, icon);
		}

		if(e.getSource()==jb[0])
		{	

			if(a[0][1]=='*')
			{
				
				swap=jb[0].getText();
				jb[0].setText(jb[1].getText());
				a[0][0]=(jb[0].getText()).charAt(0);
				jb[1].setText(swap);
				a[0][1]=(jb[1].getText()).charAt(0);
				check(a);
			}
			else if(a[1][0]=='*')
			{
				

				swap=jb[0].getText();
				jb[0].setText(jb[3].getText());
				a[0][0]=(jb[0].getText()).charAt(0);
				jb[3].setText(swap);
				check(a);a[1][0]=(jb[3].getText()).charAt(0);

			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[1])
		{	

			if(a[0][0]=='*')
			{
				
				swap=jb[1].getText();
				jb[1].setText(jb[0].getText());
				a[0][1]=(jb[1].getText()).charAt(0);
				jb[0].setText(swap);
				a[0][0]=(jb[0].getText()).charAt(0);
				check(a);
			}
			else if(a[0][2]=='*')
			{
				

				swap=jb[2].getText();
				jb[2].setText(jb[1].getText());
				a[0][2]=(jb[2].getText()).charAt(0);
				jb[1].setText(swap);
				check(a);a[0][1]=(jb[1].getText()).charAt(0);

			}
			else if(a[1][1]=='*')
			{
				

				swap=jb[4].getText();
				jb[4].setText(jb[1].getText());
				a[1][1]=(jb[4].getText()).charAt(0);
				jb[1].setText(swap);
				check(a);a[0][1]=(jb[1].getText()).charAt(0);

			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[2])
		{	

			if(a[0][1]=='*')
			{
				
				swap=jb[1].getText();
				jb[1].setText(jb[2].getText());
				a[0][1]=(jb[1].getText()).charAt(0);
				jb[2].setText(swap);
				a[0][2]=(jb[2].getText()).charAt(0);
				check(a);
			}
			else if(a[1][2]=='*')
			{


				swap=jb[5].getText();
				jb[5].setText(jb[2].getText());
				a[1][2]=(jb[5].getText()).charAt(0);
				jb[2].setText(swap);
				check(a);a[0][2]=(jb[2].getText()).charAt(0);

			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[3])
		{	

			if(a[0][0]=='*')
			{
				
				swap=jb[3].getText();
				jb[3].setText(jb[0].getText());
				a[1][0]=(jb[3].getText()).charAt(0);
				jb[0].setText(swap);
				a[0][0]=(jb[0].getText()).charAt(0);
				check(a);
			}
			else if(a[1][1]=='*')
			{
				
				swap=jb[3].getText();
				jb[3].setText(jb[4].getText());
				a[1][0]=(jb[3].getText()).charAt(0);
				jb[4].setText(swap);
				a[1][1]=(jb[4].getText()).charAt(0);
				check(a);
			}
			else if(a[2][0]=='*')
			{
				
				swap=jb[3].getText();
				jb[3].setText(jb[6].getText());
				a[1][0]=(jb[3].getText()).charAt(0);
				jb[6].setText(swap);
				a[2][0]=(jb[6].getText()).charAt(0);
				check(a);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[4])
		{	

			if(a[0][1]=='*')
			{
				
				swap=jb[4].getText();
				jb[4].setText(jb[1].getText());
				a[1][1]=(jb[4].getText()).charAt(0);
				jb[1].setText(swap);
				a[0][1]=(jb[1].getText()).charAt(0);
				check(a);
			}
			else if(a[1][0]=='*')
			{
				
				swap=jb[4].getText();
				jb[4].setText(jb[3].getText());
				a[1][1]=(jb[4].getText()).charAt(0);
				jb[3].setText(swap);
				a[1][0]=(jb[3].getText()).charAt(0);
				check(a);
			}
			else if(a[1][2]=='*')
			{
				
				swap=jb[4].getText();
				jb[4].setText(jb[5].getText());
				a[1][1]=(jb[4].getText()).charAt(0);
				jb[5].setText(swap);
				a[1][2]=(jb[5].getText()).charAt(0);
				check(a);
			}
			else if(a[2][1]=='*')
			{
				
				swap=jb[4].getText();
				jb[4].setText(jb[7].getText());
				a[1][1]=(jb[4].getText()).charAt(0);
				jb[7].setText(swap);
				a[2][1]=(jb[7].getText()).charAt(0);
				check(a);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[5])
		{	

			if(a[0][2]=='*')
			{
				
				swap=jb[5].getText();
				jb[5].setText(jb[2].getText());
				a[1][2]=(jb[5].getText()).charAt(0);
				jb[2].setText(swap);
				a[0][2]=(jb[2].getText()).charAt(0);
				check(a);
			}
			else if(a[1][1]=='*')
			{
				
				swap=jb[5].getText();
				jb[5].setText(jb[4].getText());
				a[1][2]=(jb[5].getText()).charAt(0);
				jb[4].setText(swap);
				a[1][1]=(jb[4].getText()).charAt(0);
				check(a);
			}
			else if(a[2][2]=='*')
			{
				
				swap=jb[5].getText();
				jb[5].setText(jb[8].getText());
				a[1][2]=(jb[5].getText()).charAt(0);
				jb[8].setText(swap);
				a[2][2]=(jb[8].getText()).charAt(0);
				check(a);
			} 
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[6])
		{	

			if(a[1][0]=='*')
			{
				
				swap=jb[6].getText();
				jb[6].setText(jb[3].getText());
				a[2][0]=(jb[6].getText()).charAt(0);
				jb[3].setText(swap);
				a[1][0]=(jb[3].getText()).charAt(0);
				check(a);
			}
			else if(a[2][1]=='*')
			{
				
				swap=jb[6].getText();
				jb[6].setText(jb[7].getText());
				a[2][0]=(jb[6].getText()).charAt(0);
				jb[7].setText(swap);
				a[2][1]=(jb[7].getText()).charAt(0);
				check(a);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[7])
		{	

			if(a[2][0]=='*')
			{
				
				swap=jb[7].getText();
				jb[7].setText(jb[6].getText());
				a[2][1]=(jb[7].getText()).charAt(0);
				jb[6].setText(swap);
				a[2][0]=(jb[6].getText()).charAt(0);
				check(a);
			}
			else if(a[1][1]=='*')
			{
				
				swap=jb[7].getText();
				jb[7].setText(jb[4].getText());
				a[2][1]=(jb[7].getText()).charAt(0);
				jb[4].setText(swap);
				a[1][1]=(jb[4].getText()).charAt(0);
				check(a);
			}
			else if(a[2][2]=='*')
			{
				
				swap=jb[7].getText();
				jb[7].setText(jb[8].getText());
				a[2][1]=(jb[7].getText()).charAt(0);
				jb[8].setText(swap);
				a[2][2]=(jb[8].getText()).charAt(0);
				check(a);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(e.getSource()==jb[8])
		{	

			if(a[2][1]=='*')
			{
				
				swap=jb[8].getText();
				jb[8].setText(jb[7].getText());
				a[2][2]=(jb[8].getText()).charAt(0);
				jb[7].setText(swap);
				a[2][1]=(jb[7].getText()).charAt(0);
				check(a);
			}
			else if(a[1][2]=='*')
			{
				
				swap=jb[8].getText();
				jb[8].setText(jb[5].getText());
				a[2][2]=(jb[8].getText()).charAt(0);
				jb[5].setText(swap);
				a[1][2]=(jb[5].getText()).charAt(0);
				check(a);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shifting Not Possible..","Menu",JOptionPane.PLAIN_MESSAGE);
			}
		}
		for(i=0;i<3;i++)
			for(j=0;j<3;j++)
				System.out.println(a[i][j]);
		}
		
		public void check(char arr[][])
		{
			k=0;
			int flag=1;	
			char v[]={'1','2','3','4','5','6','7','8','*'};
			for(i=0;i<3;i++)
			{
				for(j=0;j<3;j++)
				{
					if(arr[i][j]!=v[k])
					{
						flag=0;	
					}	
					k++;
				}
			}
			if(flag==1)
			{
				JOptionPane.showMessageDialog(null,"Congrats "+user+" YOU WON..","Congrats",JOptionPane.PLAIN_MESSAGE);
			}
		}
		public static void main(String args[])
		{
			new number_game();
		}
	}
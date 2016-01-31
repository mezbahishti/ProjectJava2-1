import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class front_page extends JFrame
{
	 private JButton button1;
	 private JButton button2;
	 private JButton button3;
	 private BorderLayout layout;
	 private Color color=Color.darkGray;
	 private LookAndFeelInfo[] looks;
	 private JPanel panelimg;
	 private JPanel panel;
	 private Border line;

	 private JLabel label;
	 public front_page(){
		 super("Folder Lock");



		setLayout(null);
	 }
	 public void frontPageLayout(){

		Icon i1=new ImageIcon("icon1.png");
		Icon i2=new ImageIcon("icon2.png");
		Icon i3=new ImageIcon("icon3.png");

		button1=new JButton("Lock a folder");
		button2=new JButton("Unlock your folder");
		button3=new JButton("Exit");
		label=new JLabel("Do you wish to exit?");




		//setting icon
		Font font = new Font("Verdana", Font.BOLD, 12);
		button1.setFont(font);

		button2.setFont(font);
		button3.setFont(font);
		//setting icon
		button1.setIcon(i1);
		button2.setIcon(i2);
		button3.setIcon(i3);
		button1.setOpaque(false);

	//size button1 as of button2
		Dimension size=button2.getPreferredSize();
		button1.setPreferredSize(size);
		button3.setPreferredSize(size);

		Color btncolor=new Color(64,52,102);

		button1.setBackground(btncolor);
		button2.setBackground(btncolor);
		button3.setBackground(btncolor);





		//changing location of buttons
		Dimension a=button1.getPreferredSize();
		int w1=a.width;
		int h1=a.height;
		button1.setBounds(100,90 , w1, h1);

		Dimension b=button2.getPreferredSize();
		int w2=b.width;
		int h2=b.height;
		button2.setBounds(100, 140, w2, h2);

		Dimension ex=button3.getPreferredSize();
		int w3=ex.width;
		int h3=ex.height;
		button3.setBounds(100, 190, w3, h3);

		//bordering buttons
		button1.setOpaque(false);
		button2.setOpaque(false);
		button3.setOpaque(false);



		line=BorderFactory.createLineBorder(Color.black, 1, true);
		button1.setBorder(line);
		button2.setBorder(line);
		button3.setBorder(line);

		button1.setForeground(Color.black);
		button2.setForeground(Color.black);
		button3.setForeground(Color.black);


		final Container c=getContentPane();
		c.setLayout(null);
		ImageIcon imgi=new ImageIcon("background.jpeg");
		c.setBackground(color);
		add(button1);
		add(button2);
		add(button3);


	panelimg=new JPanel(){
		 public void paintComponent(Graphics g){
			 Image ano=new ImageIcon("background.jpeg").getImage();
			 Dimension imgsize=new Dimension(ano.getWidth(null),ano.getHeight(null));
			 setPreferredSize(imgsize);
	         setMinimumSize(imgsize);
	         setMaximumSize(imgsize);
	         setSize(imgsize);
	         setLayout(null);
	         g.drawImage(ano, 0, 0, null);
		 }
	};
	add(panelimg);

	panelimg.setBounds(0, 0, imgi.getIconWidth(),imgi.getIconHeight());



		Button1Handler handler1=new Button1Handler();
		button1.addActionListener(handler1);
		//button2.addActionListener(handler);

		Button3Handler handler3=new Button3Handler();
		button3.addActionListener(handler3);



		//unlock handling
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {



					//	TAKING FOLDERS TO UNLOCK

					FileDemonstration unlock=new FileDemonstration();
					File toUnlock=unlock.getFile();
					String x=toUnlock.getName();


					//TAKING FOLDER PASSWORD TO VERIFY
					takePassword unlock_folder=new takePassword();
					String unLockPassword=unlock_folder.take_folder_password();


					//ENCRYPTING IT
					encryptPassword epxx=new encryptPassword();
					String recover_folder_pass=epxx.encryptionMD5(unLockPassword);


					//CUTTING THE FILE EXT
					int i = x.indexOf('.');
					String solve=x.substring(0, i);
					String solve1=solve+".txt";



					//READING PASSWORD FROM TXT FILE TO VERIFY
					readMasterPassword fpword=new readMasterPassword();
					String read_folder_pass=fpword.get_password(solve1);



					//VERIFYING
					if(read_folder_pass.equals(recover_folder_pass)){


						//RENAMING TO UNLOCK
					File oldname=new File(toUnlock.getParentFile(),solve);
					toUnlock.renameTo(oldname);
					JOptionPane.showConfirmDialog(null, "You have successfully unlocked your folder","confirm",JOptionPane.PLAIN_MESSAGE);


					//opening the folder

					String path=oldname.getAbsolutePath();


					 File foler = new File(path); // path to the directory to be opened

				      Desktop desktop = null;

				      if (Desktop.isDesktopSupported()) {

				      desktop = Desktop.getDesktop();

				      }

				      try {


				      desktop.open(foler);


				      } catch (IOException ex) {
				      }




				      //Deleting the txtfile

					File toDelete=new File(solve1);
					toDelete.delete();


					read_file_name rfn=new read_file_name();

					}

					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Password","Sorry!",JOptionPane.WARNING_MESSAGE);
					}


				} catch (IOException e1) {


					e1.printStackTrace();
				}

			}
		});








		//adding menubar










		JMenuBar menubar=new JMenuBar();
		JMenu file=new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenu setting=new JMenu("Settings");
		setting.setMnemonic(KeyEvent.VK_F);

		JMenuItem exit=new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);

		JMenuItem change_theme=new JMenuItem("change theme");
		change_theme.setMnemonic(KeyEvent.VK_C);

		//menuitem:exit listener

		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				int in=JOptionPane.showConfirmDialog(null,label,"Exit",JOptionPane.OK_CANCEL_OPTION);
				if(in==JOptionPane.CANCEL_OPTION){
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
				else{
					System.exit(0);
				}

			}
		});

		change_theme.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			color = JColorChooser.showDialog(
					front_page.this, "Choose a color", color );
			if ( color == null )
			 color = Color.blue;


			c.setBackground(color);
		}
		});
		file.add(exit);
		menubar.add(file);

		setting.add(change_theme);
		menubar.add(setting);

		setJMenuBar(menubar);


	 }


	 private class Button1Handler implements ActionListener{
		 public void actionPerformed(ActionEvent event){
			try {

				FileDemonstration a=new FileDemonstration();

				a.setDefaultCloseOperation(EXIT_ON_CLOSE);
				a.choose_folder();


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }

	 private class Button3Handler implements ActionListener{

		 public void actionPerformed(ActionEvent event){

				int in=JOptionPane.showConfirmDialog(null,label,"Exit",JOptionPane.OK_CANCEL_OPTION);
				if(in==JOptionPane.CANCEL_OPTION){
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
				else{
					System.exit(0);
				}
		 }
	 }



	 private void changeTheLookAndFeel( )
	  {
	  try // change look-and-feel
	  {

		  UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());



	  } // end try
	  catch ( Exception exception )
	  {
	  exception.printStackTrace();
	  } // end catch
	  }


public static void main(String[]args)
{
	front_page fff=new front_page();
	fff.frontPageLayout();
	fff.changeTheLookAndFeel();

	}
}

    /button_with_image         *� ,org.eclipse.jdt.launching.jreContainerMarker  message �Build path specifies execution environment J2SE-1.5. There are no JREs installed in the workspace that are strictly compatible with this environment.  location 
Build path severity     A,��� '/button_with_image/src/ButtonFrame.java         *� org.eclipse.jdt.core.problem 	 id   ` message fThe serializable class ButtonFrame does not declare a static final serialVersionUID field of type long 	arguments 1:ButtonFrame 
categoryId   Z 	charStart   
lineNumber    severity    charEnd   sourceId JDT  A,���                                                                                                                                                                                                                                                                                                                                                                                                        d.width;
		ok.setBounds(100, 100, width, height);
		cancel.setBounds(140, 100, width, height);
		
		masterLabel=new JLabel("Enter Master Password:");
		Font font=new Font("Verdana",Font.BOLD,12);
		masterLabel.setFont(font);
		masterLabel.setLabelFor(masterPanel);
		
		
		
		masterPanel.add(masterLabel);
		masterPanel.add(masterPass);
		masterPanel.setLocation(40, 40);
		masterPanel.add(ok);
		masterPanel.add(cancel);

	
		
	add(masterPanel);
	
	
	setSize(300,300);
	setLocation(40,20);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);	
	
	
	

	
	ok.addActionListener(new ActionListener(){
	
	public void actionPerformed(ActionEvent e){
	
		
		final char[] masterpassword=masterPass.getPassword();
		
		String str=new String(masterpassword);
		
			
			if(str.length()!=0){
				
				File file=new File("master.txt");
				if(file.length()==0){
					
				
				encryptPassword encrptmaster=new encryptPassword();
				String the_encrypted_master=encrptmaster.encryptionMD5(str);
				
				//write encrypted master pass in file
				writeEncrypted write_master=new writeEncrypted();
				write_master.write("master", the_encrypted_master);
				}
				else
				{
					
					//taking masterpass from file
					readMasterPassword rmp=new readMasterPassword();
					String gotcha=rmp.get_password("master.txt");
					
					
					encryptPassword verif=new encryptPassword();
					String toverifi=verif.encryptionMD5(str);
					
					//verified
					if(toverifi.equals(gotcha)){
						front_page fp_if_ok=new front_page();
						fp_if_ok.frontPageLayout();
						fp_if_ok.setSize(400, 400);
						fp_if_ok.setVisible(true);
						setVisible(false);
						
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Wrong Master Password !!","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
				
		
				
				
			
			}
			else if(str.length()==0){
				master_password again=new master_password();
				
			}
			
			
			
		}
	});
	cancel.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			int in=JOptionPane.showConfirmDialog(null,exitLabel,"Exit",JOptionPane.OK_CANCEL_OPTION);
			if(in==JOptionPane.CANCEL_OPTION){
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
			else{
				System.exit(0);
			}
			
		}
	});
	
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
	

	
	public static void main(String[] args) {
		master_password ms=new master_password();
		ms.changeTheLookAndFeel();
		ms.work();
		ms.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		

	}

}

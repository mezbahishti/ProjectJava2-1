    6C:/Program Files/Java/jre7/lib/ext/sunjce_provider.jar  =�ON .C:/Program Files/Java/jre7/lib/ext/jaccess.jar  =�L�� ,C:/Program Files/Java/jre7/lib/ext/dnsns.jar  =�L!- +C:/Program Files/Java/jre7/lib/charsets.jar  =ˁ� 4C:/Program Files/Java/jre7/lib/ext/access-bridge.jar  =�MG+ ,C:/Program Files/Java/jre7/lib/ext/sunec.jar  =�L<� 1C:/Program Files/Java/jre7/lib/ext/localedata.jar  =�[�� ,C:/Program Files/Java/jre7/lib/resources.jar  =�q�d 'C:/Program Files/Java/jre7/lib/jsse.jar  =�T� &C:/Program Files/Java/jre7/lib/jce.jar  =�M�� 0C:/Program Files/Java/jre7/lib/ext/sunmscapi.jar  =�Lv� 0C:/Program Files/Java/jre7/lib/ext/sunpkcs11.jar  =�O�� &C:/Program Files/Java/jre7/lib/jfr.jar  =�S� %C:/Program Files/Java/jre7/lib/rt.jar  =�`�� ,C:/Program Files/Java/jre7/lib/ext/zipfs.jar  =�M
�                                                                                                                                                                                                          penDialog(SimpleFileChooser.this);
        if (option == JFileChooser.APPROVE_OPTION) {
          File[] sf = chooser.getSelectedFiles();
          String filelist = "nothing";
          if (sf.length > 0) filelist = sf[0].getName();
          for (int i = 1; i < sf.length; i++) {
            filelist += ", " + sf[i].getName();
          }
          statusbar.setText("You chose " + filelist);
        }
        else {
          statusbar.setText("You canceled.");
        }
      }
    });

    // Create a file chooser that opens up as a Save dialog
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(SimpleFileChooser.this);
        if (option == JFileChooser.APPROVE_OPTION) {
          statusbar.setText("You saved " + ((chooser.getSelectedFile()!=null)?
                            chooser.getSelectedFile().getName():"nothing"));
        }
        else {
          statusbar.setText("You canceled.");
        }
      }
    });

    // Create a file chooser that allows you to pick a directory
    // rather than a file
    dirButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = chooser.showOpenDialog(SimpleFileChooser.this);
        if (option == JFileChooser.APPROVE_OPTION) {
          statusbar.setText("You opened " + ((chooser.getSelectedFile()!=null)?
                            chooser.getSelectedFile().getName():"nothing"));
        }
        else {
          statusbar.setText("You canceled.");
        }
      }
    });

    c.add(openButton);
    c.add(saveButton);
    c.add(dirButton);
    c.add(statusbar);
  }

  public static void main(String args[]) {
    SimpleFileChooser sfc = new SimpleFileChooser();
    sfc.setVisible(true);
  }
}

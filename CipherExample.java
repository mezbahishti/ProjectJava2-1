    /frame/src/basic.java         + org.eclipse.jdt.core.problem 	 id � message .The import java.awt.BorderLayout is never used 	arguments 1:java.awt.BorderLayout 
categoryId   x 	charStart   ? 
lineNumber    severity    charEnd   T sourceId JDT  A,��?      +     	 id � message /The import javax.swing.JTextField is never used 	arguments 1:javax.swing.JTextField 
categoryId   x 	charStart   � 
lineNumber   
 severity    charEnd   sourceId JDT  A,��?      +     	 id � message 8The import javax.swing.border.TitledBorder is never used 	arguments !1:javax.swing.border.TitledBorder 
categoryId   x 	charStart  1 
lineNumber    severity    charEnd  P sourceId JDT  A,��?      +     	 id � message 6The import java.awt.event.ActionListener is never used 	arguments 1:java.awt.event.ActionListener 
categoryId   x 	charStart  w 
lineNumber    severity    charEnd  � sourceId JDT  A,��?      +     	 id � message 3The import java.awt.event.ActionEvent is never used 	arguments 1:java.awt.event.ActionEvent 
categoryId   x 	charStart  � 
lineNumber    severity    charEnd  � sourceId JDT  A,��?      +     	 id   ` message `The serializable class basic does not declare a static final serialVersionUID field of type long 	arguments 1:basic 
categoryId   Z 	charStart  � 
lineNumber    severity    charEnd  � sourceId JDT  A,��?      +     	 id   ` message [The serializable class  does not declare a static final serialVersionUID field of type long 	arguments 1:    
categoryId   Z 	charStart  Q 
lineNumber    severity    charEnd  Y sourceId JDT  A,��?                                                                                                                                                                                                                                                                                                                                        n {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}

}
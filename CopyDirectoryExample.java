    /AlignButton         *� ,org.eclipse.jdt.launching.jreContainerMarker  message �Build path specifies execution environment J2SE-1.5. There are no JREs installed in the workspace that are strictly compatible with this environment.  location 
Build path severity     A,�� %/AlignButton/src/FlowLayoutFrame.java         *� org.eclipse.jdt.core.problem 	 id   ` message jThe serializable class FlowLayoutFrame does not declare a static final serialVersionUID field of type long 	arguments 1:FlowLayoutFrame 
categoryId   Z 	charStart   � 
lineNumber   
 severity    charEnd   � sourceId JDT  A,���                                                                                                                                                                                                                                                                                                                                                                                                        ();
    		   System.out.println("Directory copied from " 
                              + src + "  to " + dest);
    		}
 
    		//list all the directory contents
    		String files[] = src.list();
 
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}
 
    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
 
    	        byte[] buffer = new byte[1024];
 
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
    	        
 
    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
    	
    }
}
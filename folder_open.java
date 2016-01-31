import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class folder_open {
public folder_open(){
	  File foler = new File("C:\\"); // path to the directory to be opened
      Desktop desktop = null;
      if (Desktop.isDesktopSupported()) {
      desktop = Desktop.getDesktop();
      }

      try {
      desktop.open(foler);
      } catch (IOException e) {
      }
}
	public static void main(String[] args) {
		
folder_open fo=new folder_open();
	}

}

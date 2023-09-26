import edu.duke.*;
import java.io.File;

/**
 * @author (Nesma Abouzaid) 
 * @version (07/07/2023)
 */
public class ImageSaver {
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fName = image.getFileName();
            String newName = "copy-" + fName;
            image.setFileName(newName);
            image.save();
            image.draw();
            
        }
    }

}

import edu.duke.*;
import java.io.File;
/**
 * @author (Nesma Abouzaid) 
 * @version (07/07/2023)
 */
public class GrayConverterSave {
    //I started with the image I wanted (inImage)
    public ImageResource makeGray(ImageResource inImage){
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());   
        //for each pixel in outImage
        for (Pixel pixel : outImage.pixels())
           {    
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            //divide that sum by 3 (cal it average)
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            //set pixel's red to average
            pixel.setRed(average);
            //set pixel's green to average
            pixel.setGreen(average);
            //set pixel's blue to average
            pixel.setBlue(average);
        }     
        //outImage is the answer
        return outImage;
    }
        
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }    
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource inImageInFile = new ImageResource(f);
            ImageResource gray = makeGray(inImageInFile);
            gray.draw();
            doSave();
        }
    }
    
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fName = image.getFileName();
            String newName = "gray-" + fName;
            image.setFileName(newName);
            image.save();
            //image.draw();
            
        }
    }

}

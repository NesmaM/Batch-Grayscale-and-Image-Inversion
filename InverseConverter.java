import edu.duke.*;
import java.io.File;

/**
 * Write a description of InverseConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InverseConverter {
    public ImageResource makeInverse(ImageResource inImage){
            ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
            for (Pixel pixel : outImage.pixels()){
                Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
                int newRed = 255 - inPixel.getRed();             
                int newGreen = 255 - inPixel.getGreen();              
                int newBlue = 255- inPixel.getBlue(); 
                pixel.setRed(newRed);
                pixel.setGreen(newGreen);
                pixel.setBlue(newBlue);
            }
            return outImage;
        }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f :dr.selectedFiles()){
            ImageResource inImageInFile = new ImageResource(f);
            ImageResource inverse = makeInverse(inImageInFile);
            inverse.draw();
            
            
        }
        
    }

}

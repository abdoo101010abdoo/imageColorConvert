
/**
 * Write a description of makeGrey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.*;
import java.io.*;
import edu.duke.*;

public class makeGrey {
   
    public ImageResource imageMakeGrey(ImageResource inImage){
       
       ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight()); 
       
       for(Pixel pixel: outImage.pixels()){
        
          Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
          
          int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
          
          pixel.setRed(average);
          pixel.setBlue(average);
          pixel.setGreen(average);
        }
       return outImage;
    }
    
    public void testImageMakeGrey(){
    
        DirectoryResource dir = new DirectoryResource();
        for(File f: dir.selectedFiles()){
           
            ImageResource inFile = new ImageResource(f);
            ImageResource greyImage = imageMakeGrey(inFile);
            
            String fName = inFile.getFileName();
            String newName = "Copy-" + fName;
            greyImage.setFileName(newName);
            greyImage.draw();
            greyImage.save();
        }
    }
    
    public ImageResource imageMakeNegative(ImageResource inImage){
       
       ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight()); 
       
       for(Pixel pixel: outImage.pixels()){
        
          Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
          
          int negative = ((255 - inPixel.getRed()) + (255 - inPixel.getBlue()) + (255 - inPixel.getGreen()));
          
          pixel.setRed(negative);
          pixel.setBlue(negative);
          pixel.setGreen(negative);
        }
       return outImage;
    }
    
    public void testImageMakeNegative(){
       
        DirectoryResource dir = new DirectoryResource();
        for(File f: dir.selectedFiles()){
           
            ImageResource inFile = new ImageResource(f);
            ImageResource greyImage = imageMakeNegative(inFile);
            
            String fName = inFile.getFileName();
            String newName = "Copy-" + fName;
            greyImage.setFileName(newName);
            greyImage.draw();
            greyImage.save();
        
        }
    }    
    
    
    public static void main (String[] args) {
       
        makeGrey imageTOgray = new makeGrey();
        imageTOgray.testImageMakeGrey();
        
    }
}

package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Controller {

    @FXML
    MenuItem openButton;

    @FXML
    ImageView imageSpace;

    BufferedImage bufferedImage;

    @FXML
    private void openButtonClick(){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        try {
            bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageSpace.setImage(image);
        }catch(IOException ex){
            System.out.println("throw exeption");
        }
    }

    @FXML
    private void rotateButton45(){
        imageSpace.setRotate(45);
    }

    @FXML
    private void rotateButton90(){
        imageSpace.setRotate(90);
    }

    @FXML
    private void rotateButton135(){
        imageSpace.setRotate(135);
    }

    @FXML
    private void rotateButton180(){
        imageSpace.setRotate(180);
    }

    @FXML
    private void rotateButton225(){
        imageSpace.setRotate(225);
    }

    @FXML
    private void rotateButton270(){
        imageSpace.setRotate(270);
    }

    @FXML
    private void rotateButton315(){
        imageSpace.setRotate(315);
    }

    @FXML
    private void rotateButton360(){
        imageSpace.setRotate(360);
    }


    @FXML
    private void toNegative() {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                int p = bufferedImage.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                p = (a<<24) | (r<<16) | (g<<8) | b;
                System.out.print(p);
            }
        }
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageSpace.setImage(image);

    }

    @FXML
    private void blackAndWhite(){
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();

            Color color;
            int newColor;
            Color white = new Color(255, 255, 255);
            Color black = new Color(0, 0, 0);
            int whiteRGB = white.getRGB();
            int blackRGB = black.getRGB();

            for(int y=0; y<height; y++)
            {
                for (int x = 0; x < width; x++)
                {
                    color = new Color(bufferedImage.getRGB(x, y));
                    newColor = intValue(color.getRed()*0.7 + color.getGreen()*0.2 + color.getBlue()*0.1);
                    if(newColor < 127)
                        newColor = whiteRGB;
                    else
                        newColor = blackRGB;

                    bufferedImage.setRGB(x, y, newColor);
                }
            }
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageSpace.setImage(image);
    }


}

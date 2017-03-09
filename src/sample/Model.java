package sample;


import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.BufferOverflowException;

import static oracle.jrockit.jfr.events.Bits.intValue;


/**
 * Created by Tomek on 2/23/2017.
 */
public class Model
{

    public BufferedImage negative(BufferedImage bufferedImage){
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
                bufferedImage.setRGB(x, y, p);
            }
        }
        return bufferedImage;
    }

    public BufferedImage monochrome(BufferedImage bufferedImage){
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
        return bufferedImage;
    }
}

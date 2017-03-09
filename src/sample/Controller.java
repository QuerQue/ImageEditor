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

    Model model = new Model();
    @FXML
    private void negativeButton() {
        model.negative(bufferedImage);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageSpace.setImage(image);
    }

    @FXML
    private void monochromeButton(){
        model.monochrome(bufferedImage);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageSpace.setImage(image);
    }


}

package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Controller {

    @FXML
    MenuItem openButton;

    @FXML
    ImageView imageSpace;

    @FXML
    private void openButtonClick(){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageSpace.setImage(image);
        }catch(IOException ex){
            System.out.println("throw exeption");
        }
    }



}

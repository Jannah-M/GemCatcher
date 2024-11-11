import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This class represents an image StackPane object that can be clicked
 * @author Jannah Mansoor
 * @version 1.0
 */

class DecorPane extends StackPane 
{
    private ImageView image = new ImageView("newSpark.png");
    
    public DecorPane() 
    { 
        getChildren().add(image);
    }
    
    public void remove() 
    { 
        getChildren().remove(image);
    } 
    
}
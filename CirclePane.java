import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 * This class represents a circular StackPane object that can be clicked
 * @author Jannah Mansoor
 * @version 1.0
 */

class CirclePane extends StackPane 
{
    private Circle circle;
    
    public CirclePane(Color color, int dist) 
    { 
        circle = new Circle(dist);
        getChildren().add(circle);
        circle.setStroke(color);
        circle.setFill(color);
    }
    
    public void remove() 
    { 
        circle.setRadius(0);
        circle.setStroke(Color.RED);
    } 
    
}
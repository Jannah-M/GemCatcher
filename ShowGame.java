/** This program displays the whack-a-mole style game board, with moving clickable icons.
 * @author Jannah Mansoor
 * @version 1.0
 */
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.geom.Ellipse2D;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseButton;
import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage; 
import javafx.animation.Animation; 
import javafx.application.Application;
import javafx.stage.Stage; 
import javafx.animation.KeyFrame; 
import javafx.animation.Timeline; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color; 
import javafx.scene.text.Text; 
import javafx.util.Duration; 
import javafx.scene.text.FontWeight;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;



public class ShowGame extends Application 
{   
    @Override 
    
    public void start(Stage primaryStage) 
    {
        
        Color violet = new Color(0.5, 0.2, 0.8, 0.2); 
        Color grey = new Color(0.09, 0.12, 0.15, 0.3);
        Color mint = new Color(0.67, 0.9, 0.83, 1);
        Color shamrock = new Color(0.05, 0.71, 0.45, 1);
        Color jet = new Color(0.22, 0.2, 0.25, 1);
        
        // THIS IS WHERE THE GRID PANE IS CREATED
        GridPane pane = new GridPane(); // Create GridPane object
        pane.setBackground(new Background(new BackgroundFill(grey, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setAlignment(Pos.CENTER); // Set the alignment
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5); // Gap between columns
        pane.setVgap(5.5); // Gap between rows
        
        // BELOW IS WHERE ALL ICONS ARE ADDED TO THE GRID LAYOUT
    
        
        for(int i = 0; i < 5; i++) // nested for loop to display Circles and CirclePanes
        {
            for(int j = 0; j < 5; j++)
            {
                Circle outerRing = new Circle(60, mint);
                //Circle innerRing = new Circle(50, Color.BLACK);
                CirclePane innerRing = new CirclePane(jet, 50); 
                //CirclePane clickable = new CirclePane(violet, 20);
                
                GemPane clickable = new GemPane();
                
                pane.add(outerRing, i, j + 1); // adding blue outer circle
                pane.add(innerRing, i, j + 1); // adding blue outer circle
                //pane.add(clickable, i, j); // adding black inner CirclePane
            
            }
        }
        
        
        GemPane clickable = new GemPane();
        
        EventHandler<ActionEvent> eventHandler = e -> 
        { 
             int i = (int)(Math.random() * 5);
             int j = (int)(Math.random() * 5);
             
             int score = 0;
             
             Text scoreBoard = new Text();
             
             //Label scoreBoard = new Label();
             scoreBoard.setFont(new Font("Courier New", 20));
             pane.add(scoreBoard, 2, 0);
             int[] counter = new int[1];
             
             boolean b = false;
             if (!b) 
             { 
                 pane.add(clickable, i, j + 1);
                 b = true;
             }
             else 
             { 
                clickable.remove();
                b = false;
             } 
            
            
            clickable.setOnMouseClicked(z -> // this block of code contains all possible conditions when any CirclePane is clicked 
            {   
                counter[0]++;
                scoreBoard.setText("SCORE: " + counter[0]);
                if(counter[0] >= 15)
                {
                    //scoreBoard.setText("Well Done!");
                    end(primaryStage);
                }
     
            });
        };
    
        
         
        /*
        clickable.setOnMouseClicked(e -> // this block of code contains all possible conditions when any CirclePane is clicked 
        {
            if (e.getButton() == MouseButton.PRIMARY) // primary means right click 
            { 
                clickable.remove();
            }
            else if (e.getButton() == MouseButton.SECONDARY) // secondary means left click
            { 
                clickable.remove();
            }
        });
        */
        
         
         // Create an animation to call the event handler at time intervals
         Timeline animation = new Timeline
         ( 
         new KeyFrame(Duration.millis(700), eventHandler)); // Linkwith handler
         animation.setCycleCount(Timeline.INDEFINITE); 
         animation.play(); // Start animation
        
         
        // THIS SETS UP AND DISPLAYS THE SCENE
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Diamond Mine");
        primaryStage.setScene(scene); // Place the scene in the stage 
        primaryStage.show(); // Display the stage
        
        //pane.setTop(instrLbl);
    } 
    
    public void end(Stage primaryStage)
    {
        Text t = new Text("You Beat the Game!");
        t.setFont(new Font("Courier New", 30));

        Color mint = new Color(0.67, 0.9, 0.83, 1);

        
        DecorPane d = new DecorPane();
        Label l = new Label("Hello");
        Label blank = new Label("");
        l.setFont(new Font("SpaceMono", 25));
        GridPane pane = new GridPane(); // Create GridPane object
        pane.setBackground(new Background(new BackgroundFill(mint, CornerRadii.EMPTY, Insets.EMPTY)));
        pane.setAlignment(Pos.CENTER); // Set the alignment
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5); // Gap between columns
        pane.setVgap(5.5); // Gap between rows

        //pane.add(l, 1, 1);
        //pane.add(blank, 2, 0);
        pane.add(new DecorPane(), 0, 0);
        pane.add(new DecorPane(), 0, 1);
        pane.add(new DecorPane(), 0, 2);
        pane.add(new DecorPane(), 1, 0);
        pane.add(t, 1, 1);
        pane.add(new DecorPane(), 1, 2);
        pane.add(new DecorPane(), 2, 0);
        pane.add(new DecorPane(), 2, 1);
        pane.add(new DecorPane(), 2, 2);

        
        Scene scene = new Scene(pane, 700, 600);
        primaryStage.setTitle("YOU WON!");
        primaryStage.setScene(scene); // Place the scene in the stage 
        primaryStage.show(); // Display the stage
        
    }
    
    public void remove(Label l)
    {
        l.setText("");
    }
    
    public static void main(String[] args) 
    { 
       Application.launch(args);
    }
}

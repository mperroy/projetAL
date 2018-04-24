package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FXView implements View {
	
	public static Scene scene;
	public static BorderPane pane;
	public static Group group;
	
	public static void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");
		//controller = Controller.getInstance();
		
		pane = new BorderPane();
		
		
		pane.setTop(drawCommandBar());
		pane.setLeft(drawToolBar());
		
		Rectangle r = new Rectangle(200, 50, Color.BLACK);
		Rectangle r2LeRetour = new Rectangle(100, 100, Color.BLUE);
		group = new Group(r, r2LeRetour);
		pane.setCenter(group);
		//TranslateTransition transition = createTranslateTransition(r);
		
		scene = new Scene(pane, 600, 600);
	    //moveOnMousePress(scene, r, transition);
		
		/* 
		startGame = new Button("Start");
		startGame.relocate(0, 0);
		pane.getChildren().add(startGame);
		
		Label difficulty = new Label("Game difficulty : ");
		difficulty.relocate(0, 40);
		pane.getChildren().add(difficulty);
		
		easy = new Button("Easy");
		easy.relocate(110, 35);
		pane.getChildren().add(easy);
		*/
		
		r.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                
                /* allow any transfer mode */
                Dragboard db = r.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString("Cotelettes");
                db.setContent(content);
                
                event.consume();
            }
        });

        r2LeRetour.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != r2LeRetour) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                
                event.consume();
            }
        });

        r2LeRetour.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != r2LeRetour) {
                    r2LeRetour.setFill(Color.GREEN);
                }
                
                event.consume();
            }
        });

        r2LeRetour.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                r2LeRetour.setFill(Color.RED);
                
                event.consume();
            }
        });
        
        r2LeRetour.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    r2LeRetour.setFill(Color.TURQUOISE);
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
            }
        });

        r.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    r.setFill(Color.BISQUE);
                }
                
                event.consume();
            }
        });
		
		stage.setScene(scene);
		stage.show();
	}
	
	public static HBox drawCommandBar() {
		HBox hbox = new HBox();
	    //hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(5);
	    //hbox.setStyle("-fx-background-color: #336699;");

	    Button buttonSave = new Button("Save");
	    Button buttonLoad = new Button("Load");
	    Button buttonUndo = new Button("Undo");
	    Button buttonRedo = new Button("Redo");
	    
	    hbox.getChildren().addAll(buttonSave, buttonLoad, buttonUndo, buttonRedo);
	    
	    return hbox;
	}
	
	public static VBox drawToolBar() {
		
		VBox vbox = new VBox();
	    vbox.setPadding(new Insets(10, 0, 0, 0));
	    vbox.setSpacing(5);

	    Button toolbarRectangle = new Button("Rectangle");
	    toolbarRectangle.setPrefSize(100, 20);
	    Button toolbarPolygon = new Button("Regular Polygon"); 
	    toolbarPolygon.setPrefSize(100, 20);
	    
	    /*
	    Text title = new Text("Data");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(title);

	    Hyperlink options[] = new Hyperlink[] {
	        new Hyperlink("Sales"),
	        new Hyperlink("Marketing"),
	        new Hyperlink("Distribution"),
	        new Hyperlink("Costs")};

	    for (int i=0; i<4; i++) {
	        VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
	        vbox.getChildren().add(options[i]);
	    }
	    */
	    
	    vbox.getChildren().addAll(toolbarRectangle, toolbarPolygon);
	    
	    return vbox;
	}
    

  /*private static TranslateTransition createTranslateTransition(Rectangle r) {
    final TranslateTransition transition = new TranslateTransition(Duration.seconds(0.25), r);
    transition.setOnFinished(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent t) {
        r.setX(r.getTranslateX() + r.getX());
        r.setY(r.getTranslateY() + r.getY());
        r.setTranslateX(0);
        r.setTranslateY(0);
      }
    });
    return transition;
  }
  
  private static void moveOnMousePress(Scene scene, Rectangle r, TranslateTransition transition) {
    scene.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
        if (!event.isControlDown()) {
          r.setX(event.getSceneX());
          r.setY(event.getSceneY());
        } else {
          transition.setToX(event.getSceneX() - r.getX());
          transition.setToY(event.getSceneY() - r.getY());
          transition.playFromStart();
        }  
      }
    });
  }*/
}

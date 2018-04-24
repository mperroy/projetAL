package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXView implements View {
	
	public static Scene scene;
	public static BorderPane pane;
	
	public static void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");
		//controller = Controller.getInstance();
		
		pane = new BorderPane();
		scene = new Scene(pane, 600, 600);
		
		pane.setTop(drawCommandBar());
		pane.setLeft(drawToolBar());
		
		//pane.getChildren().add(drawCommandBar());
		//pane.getChildren().add(drawToolBar());
		
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
}

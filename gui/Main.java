package gui;

import javafx.application.Application;
import javafx.stage.Stage;

// Main avec application ? Comment faire pour généricité avec AWT
// Main java + main AWT ? Modification de l'architecture facile pour ajout d'autres gi ? 
public class Main extends Application { // A transformer en main ?
	//private View view; // View en static fonction, comme dans le projet labyrinthe
	//private ShapeAbstractFactory shapeFactory;
	// Controller ?

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		FXView.drawFrame(stage);
	}
}

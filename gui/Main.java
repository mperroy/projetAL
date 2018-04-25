package gui;

import javafx.application.Application;
import javafx.stage.Stage;

// Main avec application ? Comment faire pour généricité avec AWT
// Main java + main AWT ? Modification de l'architecture facile pour ajout d'autres gi ? 
public class Main extends Application {
	private static Controller controller;

	public static void main(String[] args) {
		controller = new Controller(true);
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		FXView view = (FXView) controller.getView();
		view.drawFrame(stage);
	}
}

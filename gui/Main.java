package gui;

// Main avec application ? Comment faire pour généricité avec AWT
// Main java + main AWT ? Modification de l'architecture facile pour ajout d'autres gi ? 
public class Main {
	private static Controller controller;

	public static void main(String[] args) {
		if(args[1].equals("fx"))
			controller = new FXController();
		if(args[1].equals("awt"))
			controller = new AWTController();
		
		controller.launch(args);
		
		//launch(args);
	}
	
//	@Override
//	public void start(Stage stage) throws Exception {
//		FXView view = (FXView) controller.getView();
//		view.drawFrame(stage);
//	}
}

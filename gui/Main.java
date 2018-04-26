package gui;

public class Main {
	private static Controller controller;

	public static void main(String[] args) {
		controller = new FXController();
		controller.launchController(args);
	}
}

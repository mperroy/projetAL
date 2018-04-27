package gui;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shapeFactory.FXRectangle;
import shapeFactory.FXRegularPolygon;
import shapeFactory.FXShape;
import shapeFactory.ShapeAbstractFactory;
import shapes.Coordinates;
import shapes.MementoView;
import shapes.RectangleSimple;
import shapes.RegularPolygonSimple;
import shapes.ShapeGroup;
import shapes.ShapeInterface;
import shapes.ShapeSimple;
import shapes.ShapeToolbar;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class FXView implements View {
	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;
	
	public static Scene scene;
	public static BorderPane pane;
	public static Pane centerPane;
	public static StackPane trash;

	public static HBox hbox;
	public static VBox vbox;

	public static Button buttonSave;
	public static Button buttonLoad;
	
	private static ArrayList<ShapeInterface> list = new ArrayList<ShapeInterface>();
	private static MementoView m = new MementoView();

	ArrayList<Node> selectionModel = new ArrayList<Node>();

	public void drawFrame(Stage stage) {
		stage.setTitle("Projet AL");

		pane = new BorderPane();

		centerPane = new Pane();
		drawCommandBar();

		centerPane.setStyle("-fx-border-color: black;-fx-border-width: 1;");

		pane.setCenter(centerPane);
		scene = new Scene(pane, 600, 600);

		stage.setScene(scene);

		// Multiple selection
		centerPane.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {

			if (event.isControlDown()) {
				selectionModel.add((Node) event.getSource());
			} else
				selectionModel.removeAll(selectionModel);

		});
		stage.show();
	}

	public void drawCommandBar() {
		hbox = new HBox();
		hbox.setPadding(new Insets(0, 0, 10, 0));
		hbox.setSpacing(5);

		buttonSave = new Button("Save");
		buttonLoad = new Button("Load");

		hbox.getChildren().addAll(buttonSave, buttonLoad);

		pane.setTop(hbox);
	}

	public void drawToolBar(ShapeToolbar toolbar) {
		vbox = new VBox();
		vbox.setPadding(new Insets(0, 10, 10, 10));
		vbox.setSpacing(5);

		Iterator<ShapeInterface> it = toolbar.getChildren();
		while (it.hasNext()) {
			FXShape tmp = (FXShape) it.next();
			setupRightClickForToolbar(tmp);
			vbox.getChildren().add(tmp.getShape());
		}
		
		pane.setLeft(vbox);
	}

	public void setupButtons(ShapeAbstractFactory factory) {
		for(Node n :vbox.getChildren()) {
			n.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					if(e.getButton().equals(MouseButton.PRIMARY)) {
						if (n instanceof Rectangle) { 
							FXRectangle fxr = (FXRectangle) factory.getRectangle(); 
							setupMoveInBound(centerPane.getLayoutBounds(), fxr);
							setupRightClick(fxr);
							centerPane.getChildren().add(fxr.getShape());
							list.add(fxr);
						}
						if (n instanceof Polygon) { 
							FXRegularPolygon fxrp = (FXRegularPolygon) factory .getRegularPolygon();
							setupMoveInBound(centerPane.getLayoutBounds(), fxrp);
							setupRightClick(fxrp);
							centerPane.getChildren().add(fxrp.getShape());
							list.add(fxrp);
						}
					}
				}
			});
		}
		
		buttonSave.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				m.setState(list);
			}
		});
		
		buttonLoad.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event) {
				list = m.getState();
				while(centerPane.getChildren().size()>0) {
					centerPane.getChildren().remove(0);
				}
				for(ShapeInterface l : list) {
					if (l instanceof RectangleSimple) { 
						FXRectangle fxr = new FXRectangle((RectangleSimple) l); 
						setupMoveInBound(centerPane.getLayoutBounds(), fxr);
						setupRightClick(fxr);
						centerPane.getChildren().add(fxr.getShape());
					}
					if (l instanceof RegularPolygonSimple) { 
						FXRegularPolygon fxrp = new FXRegularPolygon((RegularPolygonSimple) l);
						setupMoveInBound(centerPane.getLayoutBounds(), fxrp);
						setupRightClick(fxrp);
						centerPane.getChildren().add(fxrp.getShape());
					}
				}
			}
		});
	}

	public void setupRightClick(FXShape shape) {
		ContextMenu contextMenu = new ContextMenu();
		
		MenuItem edition = new MenuItem("Edit");
		edition.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (shape instanceof FXRectangle) {
					setupEditionRectangle((FXRectangle) shape);
				} 
				if (shape instanceof FXRegularPolygon){
					setupEditionRegularPolygon((FXRegularPolygon) shape);
				}
			}
		});

		MenuItem suppr = new MenuItem("Delete");
		suppr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(shape.getShape().getParent().equals(centerPane)) {
					centerPane.getChildren().remove(shape.getShape());
					list.remove((ShapeInterface) shape);
				}
			}
		});
		
		MenuItem group = new MenuItem("Group");
		group.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ShapeInterface shapeGroup = new ShapeGroup();
				for (Node n : selectionModel) {
					shapeGroup.addShape((ShapeInterface) n);
				}
			}
		});

		contextMenu.getItems().addAll(edition, suppr, group);

		shape.getShape().setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			public void handle(ContextMenuEvent event) {
				contextMenu.show(shape.getShape(), event.getScreenX(), event.getScreenY());
			}
		});
	}
	
	public void setupRightClickForToolbar(FXShape shape) {
		ContextMenu contextMenu = new ContextMenu();
		
		MenuItem suppr = new MenuItem("Delete");
		suppr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				vbox.getChildren().remove(shape.getShape());
				FXController.removeFromToolbar((ShapeInterface) shape);
			}
		});

		contextMenu.getItems().addAll(suppr);

		shape.getShape().setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			public void handle(ContextMenuEvent event) {
				contextMenu.show(shape.getShape(), event.getScreenX(), event.getScreenY());
			}
		});
	}

	public void setupEditionRectangle(FXRectangle fxr) {
		Stage dialog = new Stage();
		GridPane grid = new GridPane();
		Scene sceneDialog = new Scene(grid, 300, 200);

		Label label1 = new Label("Width : ");
		Label label2 = new Label("Height : ");
		Label label3 = new Label("Border curve : ");
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		TextField text3 = new TextField();
		Button button1 = new Button("Apply");
		Button button2 = new Button("Close");

		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2);
		grid.add(text2, 2, 2);
		grid.add(label3, 1, 3);
		grid.add(text3, 2, 3);
		grid.add(button1, 1, 4);
		grid.add(button2, 2, 4);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					fxr.setWidth(Double.parseDouble(text1.getText()));
				} catch (NumberFormatException | NullPointerException exc) {
				}

				try {
					fxr.setHeight(Double.parseDouble(text2.getText()));
				} catch (NumberFormatException | NullPointerException exc) {
				}
				try {
					fxr.setBorderCurve(Double.parseDouble(text3.getText()));
				} catch (NumberFormatException | NullPointerException exc) {
				}
			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				dialog.close();
			}
		});

		dialog.setScene(sceneDialog);
		dialog.show();
	}

	public void setupEditionRegularPolygon(FXRegularPolygon fxrp) {
		Stage dialog = new Stage();
		GridPane grid = new GridPane();
		Scene sceneDialog = new Scene(grid, 300, 200);

		Label label1 = new Label("Edge length  : ");
		Label label2 = new Label("Edge number : ");
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		Button button1 = new Button("Apply");
		Button button2 = new Button("Close");

		grid.add(label1, 1, 1);
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2);
		grid.add(text2, 2, 2);
		grid.add(button1, 1, 3);
		grid.add(button2, 2, 3);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					fxrp.setEdgeLength(Double.parseDouble(text1.getText()));
				} catch (NumberFormatException | NullPointerException exc) {
				}

				try {
					fxrp.setEdgeNumber(Integer.parseInt(text2.getText()));
				} catch (NumberFormatException | NullPointerException exc) {
				}
			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				dialog.close();
			}
		});

		dialog.setScene(sceneDialog);
		dialog.show();
	}
	
	public void setupMoveInBound(Bounds bounds, FXShape s) {
		s.getShape().setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent t) {
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
				orgTranslateX = ((Shape) t.getSource()).getTranslateX();
				orgTranslateY = ((Shape) t.getSource()).getTranslateY();
			}
		});

		s.getShape().setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent t) {
				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;
				double newTranslateX = orgTranslateX + offsetX;
				double newTranslateY = orgTranslateY + offsetY;
				if (newTranslateX + ((ShapeSimple) s).getMinX() > bounds.getMinX() 
						&& newTranslateX + ((ShapeSimple) s).getMaxX() < bounds.getMaxX()
						&& newTranslateY + ((ShapeSimple) s).getMinY() > bounds.getMinY()
						&& newTranslateY + ((ShapeSimple) s).getMaxY() < bounds.getMaxY()) {
					((ShapeInterface) s).translation(new Coordinates(newTranslateX, newTranslateY));
				}
				if(((Shape) t.getSource()).getParent().equals(centerPane) && newTranslateX + ((ShapeSimple) s).getMinX() < bounds.getMinX()) {
					centerPane.getChildren().remove((Shape) t.getSource());
					list.remove((ShapeInterface) s);
					
					ShapeInterface newToolbarShape = ((ShapeInterface) s).clone();
					
					FXController.addToToolbar(newToolbarShape);
				}
			}
		});
	}
}

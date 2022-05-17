//Muhammed Enes Gündüz 150120038
//Melik Özdemir 150120004

import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test extends Application{

	public void start(Stage primaryStage) {
		
		Pane gnrlPane = new Pane();
		GridPane grdPane= new GridPane();
		gnrlPane.setPrefSize(1050, 800);
		MainMenu menu= new MainMenu();
		menu.addMenu(gnrlPane,grdPane,primaryStage);
		
	    Scene scene = new Scene(gnrlPane, 1050, 800);
		primaryStage.setTitle("Ball And Pipe");  
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	public static void main(String[] args) {
	    launch(args);
	  }
	
}


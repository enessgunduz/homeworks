//Muhammed Enes Gündüz 150120038
//Melik Özdemir 150120004

//This class is for setting main menu and game board

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;	
public class MainMenu {

	public void addMenu(Pane menuPane,GridPane grdPane,Stage primaryStage) {
			
			
			Image image= new Image("image/background.jpg");
			ImageView imageView = new ImageView(image); 
			imageView.setFitHeight(800); //Setting background
			imageView.setFitWidth(1050);
			menuPane.getChildren().add(imageView);
	    
			
	 		Text gameNameTxt= new Text("Ball And Pipe");
	 		gameNameTxt.setFill(Color.AZURE);
	 		gameNameTxt.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50)); //Setting game name
	 		gameNameTxt.setTranslateX(300);
	 		gameNameTxt.setTranslateY(100);
	 		menuPane.getChildren().addAll(gameNameTxt); //add children 
	 		
	 		Text score= new Text("Moves: "); 
			score.setFill(Color.CADETBLUE);
			score.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD,25)); //Setting score text
			score.setTranslateX(850);
			score.setTranslateY(150);
			menuPane.getChildren().add(score);
	 		
	 		MenuItem level1= new MenuItem(grdPane, 850, 200,menuPane,"1",score); //create  MenuItem for level1
	 		
			
			
	}
	
	
	
}

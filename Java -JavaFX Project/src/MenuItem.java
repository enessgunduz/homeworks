//Muhammed Enes Gündüz 150120038
//Melik Özdemir 150120004

//This class is for creating menu items

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuItem extends StackPane {
	public MenuItem(GridPane grdPane,int x,int y,Pane menuPane,String str,Text score) { //for level buttons
		Image img =new Image("image/level"+str+".png"); //getting level img
		ImageView imgV= new ImageView(img);
		imgV.setFitHeight(40);
		imgV.setFitWidth(130);
		imgV.setTranslateX(x);
		imgV.setTranslateY(y);
		imgV.setId(str);
		for(Node node:menuPane.getChildren()) {
			if(node.getId()!=str) {
				menuPane.getChildren().add(imgV); //Adding img to pane
				break;
			}
			
		}
		
		
		
		/**if pressed the button create a level object and call the addPane and startMove method*/
		imgV.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				menuPane.getChildren().remove(grdPane);
				menuPane.getChildren().add(grdPane);
				
				
				Level level= new Level();
				
				level.setPane(grdPane, str);
				level.strMove(menuPane,grdPane,score);
				
			}
			
		});
		}
	
	
}

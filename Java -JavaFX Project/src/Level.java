//Muhammed Enes Gündüz 150120038
//Melik Özdemir 150120004

/*
 * This class is for:
 * Gets inputs from files and sets the level design
 * Checks movement conditions
 * Checks if the game has ended or not
 * Creates animations for rolling ball
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Level {
	
	private Pane[][] panes= new Pane[4][4];
	private String[][] imageArray= new String[4][4];
	private ArrayList<Pane>	animationPanes = new ArrayList<Pane>();
	private ArrayList<Pane> paneArray= new ArrayList<Pane>();
	private ArrayList<Pane>	endPanes = new ArrayList<Pane>();
	private ArrayList<Pane>	allPanes = new ArrayList<Pane>();
	
	
	
	private boolean isSucceced; 
	private boolean isEnded;
	private int scoreCount=0;
	private int level;
	
	public void setPane(GridPane pane,String str) {

		try {
			//read level txt
			File file = new File("level"+str+".txt");
			Scanner input = new Scanner(file);
			
			level=Integer.parseInt(str);
			
			while(input.hasNextLine()) {
				//getting each element of line
				String[] crntLine = input.nextLine().split(",");
				String index = crntLine[0];
				String tileType = crntLine[1];
				String position= crntLine[2];
				
					
				switch(index) {
	
					
				case "1":
					Pane pane1 = new Pane();
					pane1.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane1,0,0,0); //call the tileFinder method
					pane.add(pane1,0,0); //add the pane on gridpane use column and row index
					panes[0][0]=pane1; //add the pane1 to panes array 
					break;
					
				case "2":
					Pane pane2 = new Pane();
					pane2.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane2,1,0,1);				
					pane.add(pane2,1,0);
					panes[1][0]=pane2;
					break;
				
				case "3":
					Pane pane3 = new Pane();
					pane3.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane3,2,0,2);
					pane.add(pane3,2,0);
					panes[2][0]=pane3;
					break;
					
				case "4":
					Pane pane4 = new Pane();
					pane4.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane4,3,0,3);
					pane.add(pane4,3,0);
					panes[3][0]=pane4;
					break;
					
				case "5":
					Pane pane5 = new Pane();
					pane5.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane5,0,1,4);
					pane.add(pane5,0,1);
					panes[0][1]=pane5;
					break;
					
				case "6":
					Pane pane6 = new Pane();
					pane6.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane6,1,1,5);
					pane.add(pane6,1,1);
					panes[1][1]=pane6;
					break;
					
				case "7":
					Pane pane7 = new Pane();
					pane7.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane7,2,1,6);
					pane.add(pane7,2,1);
					panes[2][1]=pane7;
					break;
					
				case "8":
					Pane pane8 = new Pane();
					pane8.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane8,3,1,7);
					pane.add(pane8,3,1);
					panes[3][1]=pane8;
					break;
					
				case "9":
					Pane pane9 = new Pane();
					pane9.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane9,0,2,8);
					pane.add(pane9,0,2);
					panes[0][2]=pane9;
					break;
					
				case "10":
					Pane pane10 = new Pane();
					pane10.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane10,1,2,9);
					pane.add(pane10,1,2);
					panes[1][2]=pane10;
					break;
					
				case "11":
					Pane pane11 = new Pane();
					pane11.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane11,2,2,10);
					pane.add(pane11,2,2);
					panes[2][2]=pane11;
					break;
					
				case "12":
					Pane pane12 = new Pane();
					pane12.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane12,3,2,11);
					pane.add(pane12,3,2);
					panes[3][2]=pane12;
					break;
					
				case "13":
					Pane pane13 = new Pane();
					pane13.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane13,0,3,12);
					pane.add(pane13,0,3);
					panes[0][3]=pane13;
					break;
					
				case "14":
					Pane pane14 = new Pane();
					pane14.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane14,1,3,13);
					pane.add(pane14,1,3);
					panes[1][3]=pane14;
					break;
					
				case "15":
					Pane pane15 = new Pane();
					pane15.setPrefSize(200,200);
					tileFinder(tileType,position,pane,pane15,2,3,14);
					pane.add(pane15, 2, 3);
					panes[2][3]=pane15;
					break;
					
				case "16":
					Pane pane16 = new Pane();
					pane16.setPrefSize(200, 200);
					tileFinder(tileType, position, pane , pane16,3,3,15);
					pane.add(pane16, 3, 3);
					panes[3][3]=pane16;
					break;
					
				}
			}
		
			} catch (FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
				
		}
		
	}
	

	/**it takes pictures from image file according to type*/
 public void tileFinder(String tileType,String position,GridPane pane ,Pane paneInd,int ii,int jj,int a ) {

	 
		 if(tileType.equals("Starter")) {
			 
			  if(position.equals("Vertical")) {
				  Image image= new Image("image/sv.png");
				  showImage(image,  paneInd); //call the showImage method 
				  imageArray[ii][jj]="sv"; //add name of image to array imageArray (Hint. using imageArray for nearTile,target pane)
				  paneInd.setId("bot-Starter"); //set id 
		
				  
				  
			  }else if(position.equals("Horizontal")){
				  Image image= new Image("image/sh.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="sh";
				  paneInd.setId("lft-Starter");
	
			  }
		 
		 }else if(tileType.equals("End")) {
			 
			 if(position.equals("Vertical")) {
				  Image image= new Image("image/etv.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="ev";
				  paneInd.setId("ENDb-END");
				 
				  
			  }else if(position.equals("Horizontal")){
				  Image image= new Image("image/eth.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="eh";
				  paneInd.setId("ENDl-END");
				  
			  }
		 }else if(tileType.equals("Empty")) {
			 
			 if(position.equals("Free")) {
				 Image image= new Image("image/eft.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="ef";
				  paneInd.setId("empty");
				  
				 
				  
			 } else  if(position.equals("none")){
				  Image image= new Image("image/et.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="en";
				  paneInd.setId("empty");
				 
				  
			  }
		 }else if(tileType.equals("Pipe")) {
			 
			 if(position.equals("Vertical")) {
				 
				  Image image= new Image("image/vt.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="pv";
				  paneInd.setId("tb-PipeNormal");
				  
			  }else if(position.equals("Horizontal")){
				  Image image= new Image("image/ht.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="ph";
				  paneInd.setId("lr-PipeNormal");
				  
				  
			  }else if(position.equals("00")){
				  Image image= new Image("image/ct00.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="p00";
				  paneInd.setId("tl-PipeNormal");
				
				 
			  }else if(position.equals("01")){
				  Image image= new Image("image/ct01.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="p01";
				  paneInd.setId("tr-PipeNormal");
				  
				  
			  }else if(position.equals("10")){
				  Image image= new Image("image/ct10.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="p10";
				  paneInd.setId("bl-PipeNormal");
				
				  
			  }else if(position.equals("11")){
				  Image image= new Image("image/ct11.png");
				  showImage(image, paneInd);
				  imageArray[ii][jj]="p11";
				  paneInd.setId("br-PipeNormal");
				  }
		 }
		 else if(tileType.equals("PipeStatic")) { 
			 if(position.equals("Vertical")) {
				  Image image= new Image("image/vst.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="psv";
				  paneInd.setId("tb-PipeStatic");
			  }
			 else if(position.equals("Horizontal")){
				  Image image= new Image("image/hst.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="psh";
				  paneInd.setId("lr-PipeStatic");
				  
				  
			  }else if(position.equals("01")){
				  Image image= new Image("image/cst01.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="ps01";
				  paneInd.setId("tr-PipeStatic");
				 
				  
			  }else if(position.equals("10")){
				  
				  Image image= new Image("image/cst10.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="ps10";
				  paneInd.setId("bl-PipeStatic");
				  
			  }else if(position.equals("11")){
				  Image image= new Image("image/cst11.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="ps11";
				  paneInd.setId("br-PipeStatic");
				  
			  }else if(position.equals("00")){
				  Image image= new Image("image/cst00.png");
				  showImage(image,  paneInd);
				  imageArray[ii][jj]="ps00";
				  paneInd.setId("tl-PipeStatic");
				
				  
			  }
		 }
		 
		 allPanes.add(paneInd);
	 }
	
 	/**adjusts the size of the image and adds it to the pane.*/
	 public void showImage(Image image,Pane pane) {
		
		 ImageView imageView = new ImageView(image); 
		 imageView.setFitHeight(200);
		 imageView.setFitWidth(200);
	      
	      pane.getChildren().add(imageView);
 
	    pane.setOnDragDetected(new EventHandler<MouseEvent>() {//checking mouse events

			@Override
			public void handle(MouseEvent event) {
				
				Dragboard dragBoard= pane.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content=new ClipboardContent();
				content.putImage(image);
				dragBoard.setContent(content);
				event.consume();
			}
	    	
	    });
	      
	 }
	  
	 /**locates the pane in which the mouse is pressed and checks that the source is movable.*/
	 public void strMove(Pane menuPane,GridPane grdPane,Text scoreText) {
	    	if(scoreCount == 0)
				scoreText.setText("Moves : "+0);

	    	grdPane.getChildren().forEach(event ->{
	    		
	    		event.setOnMousePressed(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent e) {
						int col = 0;
    	        		int row = 0;	
                        if( event.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                        	row = GridPane.getRowIndex( event);
                        	col =  GridPane.getColumnIndex( event);
                        
                        	
                        	if(findMainTile(col, row)) { //call findMainTile method
                        		
                        		tileMoved(menuPane,grdPane,col , row,scoreText); //call tileMoved method
                        	}                        	
                        }						
					}	    			
	    		});	    		
	    	});     
	    }
	  	    
	    public void tileMoved(Pane menuPane,GridPane grdPane,int col , int row,Text score) {
	    		
	    		paneArray= checkTarget(imageArray,col,row);
	    		Pane pane = panes[col][row];
	    		paneArray.forEach(event ->{
	    	    	
	    	    	int columnMoved=GridPane.getColumnIndex(event);
	    			int rowMoved= GridPane.getRowIndex(event);
	    			int columnMoved2= GridPane.getColumnIndex(pane);
	    			int rowMoved2= GridPane.getRowIndex(pane);
	    			//sets drag
	    			event.setOnDragOver(new EventHandler<DragEvent>() {

						@Override
						public void handle(DragEvent e) {
							if(isEnded==false) {
								if(paneArray.contains(event)) {
									if(findMainTile(col, row)) {
									e.acceptTransferModes(TransferMode.MOVE);
								}
							}
						}
							e.consume();
							
						}
	    				
	    			});
	    			//sets drop
	    			event.setOnDragDropped(new EventHandler<DragEvent>() {

	    				@Override
	    				public void handle(DragEvent e) {
	    					
	    					panes[columnMoved][rowMoved]=pane;
	    					panes[columnMoved2][rowMoved2]=event;
	    					String source= imageArray[columnMoved2][rowMoved2];
	    					String target= imageArray[columnMoved][rowMoved];
	    					imageArray[columnMoved2][rowMoved2]=target;
	    					imageArray[columnMoved][rowMoved]=source;
	    					allPanes.remove(columnMoved+rowMoved*4);
	    					allPanes.add(columnMoved+rowMoved*4, pane);
	    					allPanes.remove(columnMoved2+rowMoved2*4);
	    					allPanes.add(columnMoved2+rowMoved2*4,event);
	    					grdPane.getChildren().remove(pane);
	    					grdPane.getChildren().remove(event);
	    					grdPane.add(pane, columnMoved, rowMoved);
	    					grdPane.add(event, columnMoved2, rowMoved2);
	    					isSucceced=true;
	    					scoreCount++; //counter increments on every move
	    					score.setText("Moves : "+scoreCount); //print counter
	    					gameFinalChecker(grdPane,score,menuPane); //call the gameEndCond method (check true)
	    					e.setDropCompleted(isSucceced);
	    					e.consume();
	    					
	    					}});	    			
	    		});	    		
	 }	    
	    
	    /**this method checks that the targets are empty. */
	 	public ArrayList<Pane> checkTarget(String[][] imageArray,int col,int row) {
	    	
	    	paneArray.clear();
	    	
	    	for(int ii=0;ii<4;ii++) {
	    		
	    		for(int jj=0;jj<4;jj++) {
	    			
	    			String str= imageArray[ii][jj];
	    			
	    			
	    				if(nearTile(ii, jj, col, row)) {
	    				
	    					if(str.equals("ef")) {
	    				
	    						paneArray.add(panes[ii][jj]);

	    				}
	    			}
	    			
	    		}
	    	}

	    	return paneArray;
	    	
	    	
	    }
	    
	 	/**this method gives approval for moving resources*/
	    public boolean findMainTile(int column,int row) {
	    	String name= imageArray[column][row];
	    	
	    	boolean value=true;;
	    	if(name.equals("ef")||name.equals("eh")||name.equals("ev")||name.equals("ps00")||name.equals("ps01")||name.equals("ps10")||name.equals("ps11")||
					name.equals("psh")||name.equals("psv")||name.equals("sh")||name.equals("sv")) {
				value=false;
				
			}
	    	
	    	return value;
	    }
	    
	    public boolean nearTile(int ii,int jj,int col,int row) {//this method approves the positions in the upper left right
			
	    	boolean active=false;
	    	
	    	if((col-1==ii&&row==jj)||(col==ii&&row+1==jj)||(col+1==ii&&row==jj)||(col==ii&&row-1==jj)) {
	    		active=true;
	    	}                                                                                      
	    	
	    	return active;
	    	
	    }
	  
	    /**this method performs control according to the id of the pane.*/
	public void gameFinalChecker(GridPane grdPane,Text score,Pane menuPane) { 

		String way = "";
		int emptycount = 0;
		int index = 0;
		for(int i = 0 ; i<allPanes.size();i++) {
			if(allPanes.get(i).getId().contains("Starter")) {
				if(allPanes.get(i).getId().startsWith("lft")) {
					endPanes.add(allPanes.get(i));
					way = "left";
					index = i;
				}
					else if(allPanes.get(i).getId().startsWith("bot")){
					endPanes.add(allPanes.get(i));
					way = "bot";
					index = i;
					}
			}
			if(allPanes.get(i).getId().equals("empty"))
				emptycount++;
			 }
			 for(int i =0 ; i<allPanes.size()-emptycount ; i++) {
			 switch(way) {
			 
			 case "bot" : 
				 if(index + 4 < 16) {
					 index = index+4;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way = "empty";
					 }
					 else  if(allPanes.get(index).getId().substring(0, 2).contains("t")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
							 way = "right";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("l")) {
							 way = "left";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
							 way = "bot";
							 endPanes.add(allPanes.get(index));
						 }
						 
					 }
				 }
					 break;
					 
			 case "right" :
				 if(index == 3 || index == 7 || index == 11)
					 break;
				 if(index + 1 < 16) {
					 index = index+1;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way = "empty";
					 }
					 else if (allPanes.get(index).getId().contains("ENDl")) {
						 way = "END";
						 endPanes.add(allPanes.get(index));
					 }
					  else if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
							 way = "right";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
							 way = "top";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
							 way = "bot";
							 endPanes.add(allPanes.get(index));
						 }
						
					  }
					 
				 }
				 

				 break;
				 
			 case "left" :
				 if(index == 12 || index == 4 || index == 8)
					 break;
				 if(index - 1 >= 0) {
					 index = index-1;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way ="empty";
					 }
					 else if(allPanes.get(index).getId().substring(0, 2).contains("r")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
							 way = "left";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
							 way = "top";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("b")) {
							 way = "bot";
							 endPanes.add(allPanes.get(index));
						 }
					 }
				 }
					 break;
				 
			 case "top" :
				 if(index - 4 >= 0) {
					 index = index-4;
					 if (allPanes.get(index).getId().contains("empty")) {
						 way ="empty";
					 }
					 else if (allPanes.get(index).getId().contains("END")) {
						 way = "END";
						 endPanes.add(allPanes.get(index));
					 }
					 else if(allPanes.get(index).getId().substring(0, 2).contains("b")) {
						 if(allPanes.get(index).getId().substring(0, 2).contains("l")) {
							 way = "left";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("t")) {
							 way = "top";
							 endPanes.add(allPanes.get(index));
						 }
						 else if (allPanes.get(index).getId().substring(0, 2).contains("r")) {
							 way = "right";
							 endPanes.add(allPanes.get(index));
						 }
					 }
					 
				 }
				 break;
		 
		 case "END" :
			 if (allPanes.size()-emptycount == endPanes.size()) { 
				 isEnded = true;
				 for(int ii=0;ii<endPanes.size();ii++) {
					 
					 animationPanes.add(endPanes.get(ii));//if the pipes are arranged correctly, the animation method is called.
				 }
			 
			 }
				
			 break;
		 
		 case "empty":
			 break;
			 
	}
		 
	}
		 endPanes.clear();
		 if(isEnded) {
			gameAnimation(grdPane,score,menuPane);
			}
}
	
	/**this method create lines path and use pathtransition*/
	public void gameAnimation(GridPane grdPane,Text score,Pane menuPane) { 
			Circle circle =new Circle(20, Color.AQUA);
			int colStart=0,rowStart=0,colEnd=0,rowEnd=0;
			
			int col = 0,row=0,col2=0,row2=0,col3=0,row3=0;
			int x=0,y=0;
			
			Path path =new Path();
			MoveTo moveTo = new MoveTo();
			colStart=GridPane.getColumnIndex(animationPanes.get(0));
			rowStart=GridPane.getRowIndex(animationPanes.get(0));
			colEnd=GridPane.getColumnIndex(animationPanes.get(animationPanes.size()-1));
			rowEnd=GridPane.getRowIndex(animationPanes.get(animationPanes.size()-1));
			
			
			if(animationPanes.get(0).getId()=="bot-Starter") {
					col=GridPane.getColumnIndex(animationPanes.get(0));
					row=GridPane.getRowIndex(animationPanes.get(0));
					moveTo.setX((200*col)+100);
					moveTo.setY((200*row)+100);
						y=((row+1)*200);
						x=(200*col)+100;
					
				}else if(animationPanes.get(0).getId()=="lft-Starter") {
					col=GridPane.getColumnIndex(animationPanes.get(0));
					row=GridPane.getRowIndex(animationPanes.get(0));
					moveTo.setX((200*col)+100);
					moveTo.setY((200*row)+100);
					x=(200*(col));
					y=(row*200)+100;
				}
				
				path.getElements().add(moveTo);
				menuPane.getChildren().add(circle);
					
					for(Pane anime: animationPanes) {
						
						
						row=GridPane.getRowIndex(anime);
						col=GridPane.getColumnIndex(anime);
						int location=animationPanes.indexOf(anime);
						
						if(location+1<animationPanes.size()) {
							row2=GridPane.getRowIndex(animationPanes.get(location+1));
							col2=GridPane.getColumnIndex(animationPanes.get(location+1));
						}
						if(location>=1) {
							row3=GridPane.getRowIndex(animationPanes.get(location-1));
							col3=GridPane.getColumnIndex(animationPanes.get(location-1));
						}
						
						
						if(anime.getId()=="tb-PipeNormal"||anime.getId()=="tb-PipeStatic") {
							if(colStart==col||row<row2) {
								 y=y+200; path.getElements().add(new VLineTo(y));
							}else if(colStart<col&&row>row2) {
								y=y-200;path.getElements().add(new VLineTo(y));
							}
						}else if(anime.getId()=="tr-PipeNormal"||anime.getId()=="tr-PipeStatic") {
							if(col3==col&&col<col2) {
								x=x+100;y=y+100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x));
							}else if(col3>col&&col==col2) {
								x=x-100;y=y-100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}
						}else if(anime.getId()=="tl-PipeNormal"||anime.getId()=="tl-PipeStatic") {
							if(row==row3&&row>row2) {
								x=x+100;y=y-100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}else if(row>row3&&row2==row) {
								x=x-100;y=y+100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x));
							}
						}else if(anime.getId()=="lr-PipeNormal"||anime.getId()=="lr-PipeStatic") {
							if(col3>col2) {
								x=x-200;path.getElements().add(new HLineTo(x));
							}else {
								x=x+200;path.getElements().add(new HLineTo(x));
							}
						}else if(anime.getId()=="bl-PipeNormal"||anime.getId()=="bl-PipeStatic") {
							if(col>col3) {
								x=x+100;y=y+100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}else {
								x=x-100;y=y-100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x));
							}
						}else if(anime.getId()=="br-PipeNormal"||anime.getId()=="br-PipeStatic") {
							if(row3>row&&col2>col) {
								x=x+100;y=y-100; path.getElements().add(new VLineTo(y)); path.getElements().add(new HLineTo(x)); 
							}else {
								x=x-100;y=y+100; path.getElements().add(new HLineTo(x)); path.getElements().add(new VLineTo(y));
							}
							
						}else if(anime.getId()=="ENDl-END") {
							
							x=x+150;path.getElements().add(new HLineTo(x));
							
						}else if(anime.getId()=="ENDb-END") {
							
							y=y-150; path.getElements().add(new VLineTo(y));
						}
						
					}
			
			animationX(grdPane,score,path, circle, menuPane); //call the animex method
			
		
	}

	public void animationX(GridPane grdPane,Text scoreText,Path path,Node circle,Pane menuPane) {

		PathTransition pt = new PathTransition(); //create pathtransition and use the path on pt.
		pt.setDuration(Duration.millis(2000));
		pt.setPath(path);
		pt.setNode(circle);
		pt.setOrientation(
			PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		//if the animation runs out the ball dissapears
		pt.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				menuPane.getChildren().remove(circle);
				
				event.consume();
				if(isEnded) {
					levelDrw(grdPane, menuPane, scoreText);
				}
			}
			
		});
		
		pt.play();
		pt.getOnFinished();
		
	}

	/**Add buttons to menu*/
	public void levelDrw(GridPane grdPane,Pane menuPane,Text score)  {
			if(level==1 ) {
			MenuItem level2= new MenuItem(grdPane,850, 250,menuPane,"2",score);
			}else if(level==2 ) {
			MenuItem level3= new MenuItem(grdPane,850, 300,menuPane,"3",score);
			}else if(level==3) {
			MenuItem level4= new MenuItem(grdPane,850, 350,menuPane,"4",score);
			}else if(level==4 ) {
			MenuItem level5= new MenuItem(grdPane,850, 400,menuPane,"5",score);
			}else if(level==5) {
			MenuItem level6= new MenuItem(grdPane,850, 450,menuPane,"6",score);
			}else if(level==6) {
				Image img =new Image("image/cong.jpg");
				ImageView imgv= new ImageView(img);
				imgv.setFitHeight(200);
				imgv.setFitWidth(800);
				imgv.setTranslateX(0);
				imgv.setTranslateY(300);
				menuPane.getChildren().add(imgv);		
			}
		
 		
	}
	public int getCounter() { 
		return scoreCount;
	}

	public void setCounter(int counter) {
		this.scoreCount = counter;
	}
}

	 
	


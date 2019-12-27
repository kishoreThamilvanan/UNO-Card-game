import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class CardDisplay extends Application  {
	
	public void start(Stage primaryStage) throws Exception
	{
	
		primaryStage.setTitle("UNO CARDS");
		Button b = new Button();
		
		b.setText("click me to show the cards");
		StackPane layout = new StackPane();
		
		layout.getChildren().add(b);
		
		Scene scene = new Scene(layout, 300,300);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		ImageView i = new ImageView("k.jpg");
		 ((Object) layout.getChildren()).addImage(i);
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}

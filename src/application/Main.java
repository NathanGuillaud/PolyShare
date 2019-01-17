package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.Router;


public class Main extends Application {
	
	public static Stage primaryStage = null;
	
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("/ui/connectionInscription/Login.fxml"));
		    Parent skillLayout = root.load();
	        Scene scene = new Scene(skillLayout, 700, 600);
	        
	        primaryStage.setTitle("FXML Welcome");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
		Router r = Router.getInstance();
		r.add("HomePage", "/ui/homePage/HomePage.fxml");
		r.add("Subject", "/ui/subject/Subject.fxml");
		r.add("Skill", "/ui/skill/Skill.fxml");
		r.add("Profil", "");
		r.add("Appointment", "/ui/appointement/Appointement.fxml");
		r.add("AddSingleSession", "/ui/appointement/HelpProposal.fxml");
		r.add("SchoolClass", "/ui/classes/SchoolClass.fxml");
		r.add("ConnectionInscription", "/ui/connectionInscription/Login.fxml");
		r.add("Forum", "");
		r.add("MediaFiles", "/ui/mediaFile/MediaFile.fxmls");
		r.add("MyAppointements", "/ui/myAppointements/MyAppointements.fxml");
	}
}

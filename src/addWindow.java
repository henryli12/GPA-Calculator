import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

public class addWindow {
	
	public static void display(String title, ObservableList<Course> courses) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Label dep = new Label("Department: ");
		Label code = new Label("Course Code: ");
		Label prof = new Label("Professor: ");
		Label grade = new Label("Grade: ");
		Label max = new Label("Max Credit: ");
		Label taking = new Label("Is it a course for you major? ");
		Label year = new Label("Year: ");
		Label semester = new Label("Semester: ");
		TextField depT = new TextField();
		TextField codeT = new TextField();
		TextField profT = new TextField();
		ObservableList<String> options =
				FXCollections.observableArrayList("A" , "A-","B+","B","B-","C+","C","C-","D+","D","D-","F");
		final ComboBox<String> letterGrade = new ComboBox<String>(options);
		TextField maxT = new TextField();
		ObservableList<String> options1 =
				FXCollections.observableArrayList("Yes" , "No");
		final ComboBox<String> takingT = new ComboBox<String>(options1);
		ObservableList<String> optionsYear =
				FXCollections.observableArrayList("2015" , "2016","2017","2018","2019",
				"2020","2021","2022","2023","2024","2025","2026","2027");
		final ComboBox<String> yearT = new ComboBox<String>(optionsYear);
		ObservableList<String> optionsSemester =
				FXCollections.observableArrayList("Spring" , "Summer","Fall","Winter");
		final ComboBox<String> SemesterT = new ComboBox<String>(optionsSemester);
		Button add = new Button("Add");
		add.setAlignment(Pos.CENTER_LEFT);
		add.setOnAction(e-> {
			try {
			String d = depT.getText();
			int c = Integer.parseInt(codeT.getText());
			String p = profT.getText();
			String g = letterGrade.getValue().toString();
			double m = Double.parseDouble(maxT.getText());
			String t;
			if(takingT.getValue().equals("Yes")) {
				t = "Yes";
			}else {
				t = "No";
			}
			String s = SemesterT.getValue() + " " + yearT.getValue();
			courses.add(new Course(d,c,p,g,m,t,s));
			window.close();
			}catch(Exception ex) {
				Alert.display("Invalid Input", "Invalid Input");
			}
		});
		Button cancel = new Button("Cancel");
		cancel.setAlignment(Pos.CENTER_RIGHT);
		cancel.setOnAction(e-> window.close());
		VBox layout = new VBox();
		layout.getChildren().addAll(dep,depT,code,codeT,prof,profT,grade,letterGrade,max,maxT,year,yearT,semester,SemesterT,taking,takingT,add,cancel);
		
		Scene scene = new Scene(layout, 300,500);
		window.setScene(scene);
		window.show();
		
	}
}

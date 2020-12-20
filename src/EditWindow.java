import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditWindow {
	public static void display(String title, ObservableList<Course> courses,int index) {
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
		depT.setText(courses.get(index).getDepartment());
		TextField codeT = new TextField();
		codeT.setText(courses.get(index).getCode() + "");
		TextField profT = new TextField();
		profT.setText(courses.get(index).getProfessor());
		ObservableList<String> options =
				FXCollections.observableArrayList("A" , "A-","B+","B","B-","C+","C","C-","D+","D","D-","F");
		final ComboBox<String> letterGrade = new ComboBox<String>(options);
		letterGrade.setValue(courses.get(index).letterGrade());
		TextField maxT = new TextField();
		maxT.setText(Double.toString(courses.get(index).getMaxCredit()));
		ObservableList<String> options1 =
				FXCollections.observableArrayList("Yes" , "No");
		final ComboBox<String> takingT = new ComboBox<String>(options1);
		takingT.setValue(courses.get(index).getMajorCourse());
		ObservableList<String> optionsYear =
				FXCollections.observableArrayList("2015" , "2016","2017","2018","2019",
				"2020","2021","2022","2023","2024","2025","2026","2027");
		final ComboBox<String> yearT = new ComboBox<String>(optionsYear);
		yearT.setValue(courses.get(index).getSemester().split(" ")[1]);
		ObservableList<String> optionsSemester =
				FXCollections.observableArrayList("Spring" , "Summer","Fall","Winter");
		final ComboBox<String> SemesterT = new ComboBox<String>(optionsSemester);
		SemesterT.setValue(courses.get(index).getSemester().split(" ")[0]);
		Button add = new Button("Done");
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
			courses.set(index,new Course(d,c,p,g,m,t,s));
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

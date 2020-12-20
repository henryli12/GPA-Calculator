import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application{
	
	Stage window;
	TableView<Course> table;
	Label TotalGPA;
	Label MajorGPA;
	Label Credits;
	Button getGPA;
	Button add;
	Button save;
	Button edit;
	Button delete;
	ObservableList<Course> courses = FXCollections.observableArrayList();
	Data data = new Data("data.txt");
	GPA gpa = new GPA(courses);
	int indexEdit;
	int indexDelete;
	
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Planner");

		data.upload(courses);
		
		
		//Mid
		TableColumn<Course, String> depColumn = new TableColumn<>("Department");
		depColumn.setMinWidth(100);
		depColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
		
		TableColumn<Course, Integer> codeColumn = new TableColumn<>("Code");
		codeColumn.setMinWidth(100);
		codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
		
		TableColumn<Course, String> profColumn = new TableColumn<>("Professor");
		profColumn.setMinWidth(100);
		profColumn.setCellValueFactory(new PropertyValueFactory<>("professor"));
		
		TableColumn<Course, String> gradeColumn = new TableColumn<>("Grade");
		gradeColumn.setMinWidth(100);
		gradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
		gradeColumn.setComparator(new gradeComparator());
		
		TableColumn<Course, Double> maxCredColumn = new TableColumn<>("Max Credit");
		maxCredColumn.setMinWidth(100);
		maxCredColumn.setCellValueFactory(new PropertyValueFactory<>("maxCredit"));
		
		TableColumn<Course,String> majorCourseColumn = new TableColumn<>("Course for major");
		majorCourseColumn.setMinWidth(100);
		majorCourseColumn.setCellValueFactory(new PropertyValueFactory<>("majorCourse"));
		
		TableColumn<Course,String> semesterColumn = new TableColumn<>("Semester");
		semesterColumn.setMinWidth(100);
		semesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
		semesterColumn.setComparator(new SemesterComparator());
		
		table = new TableView<Course>();
		table.setEditable(true);
		table.setItems(courses);
		table.getColumns().addAll(depColumn,codeColumn,profColumn,
				gradeColumn,maxCredColumn,semesterColumn,majorCourseColumn);
		
		VBox midMenu = new VBox();
		midMenu.getChildren().addAll(table);
		
		//Bot
		TotalGPA = new Label();
		TotalGPA.setMinWidth(100);
		MajorGPA = new Label();
		Credits = new Label();
		TotalGPA.setText("Total GPA: " + gpa.calcTotalGPA());
		MajorGPA.setText("Major GPA: " + gpa.calcMajorGPA());
		Credits.setText("Credits taken: " + gpa.getCredit());
		getGPA = new Button("Reload GPA");
		getGPA.setOnAction(e -> {
				TotalGPA.setText("Total GPA: " + gpa.calcTotalGPA());
				MajorGPA.setText("Major GPA: " + gpa.calcMajorGPA());
				Credits.setText("Credits taken: " + gpa.getCredit());
		});
		add = new Button("Add a new course");
		add.setOnAction(e -> {
			addWindow.display("Add",courses);
			gpa = new GPA(courses);
			TotalGPA.setText("Total GPA: " + gpa.calcTotalGPA());
			MajorGPA.setText("Major GPA: " + gpa.calcMajorGPA());
			Credits.setText("Credits taken: " + gpa.getCredit());
		});
		HBox botMenu = new HBox(20);
		botMenu.getChildren().addAll(getGPA,TotalGPA,MajorGPA,Credits,add);
		
		
		//Top
		
		HBox topMenu = new HBox(20);
		
		save = new Button("Save");
		save.setOnAction(e -> {
			try {
				data.save(courses);
				Alert.display("Saved", "Save successful");
			} catch (IOException e1) {
				Alert.display("Error", "Error");
			}
		});
		edit = new Button("Edit");
		indexEdit = 0;
		edit.setOnAction(e -> {
			Course course = table.getSelectionModel().getSelectedItem();
			if(course == null) {
				Alert.display("Error", "Please select a course to edit.");
			}else {
				for(int i = 0; i < courses.size();i++) {
					if(courses.get(i) == course) {
						indexEdit = i;
						break;
					}
				}
				EditWindow.display("Edit",courses,indexEdit);
			}
		});
		indexDelete = 0;
		delete = new Button("Delete");
		delete.setOnAction(e -> {
			
			Course course = table.getSelectionModel().getSelectedItem();
			if(course == null) {
				Alert.display("Error", "Please select a course to edit.");
			}else {
				for(int i = 0; i < courses.size();i++) {
					if(courses.get(i) == course) {
						indexDelete = i;
						break;
					}
				}
				courses.remove(indexDelete);
			}	
		});
		topMenu.getChildren().addAll(save,edit,delete);
		
		
		//Main Layout
		BorderPane layout= new BorderPane();
		layout.setCenter(midMenu);
		layout.setTop(topMenu);
		layout.setBottom(botMenu);
		//Scene
		Scene scene = new Scene(layout,700,500);
		window.setScene(scene);
		window.show();
	}
}






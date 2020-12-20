import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import javafx.collections.ObservableList;

public class Data {
	private File file;
	public Data(String file) {
		this.file = new File(file);
	}
	public void save(ObservableList<Course> courses) throws IOException {
		FileWriter fw = new FileWriter(file, false);
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0; i < courses.size();i++) {
				pw.println(courses.get(i).getDepartment() + "," +
						courses.get(i).getCode() + "," + 
						courses.get(i).getProfessor() + "," +
						courses.get(i).getLetterGrade() + "," +
						courses.get(i).getMaxCredit() + "," +
						courses.get(i).getMajorCourse() + "," +
						courses.get(i).getSemester());
				pw.flush();
		}
		pw.close();
	}
	public ObservableList<Course> upload(ObservableList<Course> list) throws FileNotFoundException{
		if(file.exists()) {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String[] temp = reader.nextLine().split(",");
				list.add(new Course(temp[0],Integer.parseInt(temp[1]),temp[2]
						,temp[3],Double.parseDouble(temp[4]),
						temp[5],temp[6]));
			}
			reader.close();
			
			
			return list;
		}else {
			return list;
		}
	}
}

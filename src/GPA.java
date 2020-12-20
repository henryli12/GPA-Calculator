import javafx.collections.ObservableList;

public class GPA {
	private ObservableList<Course> courses;
	public GPA(ObservableList<Course> courses) {
		this.courses = courses;
	}
	public double calcTotalGPA() {
		double grade = 0;
		double max = 0;
		for(int i = 0 ; i < courses.size();i++) {
			Course temp = courses.get(i);
			grade += temp.getGrade() * temp.getMaxCredit();
			max += temp.getMaxCredit();
		}
		double gpa = grade / max;
		gpa =Math.round(gpa*100);
		gpa /= 100;
		return gpa;
	}
	public double calcMajorGPA() {
		double grade = 0;
		double max = 0;
		for(int i = 0 ; i < courses.size();i++) {
			if(courses.get(i).getMajorCourse().equalsIgnoreCase("Yes")) {
				Course temp = courses.get(i);
				grade += temp.getGrade() * temp.getMaxCredit();
				max += temp.getMaxCredit();
			}
		}
		double gpa = grade / max;
		gpa =Math.round(gpa*100);
		gpa /= 100;
		return gpa;
	}
	public int getCredit() {
		int credit = 0;
		for(int i = 0; i < courses.size();i++) {
			credit += courses.get(i).getMaxCredit();
		}
		return credit;
	}
}

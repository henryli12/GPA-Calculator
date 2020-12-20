
public class Course {
	private String department;
	private int code;
	private String professor;
	private double maxCredit;
	private String letterGrade;
	private double grade;
	private String majorCourse;
	private String semester;
	public Course(String department, int code, String professor,String letterGrade,
			double maxCredit, String majorCourse,String semester) {
		this.department = department;
		this.code = code;
		this.professor = professor;
		this.maxCredit = maxCredit;
		this.letterGrade = letterGrade;
		this.majorCourse = majorCourse;
		this.setGrade(letterGrade);
		this.semester = semester;
	}
	public void setDepartment(String newDep) {
		this.department = newDep;
	}
	public String getDepartment() {
		return this.department;
	}
	public void setCode(int newCode) {
		this.code = newCode;
	}
	public int getCode() {
		return this.code;
	}
	public void setProfessor(String newProfessor) {
		this.professor = newProfessor;
	}
	public String getProfessor() {
		return this.professor;
	}
	public void setMaxCredit(double newMax) {
		this.maxCredit = newMax;
	}
	public double getMaxCredit() {
		return this.maxCredit;
	}
	public void setLetterGrade(String newLetterGrade) {
		this.letterGrade = newLetterGrade;
	}
	public String getLetterGrade() {
		return this.letterGrade;
	}
	public void setGrade(String letterGrade) {
		switch(letterGrade) {
		case "A" :
			grade = 4;
			break;
		case "A-" :
			grade = 3.67;
			break;
		case "B+" :
			grade = 3.33;
			break;
		case "B" :
			grade = 3;
			break;
		case "B-" :
			grade = 2.67;
			break;
		case "C+" :
			grade = 2.33;
			break;
		case "C" :
			grade = 2;
			break;
		case "C-" :
			grade = 1.67;
			break;
		case "D+" :
			grade = 1.33;
			break;
		case "D" :
			grade = 1;
			break;
		default:
			grade = 0;
		}
	}
	public String letterGrade() {
		String grade;
		switch(Double.toString(this.grade)) {
		case "4.0" :
			grade = "A";
			break;
		case "3.67" :
			grade = "A-";
			break;
		case "3.33" :
			grade = "B+";
			break;
		case "3.0" :
			grade = "B";
			break;
		case "2.67" :
			grade = "B-";
			break;
		case "2.33" :
			grade = "C+";
			break;
		case "2.0" :
			grade = "C";
			break;
		case "1.67" :
			grade = "C-";
			break;
		case "1.33" :
			grade = "D+";
			break;
		case "1.0" :
			grade = "D";
			break;
		default:
			grade = "F";
		}
		return grade;
	}
	public double getGrade() {
		return this.grade;
	}
	public void setMajorCourse(String newMajorCourse) {
		this.majorCourse = newMajorCourse;
	}
	public String getMajorCourse() {
		return this.majorCourse;
	}
	public void setSemester(String newSemester) {
		this.semester = newSemester;
	}
	public String getSemester() {
		return this.semester;
	}
}

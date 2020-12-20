import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class gradeComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String c1 = (String)o1;
		double g1 = getGrade(c1);
		String c2 = (String)o2;
		double g2 = getGrade(c2);
		if(g1 > g2) {
			return 1;
		}else if(g2 > g1) {
			return -1;
		}else {
		return 0;
		}
	}
	public static double getGrade(String letterGrade) {
		double grade;
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
		return grade;
	}
	
}
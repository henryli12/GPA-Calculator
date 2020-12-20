import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class SemesterComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String a1 = (String)o1;
		String[] b1 = a1.split(" ");
		String a2 = (String)o2;
		String[] b2 = a2.split(" ");
		if(b1[1].compareTo(b2[1]) > 0) {
			return 1;
		}else if(b1[1].compareTo(b2[1]) < 0) {
			return -1;
		}else {
			if(orderSemester(b1[0]) > orderSemester(b2[0])) {
				return 1;
			}else if(orderSemester(b1[0]) < orderSemester(b2[0])) {
				return -1;
			}
			return 0;
		}
	}
	public static int orderSemester(String semester) {
		int a;
		switch(semester) {
		case"Spring":
			a = 1;
			break;
		case"Summer":
			a = 2;
			break;
		case"Fall":
			a = 3;
			break;
		default:
			a = 4;
		}
		return a;
	}
}

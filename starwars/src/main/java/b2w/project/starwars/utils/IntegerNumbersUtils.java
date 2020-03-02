package b2w.project.starwars.utils;

public class IntegerNumbersUtils {

	private static Integer nextNumber = 0;
	
	public static Integer next() {
		nextNumber ++;
		return nextNumber;
	}
}

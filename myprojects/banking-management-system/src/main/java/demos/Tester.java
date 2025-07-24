package demos;
public class Tester {
	static int m(int i) {
		try {
			System.out.println("1. TRY block CALLED");
			i++;
			if (i == 1)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("2. CATCH block CALLED");
			i += 10;
			return i;
		} finally {
			i += 5;
			System.out.println("3.FINALLY block CALLED:"+i);
		}
		i++;
		System.out.println("LAST :"+i);
		return i;
	}
	public static void main(String[] args) {
		System.out.println(m(0));
	}
}
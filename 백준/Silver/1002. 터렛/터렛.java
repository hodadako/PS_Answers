import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int i = 0; i < TC; i++) {
			double x1 = sc.nextDouble();
			double y1 = sc.nextDouble();
			double r1 = sc.nextDouble();
			double x2 = sc.nextDouble();
			double y2 = sc.nextDouble();
			double r2 = sc.nextDouble();

			double d = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

			double longer = Math.max(r1, r2);
			double shorter = Math.min(r1, r2);

			double diff = Math.pow(longer - shorter, 2);
			double sum = Math.pow(longer + shorter, 2);
			if (d == 0) {
				if (diff == 0) {
					System.out.println(-1);
				} else {
					System.out.println(0);
				}
			} else if (diff < d && d < sum) {
				System.out.println(2);
			} else if (diff == d || sum == d) {
				System.out.println(1);
			} else if (d < diff) {
				System.out.println(0);
			} else if (d > sum) {
				System.out.println(0);
			}
		}
	}
}
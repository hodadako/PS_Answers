import java.io.*;
import java.util.*;

class Main {
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		double total = 0;

		while (sc.hasNext()) {
			String s = sc.nextLine();
			map.put(s, map.getOrDefault(s, 0) + 1);
			total++;
		}
		
		ArrayList<String> list = new ArrayList<>(map.keySet());

		Collections.sort(list);		

		for (String key : list) {
			System.out.printf("%s %.4f\n", key, map.get(key) * 100 / total);
		}
	}
}
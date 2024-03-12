import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

class Main {
	static int N;
	static HashMap<String, Integer> map;
	static TreeSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new HashMap();
		set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			String extension = br.readLine().split("\\.")[1];
			map.put(extension, map.getOrDefault(extension, 0) + 1);
			set.add(extension);
		}
		for (String element : set) {
			System.out.println(element + " " + map.get(element));
		}
	}
}

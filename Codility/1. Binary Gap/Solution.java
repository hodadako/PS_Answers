import java.util.*;

class Solution {
	int max = (int)Math.pow(2, 30);
	ArrayList<Integer> list = new ArrayList<>();
	public int solution(int N) {
		while (N != 0) {
			if (max > N) {
				max = max >> 1;
			} else if (max <= N) {
				N -= max;
				list.add(binaryLog(max));
			}
		}

		if (list.size() == 0 || list.size() == 1) {
			return 0;
		} else {
			int answer = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				answer = Math.max(answer, list.get(i) - list.get(i + 1) - 1);
			}
			return answer;
		}
	}

	public int binaryLog(int x) {
		return (int) (Math.log10(x) / Math.log10(2));
	}
}

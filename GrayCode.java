import java.util.ArrayList;

public class GrayCode {

	public static void main(String[] args) {
		System.out.println(grayCode(3));

	}

	public static ArrayList<Integer> grayCode(int n) {
		if (n == 0) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.add(0);
			return res;
		}

		ArrayList<Integer> tmp = grayCode(n - 1);
		int number = 1 << (n - 1);
		ArrayList<Integer> res = new ArrayList<Integer>(tmp);
		for (int i = tmp.size() - 1; i >= 0; i--) {
			res.add(tmp.get(i) + number);
		}
		return res;
	}
}

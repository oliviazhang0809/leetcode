
public class Compare_version_number {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.0", "1"));
	}

	public static int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int index1 = 0, index2 = 0;
		while (index1 < arr1.length && index2 < arr2.length) {
			int tmp1 = Integer.valueOf(arr1[index1]);
			int tmp2 = Integer.valueOf(arr2[index2]);
			if (tmp1 != tmp2) {
				return (tmp1 > tmp2) ? 1 : -1;
			} else {
				index1++;
				index2++;
			}
		}

		// eliminate trailing zero
		while (index1 < arr1.length && Integer.valueOf(arr1[index1]) == 0) {
			index1++;
		}
		while (index2 < arr2.length && Integer.valueOf(arr2[index2]) == 0) {
			index2++;
		}
		
		if (index1 == arr1.length && index2 == arr2.length) {
			return 0;
		} else {
			return (index1 < arr1.length) ? 1 : -1;
		}
	}
}

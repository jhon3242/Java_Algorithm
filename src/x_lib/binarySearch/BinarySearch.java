package x_lib.binarySearch;

public class BinarySearch {

	private static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] < target) start = mid + 1;
			else end = mid - 1;
		}
		return arr.length - start;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int i = binarySearch(arr, 8);
		System.out.println("i = " + i);
	}
}

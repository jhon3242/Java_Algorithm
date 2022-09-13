package x_lib.KMP;

public class KMP {
	public static void main(String[] args) {
		String src = "baekjoon";
		String pat = "joo";

		kmp(src, pat);
	}
	static private int[] makeTable(String pattern){
		int n = pattern.length();
		int[] table = new int[n];
		int k = 0;
		for (int i = 1; i < n; i++) {
			while (k > 0 && pattern.charAt(i) != pattern.charAt(k)){
				k = table[k - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(k)){
				k += 1;
				table[i] = k;
			}
		}
		return table;
	}

	static void kmp(String src, String pattern){
		int[]   table = makeTable(pattern);
		char[]  src_arr = src.toCharArray();
		char[]  pat_arr = pattern.toCharArray();
		int     k = 0;

		for (int i = 0; i < src_arr.length; i++) {
			while (k > 0 && src_arr[i] != pat_arr[k]){
				k = table[k - 1];
			}
			if (src_arr[i] == pat_arr[k]){
				if (k == pat_arr.length - 1){
					System.out.println(1);
					return;
				}
				else{
					k++;
				}
			}
		}
		System.out.println(0);
	}
}

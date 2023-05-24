package x_lib.boyerMoore;

import java.util.Arrays;

public class BoyerMoore {
	static int boyerMoore(String dest, String pat)
	{
		int dest_i;
		int pat_i;
		int dest_len = dest.length();
		int pat_len = pat.length();
		int[] table = new int[Character.MAX_VALUE + 1];

		// 배열의 요소 초기화
		for (int i = 0; i < table.length; i++)
			table[i] = pat_len;
		// pattern에 있는 문자에 대해 table 값 변경
		for (int i = 0; i < pat_len; i++)
			table[pat.charAt(i)] = pat_len - 1 - i;

		dest_i = pat_len - 1;
		while (dest_i < dest_len)
		{
			pat_i = pat_len - 1;
			//dest의 문자와 pattern의 문자가 같을 경우
			while (dest.charAt(dest_i) == pat.charAt(pat_i))
			{
				if(pat_i == 0)
					return dest_i;
				dest_i--;
				pat_i--;
			}
			//dest의 문자와 pattern의 문자가 다를 경우
			dest_i += Math.max(table[dest.charAt(dest_i)], pat_len - pat_i);
		}
		return -1;
	}


	private int boyerMoore2(String str, String pat) {
		int[] table = new int[Character.MAX_VALUE + 1];
		int strL = str.length();
		int patL = pat.length();
		int strI;
		int patI;

		// table 초기화
		Arrays.fill(table, patL);

		// pat 에 있는 문자는 해당 문자 인덱스 위치만큼 점프하기 위해 초기화
		for (int i = 0; i < patL; i++) {
			table[pat.charAt(i)] = patL - 1 - i;
		}

		// pat 문자 오른쪽 끝부터 확인하기 위해 인덱스 초기화
		strI = patL - 1;
		while (strI < strL) {
			patI = patL - 1;
			// 문자가 일치 했을 때
			while (str.charAt(strI) == pat.charAt(patI)) {
				if (patI == 0) {
					return strI;
				}
				strI--;
				patI--;
			}

			// 문자가 일치하지 않았을 때
			strI += Math.max(table[str.charAt(strI)], patL - patI);
		}
		return -1;
	}
}

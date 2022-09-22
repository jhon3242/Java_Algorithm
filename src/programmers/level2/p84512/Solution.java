package programmers.level2.p84512;

import java.util.*;

class Solution {
	public int solution(String word) {
		char[] characters = {'A', 'E', 'I', 'O', 'U'};
		List<String> dict = new ArrayList<>();
		char[] tmp = new char[5];
		for(int i=0; i<5; i++){
			tmp[0] = characters[i];
			dict.add(new String(Arrays.copyOfRange(tmp, 0, 1)));
			for (int j=0; j<5; j++){
				tmp[1] = characters[j];
				dict.add(new String(Arrays.copyOfRange(tmp, 0, 2)));
				for (int p=0; p<5; p++){
					tmp[2] = characters[p];
					dict.add(new String(Arrays.copyOfRange(tmp, 0, 3)));
					for (int q=0; q<5; q++){
						tmp[3] = characters[q];
						dict.add(new String(Arrays.copyOfRange(tmp, 0, 4)));
						for (int r=0; r<5; r++){
							tmp[4] = characters[r];
							dict.add(new String(tmp));
							tmp[4] = '\0';
						}
						tmp[3] = '\0';
					}
					tmp[2] = '\0';
				}
				tmp[1] = '\0';
			}
			Arrays.fill(tmp, '\0');
		}
		for (int i=0; i<dict.size(); i++){
			if (dict.get(i).equals(word))
				return i+1;
		}
		return -1;
	}
}

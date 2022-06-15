package programmers.level1.p72410;


import java.util.ArrayList;

class Solution {

	static ArrayList<Integer> removeIdx = new ArrayList<>();

	public static String solution(String new_id) {
		new_id = new_id.toLowerCase();  // 1. 소문자로 처리
		StringBuilder answer = new StringBuilder(new_id);
		String tmp;
		boolean flag = false;

		for (int i=0; i<answer.length(); i++){
			char c = answer.charAt(i);

			if (!(('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.')) // 2. 허용문자 처리
				removeIdx.add(i);
			else if (c == '.'){ // 3. 점 반복 처리
				if (flag)
					removeIdx.add(i);
				else
					flag = true;
			}
			else
				flag = false;
		}
		// 삭제할 인덱스 삭제
		int len = removeIdx.size() - 1;
		for (int i=len; i>=0; i--)
			answer.deleteCharAt(removeIdx.get(i));

		// 4. 앞뒤 점 처리
		if (answer.charAt(0) == '.')
			answer.deleteCharAt(0);
		if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
			answer.deleteCharAt(answer.length() - 1);

		// 5. 빈문자열이면 "a"추가
		if (answer.length() == 0)
			answer.append("a");

		// 6. 16자 이상이면 슬라이싱 + 뒤에 . 있으면 지우기
		if (answer.length() >= 16)
			answer = new StringBuilder(answer.substring(0, 15));
		if (answer.charAt(answer.length() - 1) == '.')
			answer.deleteCharAt(answer.length() - 1);

		// 7. 2자 이하이면 3자 될때까지 맨 뒤 문자 반복
		while (answer.length() <= 2){
			answer.append(answer.charAt(answer.length() - 1));
		}

		return answer.toString();
	}

}
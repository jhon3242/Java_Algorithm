package programmers.level2.p77885;

class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i=0; i<numbers.length; i++){
			String bit = Long.toString(numbers[i], 2);
			char[] target = bit.toCharArray();
			char[] newBits;
			int zeroIdx = -1, startIdx, changeIdx, count;
			for (int j=target.length-1; j>=0; j--){
				if (target[j] == '0'){
					zeroIdx = j;
					break;
				}
			}
			if (zeroIdx == -1){ // 1111 같이 1만 있는 2진수의 경우
				newBits = new char[target.length + 1];
				newBits[0] = '1';
				startIdx = 1;
				changeIdx = 1;
				count = 1;
			}
			else{
				newBits = new char[target.length];
				newBits[zeroIdx] = '1';
				startIdx = 0;
				changeIdx = zeroIdx + 1;
				count = 2;
			}

			// copy
			for (int j=0; j<target.length; j++){
				if (j != zeroIdx)
					newBits[j + startIdx] = target[j];
			}

			// 0 바꾸기
			for (int j=changeIdx; j<newBits.length; j++){
				if (newBits[j] == '1'){
					newBits[j] = '0';
					count--;
				}
				if (count >= 0)
					break;
			}
			answer[i] = Long.parseLong(new String(newBits), 2);
		}
		return answer;
	}
}
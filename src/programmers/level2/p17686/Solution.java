package programmers.level2.p17686;

import java.util.*;
import java.util.regex.*;

class Solution {
	public String[] solution(String[] files) {
		String[] answer = {};
		List<File> list = new ArrayList<>();

		for (String file : files) {
			list.add(new File(file));
		}

		Collections.sort(list);
		return list.stream()
				.map(v -> v.fileName)
				.toArray(String[]::new);
	}
}

class File implements Comparable<File> {
	public String fileName;
	public String head;
	public String mid;
	public String tail;

	public File(String fileName) {
		Pattern compile = Pattern.compile("([^0-9]+)([0-9]+)(.*$)");
		Matcher matcher = compile.matcher(fileName);
		this.fileName = fileName;
		while (matcher.find()) {
			this.head = matcher.group(1).toUpperCase();
			this.mid = matcher.group(2);
			this.tail = matcher.group(3).toUpperCase();
		}
	}

	@Override
	public int compareTo(File f) {
		int diff = this.head.compareTo(f.head);
		if (diff == 0) {
			diff = Integer.parseInt(this.mid) - Integer.parseInt(f.mid);
		}
		return diff;
	}

	@Override
	public String toString() {
		return this.fileName;
	}
}
package baekjoon.p3568;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		String type = "";
		String[] values = new String[]{};

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				type = str.substring(0, i);
				values = str.substring(i + 1, str.length() -1).split(", ");
				break;
			}
		}

		for (String value : values) {
			Matcher matcher = Pattern.compile("^([a-zA-Z]*)").matcher(value);
			if (matcher.find()) {
				String group = matcher.group(1);
				String newType =  type + value.replace(group, "");
//				System.out.println("group = " + group);

				List<Character> a = new ArrayList<>();
				List<Character> b = new ArrayList<>();
				List<Character> c = new ArrayList<>();
				List<Character> d = new ArrayList<>();

				for (char c1 : newType.toCharArray()) {
					if (c1 == '&') a.add('&');
					else if (c1 == '[') b.add('[');
					else if (c1 == ']') b.add(']');
					else if (c1 == '*') c.add('*');
					else d.add(c1);
				}
				StringBuilder sb = new StringBuilder();

				d.forEach(sb::append);
				a.forEach(sb::append);
				b.forEach(sb::append);
				c.forEach(sb::append);
				sb.append(" ");
				sb.append(group);
				sb.append(";");
				System.out.println(sb);
			}
		}
	}
}

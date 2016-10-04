package hu.codecool.phoneDial;

import java.util.HashMap;
import java.util.Map;

public class PhoneDial {
	
	static Map<String, String> nums = new HashMap<>();
	static
	{
		nums.put("2", "ABC");
		nums.put("3", "DEF");
		nums.put("4", "GHI");
		nums.put("5", "JKL");
		nums.put("6", "MNO");
		nums.put("7", "PQRS");
		nums.put("8", "TUV");
		nums.put("9", "WXYZ");
		nums.put("0", " ");
	}

	public static String convert(String raw){
		String result = "";
		String[] fragments = raw.split("(?<=(.))(?!\\1)");
		for (int i = 0; i < fragments.length; i++) {
			String numType = String.valueOf(fragments[i].charAt(0));
			if (numType.equals("1")) {
				continue;
			}
			
			String charsOfNum = nums.get(numType);
			String chars = fragments[i];
			int numIndex;
			if (chars.length() <= charsOfNum.length()) {
				numIndex = chars.length() - 1;
			}
			else {
				numIndex = chars.length() % charsOfNum.length() - 1;
			}
			
			result += charsOfNum.charAt(numIndex);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(convert("36660887777331308666022212555155506330666166022233555155574466616633"));
	}

}

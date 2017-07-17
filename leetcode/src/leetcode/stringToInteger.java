package leetcode;

import java.util.regex.Pattern;

public class stringToInteger {
	public static int myAtoi(String str) {
		String buffer;
		Pattern pattern = Pattern.compile("^[-+]?\\d+$");
		if(str.contains(" ")&&str.isEmpty()==false){
			str=str.replaceAll(" ", "");
			if(pattern.matcher(str).matches()!=true){
				buffer=str.replaceAll("[^a-zA-Z]+", "");
				if(buffer.isEmpty() == false){
					buffer=buffer.substring(0, 1);
					str=str.substring(0,str.indexOf(buffer));
				}
			}
		}
		try{
			return Integer.parseInt(str);
		}catch(Exception ex){
			return 0;
		}
	     
    }
	public static void main(String[] args) {
		 String str ="   +0 123";
		 int y;
		 y=myAtoi(str);
		 System.out.println(y);
	}
}

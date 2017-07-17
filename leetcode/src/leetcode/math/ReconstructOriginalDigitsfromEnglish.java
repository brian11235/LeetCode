package leetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructOriginalDigitsfromEnglish {
	public static String originalDigits(String s) {
		List<String> sList = new ArrayList<String>();
		String[] sArr = s.split("");
		StringBuffer convertString = new StringBuffer();
		int oneCount=0;
		int twoCount=0;
		int threeCount=0;
		int fourCount=0;
		for(int i = 0 ; i<sArr.length ; i++){
			sList.add(sArr[i]);
		}
		//zero
		while(sList.contains("z")){
			sList.remove(sList.indexOf("z"));
			sList.remove(sList.indexOf("e"));
			sList.remove(sList.indexOf("r"));
			sList.remove(sList.indexOf("o"));
			convertString.append("0");
		}
		// four, two
		while(sList.contains("w")){
			sList.remove(sList.indexOf("t"));
			sList.remove(sList.indexOf("w"));
			sList.remove(sList.indexOf("o"));
			twoCount++;
		}
		while(sList.contains("u")){
			sList.remove(sList.indexOf("f"));
			sList.remove(sList.indexOf("o"));
			sList.remove(sList.indexOf("u"));
			sList.remove(sList.indexOf("r"));
			fourCount++;
		}
		//one
		while(sList.contains("o")){
			sList.remove(sList.indexOf("o"));
			sList.remove(sList.indexOf("n"));
			sList.remove(sList.indexOf("e"));
			oneCount++;
		}
		//three
		while(sList.contains("r")){
			sList.remove(sList.indexOf("t"));
			sList.remove(sList.indexOf("h"));
			sList.remove(sList.indexOf("r"));
			sList.remove(sList.indexOf("e"));
			sList.remove(sList.indexOf("e"));
			threeCount++;
		}
		for(int i = 0 ; i<oneCount ; i++){
			convertString.append("1");
		}
		for(int i = 0 ; i<twoCount ; i++){
			convertString.append("2");
		}
		for(int i = 0 ; i<threeCount ; i++){
			convertString.append("3");
		}
		for(int i = 0 ; i<fourCount ; i++){
			convertString.append("4");
		}
		//five
		while(sList.contains("f")){
			sList.remove(sList.indexOf("f"));
			sList.remove(sList.indexOf("i"));
			sList.remove(sList.indexOf("v"));
			sList.remove(sList.indexOf("e"));
			convertString.append("5");
		}
		//six
		while(sList.contains("x")){
			sList.remove(sList.indexOf("s"));
			sList.remove(sList.indexOf("i"));
			sList.remove(sList.indexOf("x"));
			convertString.append("6");
		}
		//seven
		while(sList.contains("s")){
			sList.remove(sList.indexOf("s"));
			sList.remove(sList.indexOf("e"));
			sList.remove(sList.indexOf("v"));
			sList.remove(sList.indexOf("e"));
			sList.remove(sList.indexOf("n"));
			convertString.append("7");
		}	
		//eight
		while(sList.contains("g")){
			sList.remove(sList.indexOf("e"));
			sList.remove(sList.indexOf("i"));
			sList.remove(sList.indexOf("g"));
			sList.remove(sList.indexOf("h"));
			sList.remove(sList.indexOf("t"));
			convertString.append("8");
		}
		//nine
		while(sList.contains("n")){
			sList.remove(sList.indexOf("n"));
			sList.remove(sList.indexOf("i"));
			sList.remove(sList.indexOf("n"));
			sList.remove(sList.indexOf("e"));
			convertString.append("9");
		}			
		return convertString.toString();
    }
	public static void main(String[] args){
		originalDigits("zeroonetwothreefourfivesixseveneightnine");
	}
}
	


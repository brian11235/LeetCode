package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countAndSay {
	public static String count(int n) {
		Integer s = new Integer(n);
		Map<Integer,String> numMap=new HashMap<Integer,String>();
		String finalString = "";
		String buffString ="";
		numMap.put(1, "1");
		numMap.put(2,"1"+numMap.get(1));
		List<String> arr = new ArrayList<String>();
		if(s==2){
			return numMap.get(2);
		}else if(s>2){
			for(int i=0;i<s-2;i++){
				for(int j=0; j<numMap.get(numMap.size()).length();j++)
					if(j+1<numMap.get(numMap.size()).length()){
						if(numMap.get(numMap.size()).charAt(j)==numMap.get(numMap.size()).charAt(j+1)){
							buffString=buffString+numMap.get(numMap.size()).charAt(j);
						}else{
							if(!(buffString.equals(""))){
								buffString=buffString+numMap.get(numMap.size()).charAt(j);
								arr.add(buffString);
								buffString="";
							}else{
								arr.add(String.valueOf(numMap.get(numMap.size()).charAt(j)));
							}
						}
					}else{
						if(!(buffString.equals(""))){
							buffString=buffString+numMap.get(numMap.size()).charAt(j);
							arr.add(buffString);
							buffString="";
						}else{
							arr.add(String.valueOf(numMap.get(numMap.size()).charAt(j)));
						}
					}
				for(int k =0; k < arr.size();k++){
					if(arr.get(k).length()!=1){
						finalString=finalString+arr.get(k).length()+arr.get(k).charAt(0);
					}else{
						finalString =finalString+"1"+arr.get(k);
					}
				}
				numMap.put(numMap.size()+1, finalString);
				arr.clear();
				finalString="";
				buffString="";
			}
			
		}
		else{
			return numMap.get(1);
		}	
		return numMap.get(numMap.size());
    }
	public static void main(String[] args) {
		 int a=5;
		 System.out.println(count(a));
	}
}

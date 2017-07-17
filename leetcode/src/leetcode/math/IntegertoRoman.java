package leetcode.math;

/**
 * 數字拆解即可
 * 
 * @author brian
 *
 */
public class IntegertoRoman {
	public static String intToRoman(int num) {
		String numString = String.valueOf(num);
		StringBuffer romanString = new StringBuffer();
		String number;
		int singleNumber;
		while(numString.length()!=0){
			number=numString.substring(0,1);
			singleNumber=Integer.parseInt(number);
			if(numString.length()==4){
				for(int i = 0 ; i<singleNumber ; i++){
					romanString.append("M");
				}
			}
			if(numString.length()==3){
				if(singleNumber!=0){
					if(singleNumber<=3){
						for(int i = 0 ; i<singleNumber ; i++){
							romanString.append("C");
						}
					}else if(singleNumber==4){
						romanString.append("CD");
					}else if(4<singleNumber&&singleNumber<9){
						romanString.append("D");
						for(int i = 0 ; i<singleNumber-5 ; i++){
							romanString.append("C");
						}
					}else{
						romanString.append("CM");
					}
				}
			}
			if(numString.length()==2){
				if(singleNumber!=0){
					if(singleNumber<=3){
						for(int i = 0 ; i<singleNumber ; i++){
							romanString.append("X");
						}
					}else if(singleNumber==4){
						romanString.append("XL");
					}else if(4<singleNumber&&singleNumber<9){
						romanString.append("L");
						for(int i = 0 ; i<singleNumber-5 ; i++){
							romanString.append("X");
						}
					}else{
						romanString.append("XC");
					}
				}
			}
			if(numString.length()==1){
				if(singleNumber!=0){
					if(singleNumber<=3){
						for(int i = 0 ; i<singleNumber ; i++){
							romanString.append("I");
						}
					}else if(singleNumber==4){
						romanString.append("IV");
					}else if(4<singleNumber&&singleNumber<9){
						romanString.append("V");
						for(int i = 0 ; i<singleNumber-5 ; i++){
							romanString.append("I");
						}
					}else{
						romanString.append("IX");
					}
				}
			}
			numString = numString.substring(1, numString.length());
		}
		return romanString.toString();
    }
	public static void main(String[] args){
		intToRoman(10);
	}
}
//indexRoman.put("1", "I");
//indexRoman.put("5", "V");
//indexRoman.put("10", "X");
//indexRoman.put("50", "L");
//indexRoman.put("100", "C");
//indexRoman.put("500", "D");
//indexRoman.put("1000", "M");
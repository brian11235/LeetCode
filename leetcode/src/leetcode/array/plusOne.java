package leetcode.array;

public class plusOne {
	public static int[] plusOne(int[] digits) {
		if(digits.length==1||digits[digits.length-1]!=9){
			digits[digits.length-1]=digits[digits.length-1]+1;
		}else{
			for(int i=digits.length-1;i >0;i--){
				if(digits[i]+1>9){
					digits[i]=0;
					digits[i-1]=digits[i-1]+1;
				}
				if(digits[i-1]!=10&&digits[0]!=10){
					return digits;
				}
			}
		}
		if(digits[0]>=10){
			int[] newArr= new int[digits.length+1];
			newArr[0]=1;
			digits=newArr;
		}
		return digits;
    }
	public static void main(String[] args){
		int[] array={2,9,9};
		plusOne(array);
	}
}

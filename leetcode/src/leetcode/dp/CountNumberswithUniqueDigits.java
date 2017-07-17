package leetcode.dp;
/**
 * 找出規律
 * result = result + 9*(10-1)(10-2)(10-3)->看n為多少
 * @author brian
 *
 */
public class CountNumberswithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
		int result=10;
		int temp = 1;
		if(n==0){
			return 1;
		}
		if(n==1){
			return result;
		}
    	if(n>=2){
    		for(int i=2; i<=n; i++){
    			for(int j =1 ; j <i ; j++){
    				temp=temp*(10-j);
    			}
    			result=result+9*temp;
    			temp=1;
    		}
    	}
    	return result;
    }
    public static void main(String[] args){
    	countNumbersWithUniqueDigits(3);
    }
}

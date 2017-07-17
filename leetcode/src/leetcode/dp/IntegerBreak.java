package leetcode.dp;
/**
 * 5以上即有規律,切分出3即可(剩下2,3,4)
 * 5=3+2
 * 6=3+3
 * 7=3+4
 * 8=3+3+2
 * 9=3+3+3
 * @author brian
 *
 */
public class IntegerBreak {
	public static int integerBreak(int n) {
		int result=1;
		if(n==2){
			return 1;
		}
		if(n==3){
			return 2;
		}
		if(n==4){
			return 4;
		}
		if(n>4){
			while(n>=3&&n!=4){
				result=result*(3);
				n-=3;
				if(n==2||n==4){
					result=result*n;
					break;
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args){
		integerBreak(9);
	 }
}

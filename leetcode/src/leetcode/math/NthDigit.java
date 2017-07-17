package leetcode.math;
/**
 * 找出公式
 * 
 * 9*1(1-9)
 * 90*2(10-99)
 * 900*3(100-999)
 * 9000*4(1000-9999)
 * .........看n是在上述哪個區間,在做運算即可
 * 
 * 
 * ex: n =1000,  180<1000<2700...為3的區間
 * 1000-180-9 =811
 * 811/3=270...1
 * 1000前面有270組數字,然後餘1, so 100+270=370 取3即為答案
 * 
 * @author brian
 *
 */
public class NthDigit {
	public static int findNthDigit(int n) {
        int i=1;
        int j=10;
        int quot;
        int reminder;
        if(n<10){
        	return n;
        }
        while(i>0){
            n=(int) (n-9*Math.pow(10,i-1)*i);
            i++;
            if(n-9*Math.pow(10,i-1)*i<0){
                break;
            }
        }
        quot=n/i;
        reminder=n%i;
        if(reminder==0){
        	quot--;
        	String [] quotString = String.valueOf(quot+(int)Math.pow(10,i-1)).split("");
        	return Integer.parseInt(quotString[quotString.length-1]);
        }
        String [] quotString = String.valueOf(quot+(int)Math.pow(10,i-1)).split("");
        return Integer.parseInt(quotString[reminder-1]);
    }
	public static void main(String[] args){
		findNthDigit(1001);
	}
}

package leetcode.math;
/**
 *  ex: n=5
 *  
 *  5-1=4......1次
 *  4-2=2.......2次
 *  2-3=-1......3次
 * @author brian
 *
 */
public class ArrangingCoins {
	public int arrangeCoins(int n) {
        int i=1;
        while(n-i>=0){
            n=n-i;
            i++;
        }
        return i-1;
    }
}

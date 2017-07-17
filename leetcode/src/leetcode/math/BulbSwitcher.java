package leetcode.math;
/**
 * 智商不足, 
 * 仔細觀察題目, ex: 第12盞燈
 * 1,12
 * 2,6
 * 3,4...皆為偶數對
 * -->可推所有的數除了平方數,都是偶數對(所以到最後都不會亮)
 * 找出小於n的平方數即答案
 * 
 * 
 * @author brian
 *
 */
public class BulbSwitcher {
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
    }
	
}

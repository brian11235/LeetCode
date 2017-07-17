package leetcode.hashMap;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author brian
 *非常直观的解法就是利用HashMap，循环nums1[]一遍，记录下nums1[]中出现的数字，再对nums2[]做循环，如果在HashMap中出现过，则记录到最后的结果中。
	此外也可以用先sort的方法，通过merge来保证结果unique。
 */
public class IntersectionArr {
	public static int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> nums1List = new ArrayList<Integer>();
		List<Integer> nums2List = new ArrayList<Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		int [] intersectionArr;
		int count=0;
		for(int i:nums1){
			nums1List.add(i);
		}
		for(int i:nums2){
			nums2List.add(i);
		}
		nums1List.retainAll(nums2List);
		for(int i :nums1List){
			if(!resultList.contains(i)){
				resultList.add(i);
			}
		}
		intersectionArr= new int[resultList.size()];
		for(int i:resultList){
			intersectionArr[count]=i;
			count++;
		}

		return intersectionArr;
    }
	public static void main(String[] args){
		int [] nums1={1};
		int [] nums2={1};
		intersection(nums1,nums2);
	}
}

package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class intersectionArr2 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer,Integer> nums1Map = new HashMap<Integer,Integer> ();
		List<Integer> resultList = new ArrayList<Integer>();
		int value=1;
		int []resultArr;
		int count=0;
		for(int i:nums1){
			if(nums1Map.containsKey(i)){
				value=nums1Map.get(i);
				nums1Map.put(i, ++value);
			}else{
				value=1;
				nums1Map.put(i, value);	
			}
		}
		for(int i:nums2){
			if(nums1Map.containsKey(i)&&nums1Map.get(i)!=0){
				value=nums1Map.get(i);
				nums1Map.put(i, --value);
				resultList.add(i);
			}
		}
		resultArr = new int[resultList.size()];
		for(int i : resultList){
			resultArr[count]=i;
			count++;
		}
		return resultArr;
        
    }
	public static void main(String[] args){
		int [] nums1={4,7,9,7,6,7};
		int [] nums2={5,0,0,6,1,6,2,2,4};
		intersect(nums1,nums2);
	}
}

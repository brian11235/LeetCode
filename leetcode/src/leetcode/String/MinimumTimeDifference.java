package leetcode.String;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *  思路1: 暴力法, 比較每一組的時間, 挑出最小時間差的(time limited)
 *  思路2: 一樣暴力法, 但發現只要找出兩個一樣的時間, 即最小差0, 先檢查有沒有兩者一樣的時間, 再暴力法
 * @author brian
 *
 */
public class MinimumTimeDifference {
	public static int findMinDifference(List<String> timePoints) {
		String [] singleTimePoints;
		List<Integer> minutesList = new ArrayList<Integer>();
		int minute;
		int min = 0;
		int original;
		for(int i =0 ; i < timePoints.size() ; i++){
			for(int j = i+1; j < timePoints.size() ; j++){
				if(timePoints.get(j).equals(timePoints.get(i))){
					return min;
				}	
			}
		}
		for(int i =0 ; i < timePoints.size() ; i++){
			singleTimePoints = timePoints.get(i).split(":");
			minute=Integer.valueOf(singleTimePoints[0])*60+Integer.valueOf(singleTimePoints[1]);
			minutesList.add(minute);
		}
		for(int i = 0 ; i < minutesList.size()-1 ; i++){
			original=Math.abs(minutesList.get(i+1)-minutesList.get(i));
			if(i==0){
				min = Math.min(original,1440-original);
			}else{
				min= Math.min(min, Math.min(original,1440-original));
			}
			for(int j = i+2 ; j<minutesList.size();j++){
				original=Math.abs(minutesList.get(j)-minutesList.get(i));
				min= Math.min(min, Math.min(original,1440-original));
			}
		}
		return min;     
    }
	public static void main(String[] args){
		List<String> minutesList = new ArrayList<String>();
		minutesList.add("00:00");
		minutesList.add("23:59:");
		minutesList.add("00:00");
		findMinDifference(minutesList);
	}
}

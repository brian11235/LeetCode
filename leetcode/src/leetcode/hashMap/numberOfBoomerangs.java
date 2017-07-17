package leetcode.hashMap;

import java.util.HashMap;
import java.util.Map;
/***
 * 一平台上有數個坐標，找出以一點為中心到另外兩點的距離相等的數組共有幾組，其中另外兩點的距離是多少無所謂，只需關心與中心點的距離即可，
 * 盲點在於從座標上來看若有一中心點到另外兩點的距離相等，這是為一組情形，但在資料的結果上為[center,pointA,pointB],[center,pointerB,pointerA]將其當作兩種結果，
 * 而本題要求的就是為後者的情況，所以對中心點之外的座標要做排列組合，不過因為我們關心的為”距離”而非哪一點，此外儲存距離也比儲存兩點之間的關係容易多，
 * 所以就用hashmap儲存中心點到其餘所有點的距離及該距離有多少個，
 * 再來只要針對距離的個數有多少個做排序組合後(道理與座標是相同)，全部總合起來就是我們要的答案。
 * @author brian
 *
 */
public class numberOfBoomerangs {	
	public static int numberOfBoomerangs(int[][] points) {
		Map<Integer,Integer> distanceCountMap = new HashMap<Integer,Integer>();
		int distance;
		int count;
		int result = 0;
		for(int i = 0 ; i<points.length ; i++){
			for(int j = 0 ; j<points.length ; j++){
				if(i==j){
					continue;
				}
				distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]); 
				if(distanceCountMap.containsKey(distance)){
					count = distanceCountMap.get(distance);
					distanceCountMap.put(distance, ++count);
				}else{
					count=1;
					distanceCountMap.put(distance, count);
				}
			}
			for(Integer dis:distanceCountMap.keySet()){
				if(distanceCountMap.get(dis)>1){
					result = result + (distanceCountMap.get(dis)*(distanceCountMap.get(dis)-1));
				}
			}
			distanceCountMap.clear();
		}
		
		
		return result;
        
    }
	public static void main(String[] args){
		int [][] points = {{0,0},{1,0},{2,0}};
		numberOfBoomerangs(points);
	}
}

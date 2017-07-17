package leetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 檢查長度,放進map
 * map 裡面需要有4個邊長,2個對角線
 * @author brian
 *
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		Map<Double,Integer> lengthMap = new HashMap<Double,Integer>();
		List<int []> lengthList = new ArrayList<int []>();
		double length;
		int count;
    	lengthList.add(p1);
    	lengthList.add(p2);
    	lengthList.add(p3);
    	lengthList.add(p4);
    	for(int i =0 ; i < lengthList.size()-1; i++){
    		for(int j = i+1; j < lengthList.size() ; j++ ){
    			length=Math.pow(lengthList.get(j)[0]-lengthList.get(i)[0], 2)+Math.pow(lengthList.get(j)[1]-lengthList.get(i)[1], 2);
    			if(lengthMap.containsKey(length)){
    				count=lengthMap.get(length);
    				lengthMap.put(length, ++count);
    			}else{
    				lengthMap.put(length, 1);
    			}
    		}
    	}
    	if(lengthMap.containsValue(4)&&lengthMap.containsValue(2)){
    		return true;
    	}
    	return false;
    }
    public static void main(String[] args){
    }
}

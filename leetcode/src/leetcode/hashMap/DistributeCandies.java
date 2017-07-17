package leetcode.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ex: 1,1,2,3 
 * 
 * 之後也可以修改成不需map
 * 1->2
 * 2->1
 * 3->1
 * 
 * 對array迭代, 只要是沒見過的candy, sister就拿一個,假設還沒迭代完就拿到要的糖果數目,return ex: 1,1,2,3
 * 每個糖果都拿一次之後, 假設sister糖果數目還不夠, 仍然return, 因為再拿還是拿舊的糖果, type不會增加 ex: 1,1,1,1,2
 * 
 * 可簡化成找出array的不同數字
 *
 * @author brian
 *
 */
public class DistributeCandies {
	public static int distributeCandies(int[] candies) {
		int count = 0;
		int sisCandy=0;
		Map<Integer , Integer> candyMap = new HashMap<Integer,Integer>();
		for(int i=0 ; i < candies.length ; i++){
			if(candyMap.containsKey(candies[i])){
				count = candyMap.get(candies[i]);
				candyMap.put(candies[i], ++count);
			}else{
				candyMap.put(candies[i], 1);
				sisCandy++;
			}
			if(sisCandy==candies.length/2){
				return sisCandy;
			}
		}
		return sisCandy; 
    }
	 public static void main(String[] args){
		 int [] candies = {1,1,2,3};
		 distributeCandies(candies);
	 }
}
//while(sisCandy!=candies.length/2){
//	for(Integer candy:candyMap.keySet()){
//		count = candyMap.get(candy);
//		if(count==0){
//			continue;
//		}
//		count--;
//		sisCandy++;
//		candyMap.put(candy,count);
//		if(!sisCandyTypeList.contains(candy)){
//			sisCandyTypeList.add(candy);
//		}
//		if(sisCandy==candies.length/2){
//			break;
//		}
//	}
//}
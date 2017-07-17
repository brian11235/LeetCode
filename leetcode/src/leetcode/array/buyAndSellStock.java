package leetcode.array;

public class buyAndSellStock {
	public static int maxProfit(int[] prices) {
		int maxPro=0;
		int total=0;
		if(prices==null || prices.length==0){
			return 0;
		}
		int min=prices[0];
		for(int i=1 ; i<prices.length;i++){
			if(prices[i]<min){
				min=prices[i];
			}else{
				if(maxPro<prices[i]-min){
					maxPro=prices[i]-min;
				}
			}
		}
		return maxPro;
        
    }
	public static void main(String[] args){
		//int[] prices={7, 6, 4, 3, 1};
		//int[] prices={7, 1, 5, 3, 6, 4};
		//int[] prices={2,1,2,0,1};
		int[] prices={1,2,4};
		maxProfit(prices);
	}
}

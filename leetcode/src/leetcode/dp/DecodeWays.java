package leetcode.dp;

import java.util.HashMap;
import java.util.Map;


/***
 * 上樓梯問題條件版(0需要額外判斷)
 * @author brian
 *
 */
public class DecodeWays {
    public static int numDecodings(String s) {
    	String [] sArr = s.split("");
    	Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
    	indexMap.put(0, 1);
    	if(s==null||s.isEmpty()==true||"0".equals(sArr[0])){
    		return 0;
    	}
    	if(sArr.length==1){
    		return 1;
    	}
    	for(int i = 1 ; i < sArr.length ; i ++){
    		if("0".equals(sArr[i])){
    			if(Integer.parseInt(sArr[i-1])>2||Integer.parseInt(sArr[i-1])==0){
    				return 0;
    			}else{
    				if(i==1){
    					indexMap.put(i,1);
    				}else{
    					indexMap.put(i,indexMap.get(i-2));
    				}
    			}
    		}else{
    			if(i==1){
        			if(Integer.parseInt(sArr[0])*10+Integer.parseInt(sArr[1])>26){
        				indexMap.put(1, 1);
        			}else{
        	    		indexMap.put(1, 2);
        	    	}
        		}else{
        			if(Integer.parseInt(sArr[i-1])*10+Integer.parseInt(sArr[i])>26||Integer.parseInt(sArr[i-1])==0){
            			indexMap.put(i, indexMap.get(i-1));
            		}else{
            			indexMap.put(i, indexMap.get(i-2)+indexMap.get(i-1));
            		}
        		}
    		}
    	}
		return indexMap.get(sArr.length-1); 
    }
    public static void main(String[] args){
    	numDecodings("101");
	}
}

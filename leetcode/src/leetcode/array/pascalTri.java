package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class pascalTri {
	public static List<List<Integer>> generate(int numRows) {
		List<Integer> li = null;
		List<List<Integer>> pascalList= new ArrayList<List<Integer>>();
		for(int i=1; i <=numRows;i++){
			li=new ArrayList<Integer>();
			for(int j=1; j<=i;j++){
				if(i==1){
					li.add(1);		
				}else{
					if(j==1){
						li.add(1);
					}else if(j==i){
						li.add(1);
					}else{
						li.add(pascalList.get(i-2).get(j-2)+pascalList.get(i-2).get(j-1));
					}
				}
			}
			pascalList.add(li);
		}
	
		return pascalList;
        
    }
	public static void main(String[] args){
		generate(5);
		
	}
}

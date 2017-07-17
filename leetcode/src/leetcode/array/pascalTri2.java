package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class pascalTri2 {
	public static List<Integer> getRow(int rowIndex){
		List<Integer> li = null;
		List<List<Integer>> pascalList= new ArrayList<List<Integer>>();
		for(int i=0; i <=rowIndex;i++){
			li=new ArrayList<Integer>();
			for(int j=0; j<=i;j++){
				if(i==0){
					li.add(1);		
				}else{
					if(j==0){
						li.add(1);
					}else if(j==i){
						li.add(1);
					}else{
						li.add(pascalList.get(i-1).get(j-1)+pascalList.get(i-1).get(j));
					}
				}
			}
			pascalList.add(li);
		}
		return pascalList.get(rowIndex);
	}
	public static void main(String[] args){
		getRow(4);
	}
}

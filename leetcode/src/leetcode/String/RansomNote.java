package leetcode.String;
/**
 *     "","a"-->注意此測資
 * 
 * 速度超慢....
 * 
 * 思路: 暴力法
 * 
 *  1.aac 
 *  2.baca ->做二次迭代, 將1代入到2做檢查, 只要找到1,2同樣的值, 1進一位,然後繼續從2的頭開始找, 反之, 找不到直接return false~ 
 * 
 * @author brian
 *
 */
public class RansomNote {
	 public boolean canConstruct(String ransomNote, String magazine) {
		 String [] ransomNodeArr = ransomNote.split("");
		 String [] magazineArr = magazine.split("");
		 int j=0;
		 if("".equals(ransomNote)){
			 return true;
		 }
		 for(int i = 0 ; i < ransomNodeArr.length ; i++){
			 while(j<magazineArr.length){
				 if(ransomNodeArr[i].equals(magazineArr[j])){
					 magazineArr[j]="";
					 j=0;
					 break;
				 }
				 j++;
				 if(j==magazineArr.length){
					 return false;
				 }
			 }
		 } 
		return true;  
	 }
}

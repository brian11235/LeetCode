package leetcode.array;

public class twoSum2 {
	public static int[] twoSum(int[] numbers, int target) {
		//binary search
		int []sumArr=new int[2];
		int buffer;
		int low=1;
		int high=numbers.length-1;
		int mid;
		for(int i=0; i<numbers.length;i++){
			buffer=target-numbers[i];
			while(low<=high){
				mid=(low+high)/2;
				if(numbers[mid]>buffer){
					high=mid-1;
				}else if(numbers[mid]<buffer){
					low=mid+1;
				}else{
					sumArr[0]=i+1;
					sumArr[1]=mid+1;
					return sumArr;
				}
			}
			low=i+2;
			high=numbers.length-1;
		}
		return sumArr;
    }
	public static void main(String[] args){
		int[] numbers={1,2,3,4,4,9,56,90};
		twoSum(numbers,8);
	}
}

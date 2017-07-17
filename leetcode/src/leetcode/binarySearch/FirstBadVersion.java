package leetcode.binarySearch;
/**
 * 二分法即可
 * 須注意mid這個運算會溢出, mid=(left+right)/2->不行
 * 改成 mid=left+(right-left)/2;
 * @author brian
 *
 */
public class FirstBadVersion {
	 public int firstBadVersion(int n) {
		return n;
//	        int left = 1;
//	        int right = n;
//	        int mid;
//	        while(left<=right){
//	            mid=left+(right-left)/2;
//	            if(isBadVersion(mid)==true){
//	                right=mid-1;
//	            }else{
//	                left=mid+1;
//	            }
//	        }
//	        return left;
	    }
}

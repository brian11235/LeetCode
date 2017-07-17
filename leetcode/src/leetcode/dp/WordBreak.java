package leetcode.dp;

import java.util.ArrayList;
import java.util.List;
/**
 * 		"bb"                                          
			["a","b","bbb","bbbb"]---> ok
			"aaaaaaa"
			["aaaa","aaa"]-->ok
			
			用一個DP紀錄每一個S[0-i](S[0-1],S[0-2])的狀態,去迭代每層
			ex: goalspecial
			(goal(s[0-4])狀態是True + special 在dict裡 )
			
			
 * @author brian
 *
 */
public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		Boolean[] dp = new Boolean[s.length()+1];
		dp[0]=true;
		for(int i = 1 ; i < s.length()+1 ; i++){
			for(int j = 0 ; j <=i ; j++){
				if(dp[j]&&wordDict.contains(s.substring(j, i))){
					dp[i]=true;
					break;
				}else{
					dp[i]=false;
				}
			}
		}
		return dp[s.length()];
    }
	public static void main(String[] args){
		List<String>wordDict = new ArrayList<String>();
		//wordDict.add("leet");
		//wordDict.add("code");
		wordDict.add("go");
		wordDict.add("goal");
		wordDict.add("goals");
		wordDict.add("special");
		wordBreak("goalspecial",wordDict);
	}
}

//for(int i =0 ; i<sArr.length ; i++){
//	sbr.append(sArr[i]);
//	if(wordDict.contains(sbr.toString())){
//		sbr= new StringBuffer();
//	}
//}

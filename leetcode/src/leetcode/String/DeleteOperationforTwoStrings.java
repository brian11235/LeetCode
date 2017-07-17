package leetcode.String;

public class DeleteOperationforTwoStrings {
	public static int minDistance(String word1, String word2) {
		return 0;
    }
	public static void main(String[] args){
		minDistance("dinitrop", "benzalp");
	}
}
//"dinitrophenylhydrazine", "benzalphenylhydrazone"
//for(int i =0 ; i<word1.length() ; i++){
//	singleWord1= word1.substring(i, i+1);
//	for(int j =0 ; j <word2.length() ; j++){
//		singleWord2=word2.substring(j, j+1);
//		if(singleWord1.equals(singleWord2)){
//			word1= word1.substring(0, i)+word1.substring(i+1, word1.length());
//			word2= word2.substring(0, j)+word2.substring(j+1, word2.length());
//		}
//	}


//String singleWord1;
//String singleWord2;
//int i=0;
//int j=0;
//if("".equals(word1)||"".equals(word2)){
//	return word1.length()+word2.length();
//}
//while(i<word1.length()){
//	singleWord1= word1.substring(i, i+1);
//	while(j<word2.length()){
//		singleWord2=word2.substring(j, j+1);
//		if(singleWord1.equals(singleWord2)){
//			word1= word1.substring(0, i)+word1.substring(i+1, word1.length());
//			word2= word2.substring(0, j)+word2.substring(j+1, word2.length());
//			break;
//		}else{
//			j++;
//		}
//		if(j==word2.length()){
//			i++;
//		}
//	}
//	j=0;
//	if("".equals(word1)||"".equals(word2)){
//		break;
//	}
//}
//return word1.length()+word2.length();
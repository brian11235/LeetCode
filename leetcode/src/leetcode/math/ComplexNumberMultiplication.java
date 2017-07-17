package leetcode.math;
/**
 * 拆開string, 運算重組即可
 * @author brian
 *
 */
public class ComplexNumberMultiplication {
	public static String complexNumberMultiply(String a, String b) {
		String [] aNumber;
		String [] bNumber;
		int resultInteger;
		int resultI;
		StringBuffer resultString = new StringBuffer();
		a = a.substring(0, a.length()-1);
		b = b.substring(0, b.length()-1);
		aNumber=a.split("\\+");
		bNumber=b.split("\\+");
		resultInteger=Integer.parseInt(aNumber[0])*Integer.parseInt(bNumber[0])+(-1)*(Integer.parseInt(aNumber[1])*Integer.parseInt(bNumber[1]));
		resultI=Integer.parseInt(aNumber[0])*Integer.parseInt(bNumber[1])+Integer.parseInt(aNumber[1])*Integer.parseInt(bNumber[0]);
		resultString.append(resultInteger);
		resultString.append("+");
		resultString.append(resultI);
		resultString.append("i");
		return resultString.toString();
    }
	public static void main(String[] args){
		complexNumberMultiply("1+1i","1+-1i");
	}
}

package leetcode.String;
/**
 * 字串檢查(簡單)
 * @author brian
 *
 */
public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
        int Acount=0;
        String sSingle;
        for(int i = 0 ; i < s.length() ; i++){
            sSingle = s.substring(i,i+1);
            if("A".equals(sSingle)){
                Acount++;
            }
            if("L".equals(sSingle)){
                if(i+3<=s.length()&&"LLL".equals(s.substring(i,i+3))){
                    return false;
                }
            }
            if(Acount==2){
                return false;
            }
        }
        return true;
    }
}

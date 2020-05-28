public class demo {
    public static void main(String[] args) {

    }
}
//class Solution1 {
//    public int lengthOfLastWord(String s) {
//        String[] ss = s.split(" ");
//        if (ss.length == 0){
//            return 0;
//        }
//        return ss[s.length()-1].length();
//
//    }
//}

class Solution1 {
    public boolean judgeSquareSum(int c) {
        for(long a=0;a * a < c;a++){
            double b = Math.sqrt(c - a * a);
            if(b == (int)b){
                return true;
            }
            return false;
        }
        return false;
    }
}
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

import static org.thymeleaf.util.StringUtils.substring;

public class test {
    public static void main(String[] args) {
        //Solution solution = new Solution();
        String A = "abcd";
        String B = "bacd";
        boolean result = new Solution().buddyStrings(A,B);
        System.out.println(result);

    }
}

class Solution {
    public boolean buddyStrings(String A, String B) {
        if ((A.equals("") && B.equals("")) || (A.length()==1 && B.length() == 1) || A.length() != B.length()) {
            return false;
        }


        if(A.equals(B)){//当字符串相等时，看字符串中是否有相同字母。
            for(int i=0;i<A.length();i++){
                for(int j=0;j<i;j++){
                    if(A.charAt(j)==A.charAt(i))
                        return true;
                }
            }

            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (a[0] == b[1] && a[1] == b[0]){
            return true;
        }
        for (int i=0; i<a.length;i++) {
            if (a[i] != b[i]) {
                for (int j = i + 1; j < b.length; j++) {
                    if (a[i] == b[j]) {
                        char temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        return Arrays.toString(a).equals(Arrays.toString(b));
                    }

                }
                return false;
            }

        }
        return false;
    }
}

/*
class Solution {
    public String sortString(String s) {
        char[] charArray = s.toCharArray();
        char[] result = new char[charArray.length];
        int[] dump = new int[26];
        int resultIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            dump[charArray[i]-'a']++;
        }
        boolean match;
        do {
            match = false;
            for (int i = 0; i < 26; i++) {
                int i1 = dump[i];
                if (i1 <= 0) {
                    continue;
                }
                result[resultIndex++] = (char) (i + 'a');
                dump[i]--;
                match = true;
            }
            for (int i = 25; i >= 0; i--) {
                int i1 = dump[i];
                if (i1 <= 0) {
                    continue;
                }
                result[resultIndex++] = (char) (i + 'a');
                dump[i]--;
                match = true;
            }
        }while (match);
        return new String(result);
    }
}

*/
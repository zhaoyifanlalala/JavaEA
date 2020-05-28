public class test1 {
    public static void main(String[] args) {

    }
}
class Solution2 {
    public String sortString(String s) {
//       char[] ss=s.toCharArray();
//       char[] result=new char[ss.length];
//       char[] word=new char[26];
//
//        return null;

        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++){
            a[s.charAt(i - 'a')]++;
        }
        StringBuffer r = new StringBuffer();
        while (true){
            boolean empty = true;
            for (int i = 0;i < 26; i++){
                if (a[i] != 0){
                    r.append('a'+i);
                    a[i]--;
                    if (a[i] > 0){
                        empty = false;
                    }
                }


            }
            if (empty){
                return r.toString();
            }

        }
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
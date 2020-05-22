## 重复的电子邮箱
```
select Email from Person group by Email having count(Email) > 1;
```
## 大的国家
```
select name, population, area from World where area > 3000000 or population > 25000000
```
## 上下升降字符串
```
class Solution {
    public String sortString(String s) {
        int[] a = new int[26];
        for(int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }
        
        StringBuilder r = new StringBuilder();
        while(true) {
            boolean empty = true;
            for (int i = 0; i < 26; i++) {
                if (a[i] != 0) {
                    r.append((char)('a' + i));
                    a[i]--;
                    if (a[i] > 0)
                        empty = false;
                }
            }
            if (empty) {
                return r.toString();
            }
            for (int i = 25; i >= 0; i--) {
                if (a[i] != 0) {
                    r.append((char)('a' + i));
                    a[i]--;
                    if (a[i] > 0)
                        empty = false;
                }
            }
            if (empty) {
                return r.toString();
            }
        }
    }
}
```
## 在既定时间做作业的学生人数
```
class Solution {
     public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int stu=0;
        int t=startTime.length;
        for(int i=0;i<t;i++){
            if(startTime[i]<=queryTime&&endTime[i]>=queryTime){
                stu++;
            }
        }
        return stu;
    }
}
```
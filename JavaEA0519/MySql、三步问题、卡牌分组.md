## Mysql 1、第二高薪水
```
select(select distinct Salary as SecondHighestSalary 
from Employee 
order by Salary desc
limit 1 offset 1)as SecondHighestSalary
```
## Mysql 2、所有超过或等于5名学生的课。
```
select class from courses group by class having count(distinct student) >= 5
```
## 三步问题、
```
class Solution {
    public int waysToStep(int n) {
        if(n==0){
            return 0;  
        }
        else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 3){
            return 4;
        }
        int a = 1, b = 2, c = 4;
        for (int i = 3; i < n; i++) {
            int tmp = ((a + b) % 1000000007 + c) % 1000000007;
            a = b % 1000000007;
            b = c % 1000000007;
            c = tmp % 1000000007;
        }
        return c;
    }
}
```
## 卡牌分组
```
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0)
                values.add(count[i]);

        search: for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v: values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/solution/qia-pai-fen-zu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
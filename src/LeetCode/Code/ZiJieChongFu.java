package LeetCode.Code;
/**
 * @Author: FBY
 * @Date: 2021/3/7 14:21
 * @Version 1.0
 */

import java.util.Scanner;

/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *
 * 输入例子1:
 * 2
 * helloo
 * wooooooow
 *
 * 输出例子1:
 * hello
 * woow
 */
public class ZiJieChongFu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sstr;
        while (n-- > 0){
            sstr = sc.next();
            char ss[] = sstr.toCharArray();
            int j = 0;
            for (int i=0;i<ss.length;i++) {
                ss[j++] = ss[i];
                if (j >= 3 && ss[j - 3] == ss[j - 2] && ss[j - 2] == ss[j - 1])
                    j--;
                if (j >= 4 && ss[j - 4] == ss[j - 3] && ss[j - 2] == ss[j - 1])
                    j--;
            }
            for(int k=0;k<j;k++)
                System.out.print(ss[k]);
            System.out.println();
        }
    }
}

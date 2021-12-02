package Test;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/3/31 20:14
 * @Version 1.0
 */
public class g {

    public static boolean[] camelMatch (String[] queries, String pattern) {
        boolean[] answer = new boolean[queries.length];
        for (int i=0;i<queries.length;i++){
            int a=0,b=0;
            boolean flag = true;
            
            for (;a<queries[i].length();a++){
                if (b<pattern.length() && queries[i].charAt(a) == pattern.charAt(b))
                    b++;
                else if (queries[i].charAt(a) < 'a') {
                    flag = false;
                    break;
                }
            }
            if (b != pattern.length())
                flag = false;
            answer[i] = flag;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        boolean[] answer;
        answer = camelMatch(queries,pattern);
        for (int i=0;i<answer.length;i++) {
            System.out.println(answer[i]);
        }
    }
}

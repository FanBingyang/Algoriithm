package Test;

/**
 * @Author: FBY
 * @Date: 2021/3/30 11:14
 * @Version 1.0
 */
import java.io.*;
import java.util.*;
public class f{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int res = getRes(len);
        System.out.println(res);
    }
    public static int getRes(int len){
        if(len<4) return len;
        int res = 3;
        int pre = 2;
        for(int i=4;i<=len;i++){
            int tmp = res;
            res = res+pre;
            res %= (int)Math.pow(2,29);
            pre = tmp;
        }
        return res;
    }
}


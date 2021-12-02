package Test;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/28 16:17
 * @Version 1.0
 */
public class test {
    public static void main(String[] args){
        Scanner sin = new Scanner(System.in);
        int n,w = 0;
        n = sin.nextInt();
        int[] arrary =new int[n];
        for(int i = 0; i < n ; i++){
            arrary[i] = sin.nextInt();
        }
        w = sin.nextInt();
        int[] left = new int[w];
        int[] right = new int[w];
        for(int i = 0; i < w ; i++){
            left[i] = sin.nextInt();
        }
        for(int i = 0; i < w ; i++){
            right[i] = sin.nextInt();
        }
        int[] result = solution(n,arrary,w,left,right);
        for(int i:result){
            System.out.println(i);
        }
    }

    public static int[] solution (int n, int[] arrary, int w, int[] left, int[] right ) {
        //在此写出正确答案
        int[] res = new int[w];
        for (int i = 0; i < w; i++) {
            int l = left[i]<right[i]?left[i] : right[i];
            int r = left[i]<right[i]?right[i] : left[i];
            int sum = 0;
            for (;l<=r;l++){
                sum += arrary[l-1];
            }
            res[i] = sum;
        }
        return res;
    }
}

package LeetCode.Code;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/21 17:57
 * @Version 1.0
 */
public class TeGong {
    public static int mod=99997867;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        if (N<3){
            System.out.println(-1);
            return;
        }
        int[] coordinate = new int[N];
        for (int i = 0; i < N; i++) {
            coordinate[i] = sc.nextInt();
        }
        long count = 0;
        int left=0,right=2;
        while (left < N-2){
            while (right<N && coordinate[right]-coordinate[left]<=D){
                right++;
            }
            if (right-left-1>=2){
                long num = right-left-1;
                count += num * (num-1) / 2;
            }
            left++;
        }

        System.out.println(count % mod);
    }
}

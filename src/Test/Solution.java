package Test;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/3/31 20:03
 * @Version 1.0
 */
public class Solution {
    public static int maxProfit (int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];
        int max = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i] < min)
                min = prices[i];
            if ((prices[i]-min) > max)
                max = prices[i]-min;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));

    }
}

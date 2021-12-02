package LeetCode.Code;

import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/4/21 20:54
 * @Version 1.0
 */
public class MaJiang {

    public static boolean huPai(int[] pai,int flag){
        int sum = 0;   // 统计当前牌的数量
        for (int i=0;i<9;i++){
            sum += pai[i];
        }
        // 如果当前拍的数量为0，那么证明所有牌已经配对完毕，可以胡牌
        if (sum==0)
            return true;
        if (flag == 0){
            for (int i = 0; i < 9; i++) {
                if (pai[i] >= 2){
                    // 如果当前这张牌的数量大于等于2，取出来2张当雀头
                    pai[i] -= 2;
                    // 判断取出之后的牌能否胡牌
                    boolean temp = huPai(pai,1);
                    // 将取出的牌放回去
                    pai[i] += 2;
                    if (temp)
                        return true;
                }
            }
        }else {
            for (int i = 0; i < 9; i++) {
                if (pai[i] >= 3){
                    // 如果当前这张牌的数量大于等于3，取出来3张当作刻子
                    pai[i] -= 3;
                    // 判断取出之后的牌能否胡牌
                    boolean temp = huPai(pai,1);
                    // 将取出的牌放回去
                    pai[i] += 3;
                    if (temp)
                        return true;
                }
            }
            for (int i = 0;i < 7;i++){
                if (pai[i]>0 && pai[i+1]>0 && pai[i+2]>0){
                    // 如果有三张连续的牌，取出当顺子
                    pai[i]--;
                    pai[i+1]--;
                    pai[i+2]--;
                    // 判断取出之后的牌能否胡牌
                    boolean temp = huPai(pai,1);
                    // 将取出的牌放回去
                    pai[i]++;
                    pai[i+1]++;
                    pai[i+2]++;
                    if (temp)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pai = new int[9];
        for (int i = 0; i < 13; i++) {
            int num = sc.nextInt();
            pai[num-1]++;
        }
//        int[] pai = new int[]{1,1,1,1,2,2,3,3,5,6,7,8,9};
//        int[] pai = new int[]{4,2,2,0,1,1,1,1,1};
        boolean flag = false;
        // 依次将1-9添加进已有牌，查看是否能胡牌
        for (int i = 1; i <= 9; i++) {
            // 如果当前该张牌的数量小于4张，那么可以再添加一张此牌
            if (pai[i-1] < 4){
                pai[i-1]++;
                if (huPai(pai,0)){
                    System.out.printf("%d ",i);
                    flag = true;
                }
                // 判断过后将新添加的牌移除
                pai[i-1]--;
            }
        }
        if (!flag)
            System.out.println(0);
    }
}

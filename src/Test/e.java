package Test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @Author: FBY
 * @Date: 2021/3/30 10:49
 * @Version 1.0
 */
public class e {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int k=0;k<n;k++)
            arr[k] = scanner.nextInt();

        for (int i=0;i<n;i++){
            int t = arr[i];
            int L=-1,R=-1;
            for (int j=0;j<n;j++){
                if (arr[j]<t){
                    if (j<i)
                        L=j;
                    else {
                        R=j;
                        break;
                    }
                }
            }

//            System.out.println(L+" "+R);
            bw.write(L+" "+R+"\n");
        }
        bw.flush();
    }
}

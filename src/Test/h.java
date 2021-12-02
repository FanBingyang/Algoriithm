package Test;

import java.util.*;

/**
 * @Author: FBY
 * @Date: 2021/3/31 20:35
 * @Version 1.0
 */
public class h {

    public static int maxValue (int[][] grid) {
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        return core(grid,0,0);
    }

    public static int core(int[][] grid,int i,int j){
        int n =grid.length,m=grid[0].length;
        if (i>=n || j>=m){
            return 0;
        }
        if (i==n-1 && j==m-1)
            return grid[i][j];
        int r = core(grid,i,j+1);
        int d = core(grid,i+1,j);
        return Math.max(r,d)+grid[i][j];
    }

    public static int[] sumUnion (int[] arrayA, int[] arrayB) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        if (arrayA.length==0 || arrayB.length==0)
            return new int[]{};
        for (int i=0;i<arrayA.length;i++){
            set.add(arrayA[i]);
        }
        for (int i=0;i< arrayB.length;i++){
            if (!set.add(arrayB[i])){
                list.add(arrayB[i]);
            }
        }

        return list.stream().mapToInt(i->i).toArray();

//        List<Integer> list = new ArrayList<>();
//        if (arrayA == null || arrayB == null || arrayA.length == 0 || arrayB.length == 0) {
//            return new int[]{};
//        }
//        for(int i=0;i<arrayA.length;i++) {
//            for(int j=0;j<arrayB.length;j++)
//                if(arrayA[i]==arrayB[j]) {
//                    list.add(arrayA[i]);
//                }
//        }
//        return list.stream().mapToInt(i->i).toArray();


//        List<Integer> list = new ArrayList<>();
//        if (arrayA == null || arrayB == null || arrayA.length == 0 || arrayB.length == 0) {
//            return new int[]{};
//        }
//        Arrays.sort(arrayA);
//        Arrays.sort(arrayB);
//        int i = 0, j = 0;
//        while ( i < arrayA.length && j < arrayB.length ) {
//            if (arrayA[i] == arrayB[j]) {
//                list.add(arrayA[i]);
//                i++;
//                j++;
//            }
//            else if (arrayA[i] < arrayB[j]) i++;
//            else j++;
//        }
//        return list.stream().mapToInt(e->e).toArray();
    }



    public static int test(int n,int formPos,int tpPos){
            int t,tot=0;
            if (n==0)
                return 0;
            for (t=1;t<=3;t++) {
                if (t != formPos && t != tpPos)
                    break;

            tot = 0;
            tot+=test(n-1,formPos,t);
            tot++;
            tot+=test(n-1,t,tpPos);
            }
            return tot;

    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
//        String str =sc. nextLine();
//        char[] arr =str.toCharArray();
//        listAll (Arrays.asList(arr),"");
//        System.out.println(test(5,1,3));

        int[][] grid = new int[][]{{1,2,3},{67,89,13},{15,7,8},{100,89,78}};
        System.out.println(maxValue(grid));
    }
}

package Test;

/**
 * @Author: FBY
 * @Date: 2021/4/8 13:32
 * @Version 1.0
 */
class Fu {
    static {
        System.out.print("1");
    }
    {
        System.out.print("2");
    }
    public Fu() {
        System.out.print("3");
    }
}
class Zi extends Fu{
    static {
        System.out.print("a");
    }
    {
        System.out.print("b");
    }
    public Zi() {
        System.out.print("c");
    }
}
public class FuAndZi {
    public static void main(String[] args){
        Fu ab = new Zi();
//        ab = new Zi();
    }
}


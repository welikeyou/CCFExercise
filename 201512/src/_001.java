import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:18:46
 * Introduction:数位之和
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        int total = 0;
        long each = num%10;
        num = num/10;
        total +=each;
        while(num!=0){
            each = num%10;
            num = num/10;
            total +=each;
        }
        System.out.print(total);
    }
}

import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:14:45
 * Introduction:数列分段
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int result = 1;
        int beforeNum = input.nextInt();
        while(--n>0){
            int curNum = input.nextInt();
            if(curNum!=beforeNum){
                result += 1;
                beforeNum = curNum;
            }
        }
        System.out.print(result);
    }
}

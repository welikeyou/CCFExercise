/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:13
 * Introduction:折点计数
 */
import java.util.Scanner;

public class _001 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] prices = new int[n];
        int count=0;
        for(int i=0; i<n; i++){
            prices[i]=input.nextInt();

        }
        int nowPrice=0;
        for(int i=1;i<prices.length-1; i++){
            nowPrice = prices[i];
            if((nowPrice>prices[i-1]&&nowPrice>prices[i+1])||(nowPrice<prices[i-1]&&nowPrice<prices[i+1])){
                count++;
            }
        }
        System.out.print(count);
    }
}


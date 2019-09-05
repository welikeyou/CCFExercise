import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/14
 * Time:14:21
 * Introduction: 最大波动
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int maxChange = 0;
        int[] price = new int[n];
        for(int i=0;i<n; i++){
            price[i]=input.nextInt();
        }
        for(int i=0; i<n-1; i++ ){
            int change = Math.abs( price[i+1]-price[i]);
            if(change>maxChange){
                maxChange=change;
            }
        }
        System.out.println(maxChange);
    }
}

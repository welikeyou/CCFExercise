import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/15
 * Time:14:28
 * Introduction:分蛋糕
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] cakes = new int[n];
        for(int i=0; i<n; i++){
            cakes[i] = input.nextInt();
        }

        int num = 0;
        for(int i=0; i<n-1; i++){
            int cur = cakes[i];
            if(cur>=k){
                num++;
                cur = cakes[i];
            }else{
                cur = cur + cakes[i];
                while(cur<k){
                    i++;
                    cur = cur + cakes[i];
                }
                num++;
            }
        }
        System.out.print(num);

    }
}

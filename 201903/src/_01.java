/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/9
 * Time:15:13
 * Introduction:
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class _01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        int n = input.nextInt();
        if( n<=0){
            System.out.print("0 0 0");
        }else{
            int[] intArr = new int[n];
            for(int i=0; i<n; i++){
                intArr[i] = input.nextInt();
            }
            int min,max;
            if(intArr[0]>=intArr[n-1]){
                min = intArr[n-1];
                max = intArr[0];
            }else{
                min = intArr[0];
                max = intArr[n-1];
            }
            double half;
            if(n%2==0){
                int sum = intArr[(n/2)-1]+intArr[n/2];
                if(sum%2==0){
                    half = sum/2;
                    System.out.print(max+" "+half+" "+min);
                }else{
                    half = (double)(intArr[(n/2)-1]+intArr[n/2])/2;
                    System.out.print(max+" "+df.format(half)+" "+min);
                }

            }else{
                System.out.print(max+" "+intArr[(n-1)/2]+" "+min);
            }
        }

    }
}

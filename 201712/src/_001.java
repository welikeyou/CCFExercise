import java.util.Map;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:15:05
 * Introduction: 最小差值
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i]=input.nextInt();
        }
        int min = 10000;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int diff = Math.abs(nums[i]-nums[j]);
                if(min>diff){
                    min=diff;
                }
            }
        }
        System.out.println(min);
    }
}

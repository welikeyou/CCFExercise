import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:17:00
 * Introduction:数字排序
 * 思路：用下标当值，并且创建一个数组，初始下标与值相同，与待排序数组同步变化
 */
public class _002 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] result = new int[1001];
        int[] con = new int[1001];
         while(n-->0){
            int num = input.nextInt();
            result[num] +=1;
        }
         for(int i=0; i<1001; i++){
             con[i] = i;
         }
         for(int i=0; i<1001; i++){
             for(int j=i; j<1001; j++){
                 if(result[j]>result[i]||(result[j]==result[i]&&con[j]<con[i])){
                     int temp = result[i];
                     result[i] = result[j];
                     result[j] = temp;
                     int x = con[i];
                     con[i] =con[j];
                     con[j] = x;
                 }
             }
         }
         for(int i=0; i< 1001; i++){
             if(result[i]==0) break;
             System.out.println(con[i]+" "+result[i]);
         }

    }
}

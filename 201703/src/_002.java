/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:24
 * Introduction:学生排队
 */
import java.util.Scanner;

public class _002 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr=new int[n+1];
        for(int i =0 ;i<n;i++){
            arr[i]=i+1;
        }

        for(int i = 0; i<m; i++){
            int p = input.nextInt();
            int q = input.nextInt();
            int index=0;
            for(int j =0;j<n;j++){
                if(arr[j]==p){
                    index=j;
                    break;
                }
            }
            if(q>0){
                for(int j=index+1;j<=index+q;j++)
                {
                    arr[j-1]=arr[j];
                }
            }
            else{
                for(int j=index-1;j>=index+q;j--){
                    arr[j+1]=arr[j];
                }

            }
            arr[index+q]=p;
        }

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}


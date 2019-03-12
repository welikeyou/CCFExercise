/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:04
 */
import java.util.Scanner;

//卖菜
public class _002 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] startH = new int[n];
        int[] endH = new int[n];
        int[] startW = new int[n];
        int[] endW = new int[n];
        for(int i=0;i<n;i++){
            startH[i]=input.nextInt();
            endH[i]=input.nextInt();
        }
        for(int i=0;i<n;i++){
            startW[i]=input.nextInt();
            endW[i]=input.nextInt();
        }
        int startTime=startH[0]<startW[0]?startH[0]:startW[0];
        int endTime=endH[n-1]>endW[n-1]?endH[n-1]:endW[n-1];
        int totalTime=0;
        int indexHS=0;
        int indexHE=0;
        int indexWS=0;
        int indexWE=0;
        int startNum=0;
        int endNum=0;
        for(int nowTime=startTime; nowTime<=endTime; nowTime++){
            while(indexHS<n &&startH[indexHS]==nowTime){
                indexHS++;
                startNum++;
            }
            while(indexWS<n&&startW[indexWS]==nowTime){
                indexWS++;
                startNum++;
            }
            while(indexHE<n&&endH[indexHE]==nowTime){
                indexHE++;
                endNum++;
            }
            while(indexWE<n&&endW[indexWE]==nowTime){
                indexWE++;
                endNum++;
            }
            if(startNum-endNum>1){
                totalTime++;
            }
        }
        System.out.print(totalTime);

    }
}

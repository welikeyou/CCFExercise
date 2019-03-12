/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:18
 * Introduction:小明上学
 */
import java.util.Scanner;

public class _001 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        short r = input.nextShort();
        short y = input.nextShort();
        short g = input.nextShort();
        short n = input.nextShort();
        int totalTime=0;
        short[][] roat=new short[n][2];
        for(int i=0; i<n; i++){
            int type=input.nextShort();
            int time=input.nextShort();
            if(type==0||type==1){//red or walk time
                totalTime+=time;
            }
            else if(type==2){//yellow
                totalTime=totalTime+r+time;
            }
        }
        System.out.print(totalTime);


    }
}


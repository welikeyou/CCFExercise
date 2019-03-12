/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:19
 * Introduction:小明放学
 */
import java.util.Scanner;

public class _002 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        short r = input.nextShort();
        short y = input.nextShort();
        short g = input.nextShort();
        int n = input.nextInt();
        int totalTime=0;
        for(int i=0; i<n; i++){
            int type = input.nextInt();
            int time= input.nextInt();
            int waitTime=0;
            int needTime=(totalTime-time)%(r+y+g);
            if(type==0){
                waitTime=time;
            }
            if(type==1){
                if(needTime<0){
                    waitTime=-needTime;
                }
                else if(needTime<g){
                    waitTime=0;
                }
                else if(needTime<g+y+r){
                    waitTime=r+y+g-needTime;
                }
            }
            else if(type==2){
                if(needTime<r){
                    waitTime=-needTime+r;
                }
                else if(needTime<r+g){
                    waitTime=0;
                }else {
                    waitTime=y+g-needTime;
                }
            }
            else if(type==3){
                if(needTime<0||needTime>=r+y){
                    waitTime=0;
                }else if(needTime<r+y) {
                    waitTime = r + y - needTime;
                }
            }
            totalTime+=waitTime;

        }
        System.out.print(totalTime);
    }
}


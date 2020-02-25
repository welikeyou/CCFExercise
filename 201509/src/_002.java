import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:14:58
 * Introduction:日期计算
 */
public class _002 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int y = input.nextInt();
        int d = input.nextInt();
        int incr = 0;
        if((y%4==0&&y%100!=0)||y%400==0){
            incr = 1;
        }
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
        int nowM = 0;
        while(d - month[nowM]>0){
            d = d -month[nowM];
            if(nowM==1){//针对二月
                d = d - incr;
            }
            nowM +=1;
        }
        System.out.println(nowM+1);
        System.out.println(d);

    }
}

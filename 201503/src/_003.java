import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:18:23
 * Introduction:
 */
public class _003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();//月份
        int b = input.nextInt();//第几个星期
        int c = input.nextInt();//星期几
        int y1 = input.nextInt();
        int y2 = input.nextInt();
        int[] mouth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int yearDay = 0;
        for(int i=1850; i<y1; i++){
            yearDay+=365;
            if((i%4==0&&i%100!=0)||i%400==0){
                yearDay += 1;
            }
        }
        for(int i = y1; i<=y2; i++){
            boolean isRun = false;
            if((i%4==0&&i%100!=0)||i%400==0){
                isRun = true;
                 mouth[1] +=1;
            }
            int monthDay = yearDay;
            yearDay +=365;
            int j=0;
            for(; j<a-1; j++){
                monthDay += mouth[j];
            }
            DecimalFormat df = new DecimalFormat("00");
            monthDay = (monthDay+1)%7;//计算是星期几,加1是为了规约到星期一
            int day = -monthDay+(b-1)*7+c;
            if(day<mouth[j]){
                System.out.println(i+"/"+df.format(j+1)+"/"+df.format(day));
            }
            if(isRun){
                mouth[1] -= 1;
                yearDay += 1;
            }
        }
    }
}

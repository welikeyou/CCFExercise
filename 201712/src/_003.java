import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:15:24
 * Introduction:Crontab
 */
public class _003 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N=input.nextInt();
        String start =input.next();
        String end = input.next();
        input.nextLine();
        for(int i=0; i<N; i++){
            String conmend = input.nextLine();
            String[] commendArr = conmend.split("\\s");//统一以分来表示
            if(start.substring(0,4)==end.substring(0,4)){//说明在一年
                //组合
                String maybeTime = commendArr[3]+commendArr[2]+commendArr[1]+commendArr[0];//全为标准状态且没有* - ，


            }
        }


    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:20:51
 * Introduction:工资计算
 */
public class _002 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        final int N=8;
        int after = input.nextInt();
        int before=0;
        List<JieDuan> jieDuans = new ArrayList<>();
        JieDuan jieDuan0 = new JieDuan(0,3500,0,0,0);
        jieDuans.add(jieDuan0);
        JieDuan jieDuan1 = new JieDuan(3500,5000,3500,3,0);
        jieDuans.add(jieDuan1);
        JieDuan jieDuan2 = new JieDuan(5000,8000,jieDuan1.afterTop,10,jieDuan1.shui);
        jieDuans.add(jieDuan2);
        JieDuan jieDuan3 = new JieDuan(8000,12500,jieDuan2.afterTop,20,jieDuan2.shui);
        jieDuans.add(jieDuan3);
        JieDuan jieDuan4 = new JieDuan(12500,38500,jieDuan3.afterTop,25,jieDuan3.shui);
        jieDuans.add(jieDuan4);
        JieDuan jieDuan5 = new JieDuan(38500,58500,jieDuan4.afterTop,30,jieDuan4.shui);
        jieDuans.add(jieDuan5);
        JieDuan jieDuan6 = new JieDuan(58500,83500,jieDuan5.afterTop,35,jieDuan5.shui);
        jieDuans.add(jieDuan6);
        JieDuan jieDuan7 = new JieDuan(83500,200000,jieDuan5.afterTop,45,jieDuan6.shui);
        jieDuans.add(jieDuan7);
        if(after<=3500){
            before=after;
        }
        else{
            for(int i=1;i<N;i++){
                if(after>jieDuans.get(i).afterLow&&after<=jieDuans.get(i).afterTop)
                {
                    before=(after+jieDuans.get(i-1).shui-jieDuans.get(i).low/100*jieDuans.get(i).rate)*100/(100-jieDuans.get(i).rate);
                    break;
                }
            }
        }
        System.out.println(before);
    }
}
class JieDuan{
    int shui,afterTop,afterLow,top,low;
    int rate;
    public JieDuan(int low,int top,int afterLow,int rate,int beforeShui){
        this.shui =(top-low)/100*rate+beforeShui;
        this.afterTop = top-this.shui;
        this.rate = rate;
        this.afterLow=afterLow;
        this.low=low;
        this.top=top;
    }
}

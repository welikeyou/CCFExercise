import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:7:45
 * Introduction:打酱油
 * 100分
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        int beforNum = money/10;
        int fiveNum = beforNum/5;
        int leaveNum = beforNum%5;
        int threeNum = leaveNum/3;
        leaveNum = leaveNum%3;
        int afterNum = fiveNum*7 + threeNum*4 +leaveNum;
        System.out.print(afterNum);
    }
}

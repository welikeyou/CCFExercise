import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:16:00
 * Introduction:
 */
public class _004 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] cityRoads = new int[n][n];
//        初始化
        while(m-->0){
            int i = input.nextInt();
            int j =input.nextInt();
            cityRoads[i-1][j-1] = 1;
        }
//        遍历


    }
}

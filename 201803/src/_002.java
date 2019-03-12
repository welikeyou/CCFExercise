/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:09
 * Introduction:碰撞的小球
 */
import java.util.Scanner;

public class _002 {

    public static void main(String[] args) {
        // write your code here
        System.out.println("请输入数据");
        Scanner input=new Scanner(System.in);
        String inputNK=input.nextLine();
        System.out.println("你输入的数据是"+inputNK);
        String[] inputNLT=inputNK.split("\\s");
        int n=Integer.parseInt(inputNLT[0]);
        int l=Integer.parseInt(inputNLT[1]);
        int t=Integer.parseInt(inputNLT[2]);
        String[] arrBallsStr=input.nextLine().split("\\s");
        int[][] arrBalls=new int[n][2];
        for(int i=0; i<arrBallsStr.length; i++)
        {
            arrBalls[i][0]=Integer.parseInt(arrBallsStr[i]);
            arrBalls[i][1]=1;
        }
        for(int j=0 ;j<t;j++)
        {
            ballsMovie(l,arrBalls);
        }
        printLocation(arrBalls);
    }
    private static void ballsMovie(int l, int[][] arrBalls){
        for(int i=0; i<arrBalls.length; i++){
            ballsCrash(arrBalls[i][0],i, arrBalls);
            isInBorder(arrBalls[i][0],i, arrBalls,l);
            arrBalls[i][0]+=arrBalls[i][1];
        }
    }
    private static void isInBorder( int nowPosition,int ballNum,int[][] arrBalls,int l){
        if(nowPosition==0||nowPosition==l) {
            arrBalls[ballNum][1]*= -1;
        }
    }
    private static void ballsCrash(int nowPosition, int ballNum, int[][] arrBalls){
        for(int i=0; i<arrBalls.length; i++){
            if( ballNum!=i &&nowPosition==arrBalls[i][0]){
                arrBalls[ballNum][1]*= -1;
                arrBalls[i][1]*= -1 ;
            }
        }
    }
    private static void printLocation(int[][] arrBalls){
        for(int i=0 ;i<arrBalls.length; i++){
            System.out.print(arrBalls[i][0]+" ");
        }
    }
}


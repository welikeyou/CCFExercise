import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:19:31
 * Introduction:画图
 */
public class _003 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();
        int Q = input.nextInt();
        char[][] board = new char[N][M];
        boolean[][] flagx = new boolean[N][M];
        boolean[][] flagy = new boolean[N][M];
        for(int i=0; i<N; i++){//初始化
            for(int j=0; j<M; j++){
                board[i][j] = '.';
                flagx[i][j] = false;
            }
        }
        input.nextLine();
        while(Q>0){
          int type = input.nextInt();
          if(type==0){//画直线
              int x1 = input.nextInt();
              int y1 = input.nextInt();
              int x2 = input.nextInt();
              int y2 = input.nextInt();

              if(x1==x2){//画竖线
                  y1 = Math.min(y1,y2);
                  y2 = Math.max(y1,y2);
                  for(int j=y1; j<=y2; j++){
                      if(!flagx[x1][j]){
                          board[x1][j] = '|';
                          flagy[x1][j] = true;
                      }else{
                          board[x1][j] = '+' ;
                          flagy[x1][j] = true;
                      }
                  }
              }else{//画横线
                  x1=Math.min(x1,x2);
                  x2 = Math.max(x1,x2);
                  for(int i = x1; i<=x2; i++){
                      if(!flagy[i][y1]){
                          board[i][y1] = '-';
                          flagx[i][y1] = true;
                      }
                      else{
                          board[i][y1] = '+';
                          flagx[i][y1] = true;
                      }
                  }
              }
              }else if(type==1){
                     int x = input.nextInt();
                     int y = input.nextInt();
                     String str=input.next();
                     char myChar = str.charAt(0);
                     for(int i=x; i<N; i++){//递增的位置
                         for(int j=y; j<N; j++){
                             if(flagx[i][j]||flagy[i][j]){
                                 break;
                             }else{
                                 board[i][j] = myChar;
                             }
                         }
                     }
                     for(int i=x; i>=0; i--){
                         for(int j=y; j>=0; j--){
                             if(flagx[i][j]||flagy[i][j]){
                                 break;
                             }else{
                                 board[i][j] =myChar;
                             }
                         }
                     }
                }
        }
    }
}

import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:18:55
 * Introduction:消除类游戏
 */
public class _002 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[][] grid = new int[N][M];
        boolean[][] flag = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = input.nextInt();
                flag[i][j]=false;
            }
        }
        for(int i=0; i<N; i++){//按行检查
            for(int j=0; j<M-2; j++){
                if(grid[i][j]==grid[i][j+1]&&grid[i][j+1]==grid[i][j+2]){
                    flag[i][j]=true;
                    flag[i][j+1] =true;
                    flag[i][j+2]=true;
                }
            }
        }
        for(int j=0;j<M; j++){//按列检查
            for(int i=0; i<N-2;i++){
                if(grid[i][j]==grid[i+1][j]&&grid[i+1][j]==grid[i+2][j]){
                    flag[i][j]=true;
                    flag[i+1][j]=true;
                    flag[i+2][j]=true;
                }
            }
        }
        for(int i=0; i<N; i++){//消除
            for(int j=0; j<M; j++){
                     if(flag[i][j]){
                         grid[i][j]=0;
                }
            }
        }
        for(int i=0; i<N; i++){//输出
            for(int j=0; j<M; j++){
               System.out.print(grid[i][j]+" ");
            }
            System.out.print("\n");
        }

    }
}

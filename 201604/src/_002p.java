import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:20:19
 * Introduction:俄罗斯方块改进版
 * 改进点：
 * 1、定义常量，使得更易被理解和更改
 * 2、在最底边添加全为1的一行数，统一
 * 3、提取方块的位置
 * 4、可以设置flag来跳出两级循环
 */
public class _002p {
    public static void main(String[] args){
        final int COL = 10;
        final int ROW = 15;
        final int N = 4;
        int row,col;
        Scanner input = new Scanner(System.in);
        int[][] box = new int[ROW+1][COL];
        int[][] block = new int[N][N];
        for(int i=0;i<ROW; i++){
            for(int j=0; j<COL; j++){
                box[i][j] = input.nextInt();
            }
        }
        for(int k=0;k<COL; k++){
            box[ROW][k] =1; //把底边全部填充为1，方便处理
        }
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                block[i][j] = input.nextInt();
            }
        }
        col = input.nextInt();
        //提取小方块坐标
        List<Coork> coorks = new ArrayList<>();
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                coorks.add(new Coork(i,j));
            }
        }
        row=1;
        col--;
        boolean checkFlag = false;
        for(;;){
            for(int i=0; i<N; i++){
                if(box[row+coorks.get(i).row][col+coorks.get(i).col]==1){
                    checkFlag = true;
                    break;
                }
            }
            if(checkFlag){
                break;
            }
            row++;
        }
        row--;
        //合并
        for(int i=0; i<N; i++){
            box[row+coorks.get(i).row][col+coorks.get(i).col]=1;
        }
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL;j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.print("\n");
        }

    }
}
class Coork{
    int row,col;
    public Coork(int row,int col){
        this.row=row;
        this.col=col;
    }
}
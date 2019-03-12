/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:14
 * Introduction:俄罗斯方块
 */
import java.util.Scanner;

public class _002 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] box = new int[15][10];
        int[][] block = new int[4][4];
        for(int i=0;i<15; i++){
            for(int j=0; j<10; j++){
                box[i][j] = input.nextInt();
            }
        }
        for(int i=0; i<4;i++){
            for(int j=0; j<4; j++){
                block[i][j] = input.nextInt();
            }
        }
        int index = input.nextInt();
        int left = -1;
        int botton = 4;
        for(int j=0; j<4; j++){
            for(int i=0; i<4; i++){
                if(block[i][j]==1){
                    left = j;
                    break;
                }
            }
            if(left!=-1){
                break;
            }
        }
        for(int i=3; i>=0; i--){
            for(int j=0; j<4; j++){
                if(block[i][j]==1){
                    botton = i;
                    break;
                }
            }
            if(botton!=4){
                break;
            }
        }
        int down = 0;
        for(int i=3; i<15;i++){
            int y=left;
            for(int j=index; j<index+4-left; j++){
                if(box[i][j]+block[botton][y]==2){
                    down = i-1;
                    break;
                }else if(i==14){
                    down = i;
                }

                y++;
            }
            if(down!=0){
                break;
            }
        }

        int x=botton;
        for(int i=down; i>down-botton; i--){//i对应行
            int y=left;
            for(int j=index; j<index+4-left;j++){
                box[i][j]=box[i][j]+block[x][y];
                y++;
            }
            x--;

        }

        for(int i=0; i<15; i++){
            for(int j=0; j<10;j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.print("\n");
        }

    }
}


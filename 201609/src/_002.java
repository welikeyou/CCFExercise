import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/14
 * Time:14:33
 * Introduction:火车购票
 */
public class _002 {
    public static void main(String[] args){
        final int ROW = 20;
        final int COL = 5;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] commend = new int[n];
        for(int i=0;i<n;i++){
            commend[i] = input.nextInt();
        }
        int[][] seats = new int[ROW][COL];
        for(int i=0;i<ROW;i++){
            for(int j=0; j<COL;j++){
                seats[i][j]=0;
            }
        }
        for(int c=0;c<n;c++){
            int needSeat = commend[c];
            boolean conFlag = false;
            for(int i=0;i<ROW;i++){
                int conSeat = 0;//同一排中连续的座位
                for(int j=0; j<COL;j++){
                    if(seats[i][j]==0){
                        conSeat+=1;
                    }
                    else{
                        conSeat=0;
                    }
                    if(conSeat==needSeat){
                        for(int k=j-conSeat+1;k<=j;k++){
                            seats[i][k]=1;
                            int num=5*i+k+1;
                            System.out.print(num+" ");
                        }
                        System.out.print("\n");
                        conFlag = true;

                    }

                }
                if(conFlag){
                    break;
                }
            }
            if(!conFlag){//从小到大分
                for(int i=0; i<ROW;i++){
                    for(int j=0;j<COL;j++){
                        if(seats[i][j]==0){
                            seats[i][j]=1;
                            int num=5*i+j+1;
                            System.out.print(num+" ");
                            needSeat--;
                        }
                        if(needSeat==0){
                            break;
                        }
                    }
                    if(needSeat==0){
                        System.out.print("\n");
                        break;
                    }
                }

            }
        }

    }
}

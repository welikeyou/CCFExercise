import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:16:43
 * Introduction:
 */
public class _001 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        short[][] Squa = new short[n][m];
        for(int i =0 ; i<n; i++){
            for(int j=0; j<m; j++){
                Squa[i][j] = input.nextShort();
            }
        }
        for(int j = m-1; j>=0; j--){
            for(int i=0; i<n; i++){
                System.out.print(Squa[i][j]+" ");
            }
            System.out.println();
        }
    }
}

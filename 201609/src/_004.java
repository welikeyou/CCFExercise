import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/15
 * Time:7:59
 * Introduction:交通规划
 */
public class _004 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int N = n+1;
        final int MAXCOST = 1001;
        int[][] graph = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                graph[i][j] = MAXCOST;
            }
        }
        graph[1][1] = 0;
        for(int k=0; k<m; k++){
            int i=input.nextInt();
            int j=input.nextInt();
            int dist = input.nextInt();
            graph[i][j] = dist;
            graph[j][i] = dist;
        }
        int[] dist = new int[N];//1到j的长度
        int[] cost = new int[N];
        boolean[] Final=new boolean[N];//Final[w]=1表示已求得v1到vw的最短路径
        //初始化
        for(int i=1; i<N; i++){
            Final[i]=false;
            dist[i] = graph[1][i];
            cost[i] = graph[1][i];
        }
        Final[1]=true;
        int num=2;
        while(num<N){
            int k=0;
            int min=MAXCOST;
            for(int i=2;i<N; i++){
                if(Final[i]){
                    continue;
                }
                if(dist[i]<min){//寻找最短路径最小的点
                    min = dist[i];
                    k=i;
                }
            }
            Final[k] =true;
            num++;
            for(int i=1; i<N; i++){
                if(!Final[i]&&dist[i]>dist[k]+graph[k][i]){
                    cost[i]=graph[k][i];
                    dist[i] = dist[k]+graph[k][i];
                }else if(!Final[i]&&dist[i]==dist[k]+graph[k][i]){
                    cost[i] = Math.min(cost[i],graph[k][i]);
                    dist[i] = dist[k]+graph[k][i];
                }
            }
        }
         int total = 0;
        for(int i=1;i<N; i++){
            total += cost[i];
        }
        System.out.print(total);
        

    }
}

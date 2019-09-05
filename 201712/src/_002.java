/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:29
 * Introduction:游戏
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _002 {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int k=input.nextInt();
        List<Kid> kidList=new ArrayList<>();
        for(int i=1; i<=n; i++){
            kidList.add(new Kid(i));
        }
        int temp=1;//用于获取当前的index
        int lastSize=kidList.size();
        int IncreasNum=1;
        int lastIncreasNum=1;
        while(kidList.size()>1){
            int index=(temp-1)%kidList.size();
            String kidNumStr=IncreasNum+"";
            if(IncreasNum % k == 0||kidNumStr.endsWith(k+"")){
                kidList.remove(index);
                temp--;
            }
            temp++;
            IncreasNum++;
            if(IncreasNum-lastIncreasNum==lastSize){
                temp=1;
                lastSize=kidList.size();
                lastIncreasNum=IncreasNum;
            }
        }
        System.out.println(kidList.get(0).kidNum);

    }
}
class Kid{
    int kidNum;
    public Kid(int kidNum){
        this.kidNum=kidNum;
    }
}


import java.util.*;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:7:52
 * Introduction:公共钥匙盒
 * 100分
 */
public class _002p {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        List<Borrow> borrowList = new ArrayList<>();
        int firstTime = 110000;
        int lastTime = 0;
        for(int i=0; i<K; i++){
            int keyNum = input.nextInt();
            int startTime = input.nextInt();
            int keepTime = input.nextInt();
            int endTime = startTime+keepTime;
            if(firstTime>startTime){
                firstTime = startTime;
            }
            if(lastTime<endTime){
                lastTime= endTime;
            }
            Borrow borrow = new Borrow(startTime, endTime, keyNum);
            borrowList.add(borrow);
        }
        int[] keyArr = new int[N];
        for(int i=0; i<N; i++){
            keyArr[i]=i+1;
        }

        for(int nowTime=firstTime; nowTime<=lastTime; nowTime++){
            returnKey(borrowList,nowTime,keyArr);
            borrowKey(borrowList,nowTime,keyArr);

        }
        printKey(keyArr);
    }
    public static void borrowKey(List<Borrow> borrowList, int nowTime,int[] keyArr){
        for(int i=0; i<borrowList.size(); i++){
            if(borrowList.get(i).startTime==nowTime){
                 for(int j=0; j<keyArr.length; j++){
                     if(keyArr[j]==borrowList.get(i).keyNum){
                         keyArr[j]=0;
                         break;
                     }
                 }
            }
        }
    }
    public static void returnKey(List<Borrow> borrowList, int nowTime, int[] keyArr){
        List<Borrow> returnKeys = new ArrayList<>();
        for(int i=0; i<borrowList.size(); i++){
            if(borrowList.get(i).endTime==nowTime){
                returnKeys.add(borrowList.get(i));
                borrowList.remove(borrowList.get(i));
                i--;
            }
        }
        Collections.sort(returnKeys);
        int j=0;
        for(int i=0; i<returnKeys.size(); i++){
            for(; j<keyArr.length; j++){
                if(keyArr[j]==0){
                    keyArr[j]=returnKeys.get(i).keyNum;
                    break;
                }
            }
        }
    }
    public static void printKey(int[] keyArr){
        for(int i=0; i<keyArr.length; i++){
            System.out.print(keyArr[i]+" ");
        }
        System.out.print("\n");
    }

}
class Borrow implements Comparable<Borrow>{
    int startTime;
    int endTime;
    int keyNum;
    public Borrow(int startTime,int endTime,int keyNum){
        this.startTime = startTime;
        this.keyNum = keyNum;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Borrow otherBorrow) {
        int num = this.keyNum - otherBorrow.keyNum;
        return num;
    }
}

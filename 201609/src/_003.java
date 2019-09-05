import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/14
 * Time:15:56
 * Introduction: 炉石传说
 */
public class _003 {
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       int n = Integer.parseInt(input.nextLine());
       List<Role> playA = new ArrayList<>();
       Role heroA = new Role(0,30);
       playA.add(0,heroA);
       List<Role> playB = new ArrayList<>();
       Role heroB = new Role(0,30);
       playB.add(0,heroB);
       List<List<Role>> gamePlay = new ArrayList<>();
       gamePlay.add(playA);
       gamePlay.add(playB);
       int nowNum = 0;
       boolean hasBreak = false;
       int winNum = 0;
       for(int i=0; i<n; i++){
           String actionStr = input.nextLine();
           String[] actionArr = actionStr.split("\\s");
           String acctionName = actionArr[0];
           if(acctionName.equals("summon")){
               int positon = Integer.parseInt(actionArr[1]);
               int attack = Integer.parseInt(actionArr[2]);
               int health = Integer.parseInt(actionArr[3]);
               Role follower = new Role(attack,health);
               gamePlay.get(nowNum).add(positon,follower);
           }else if(acctionName.equals("attack")){
               int attacker = Integer.parseInt(actionArr[1]);
               int defender = Integer.parseInt(actionArr[2]);
               int otherNum =(nowNum+1)%2;
               Role ourRole =gamePlay.get(nowNum).get(attacker);
               Role otherRole = gamePlay.get(otherNum).get(defender);
              ourRole.liveNum -=otherRole.attackNum;
              otherRole.liveNum -=ourRole.attackNum;
               if(ourRole.liveNum<=0){
                   gamePlay.get(nowNum).remove(ourRole);
               }
               if(defender==0){//说明攻击的是英雄，要判断游戏是否结束
                   if(otherRole.liveNum<=0){
                       hasBreak = true;
                       winNum = nowNum;
                       break;
                   }
               }
              if(otherRole.liveNum<=0){
                  gamePlay.get(otherNum).remove(otherRole);
              }
           }else if(acctionName.equals("end")){
               nowNum =(nowNum+1)%2;
           }

       }
       if(hasBreak){
           if(winNum==0){
               System.out.println(1);
           }
           else if(winNum==1){
               System.out.println(-1);
           }
       }else{
           System.out.println(0);
       }
       int firstLiveNum =gamePlay.get(0).get(0).liveNum;
       int afterLiveNum = gamePlay.get(1).get(0).liveNum;
       System.out.println(firstLiveNum);
       int firstAllNum = gamePlay.get(0).size();
       if(firstAllNum>8){
           firstAllNum=8;
       }
       System.out.print((firstAllNum-1)+" ");
       for(int i=1;i<firstAllNum; i++){
           System.out.print(gamePlay.get(0).get(i).liveNum+" ");
       }
       System.out.print("\n");
       System.out.println(afterLiveNum);
       int afterAllNum = gamePlay.get(1).size();
       if(afterAllNum>8){
           afterAllNum=8;
       }
       System.out.print((afterAllNum-1)+" ");
       for(int i=1;i<afterAllNum; i++){
           System.out.print(gamePlay.get(1).get(i).liveNum+" ");
       }
       System.out.print("\n");
   }

}
class Role{
    int attackNum=0 ;
    int liveNum=0;
    public Role(int attackNum,int liveNum){
        this.attackNum=attackNum;
        this.liveNum=liveNum;
    }
}

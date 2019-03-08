import java.util.*;

public class CommonKey {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        String inputNK=input.nextLine();
        String[] inputNKStr=inputNK.split("\\s");
        int n=Integer.parseInt(inputNKStr[0]);
        int k=Integer.parseInt(inputNKStr[1]);
        String[] inputTeacherList=new String[k];
        int[][] teacherList=new int[k][3];
        int[] arrKeys=new int[n];
        for(int i=0;i<k;i++){
            arrKeys[i]=i;
        }
        int lastTime=0;
        for(int i=0; i<k; i++){
            inputTeacherList[i]=input.nextLine();
           String[] teacherListStr=inputTeacherList[i].split("\\s");
           for(int j=0;j<3;j++) {
               teacherList[i][j] = Integer.parseInt(teacherListStr[j]);
           }
           if(teacherList[i][1]+teacherList[i][2]>lastTime){
               lastTime = teacherList[i][1]+teacherList[i][2];
           }
        }
        int nowTime=1;
        while(nowTime<lastTime){
            checkReturnList(nowTime,teacherList,arrKeys);
            checkLendList(nowTime,teacherList,arrKeys);
        }
        printKeys(arrKeys);
    }

    private static void checkReturnList(int nowTime,int[][] teacherList, int[] arrKeys){
        List<Teacher> teacherLists=new ArrayList<>();
        for(int i=0;i<teacherList.length; i++){
         while(teacherList[i][1]+teacherList[i][2]==nowTime){
        Teacher tempTeacher=new Teacher(teacherList[i][0], teacherList[i][1],teacherList[i][2]);
        teacherLists.add(tempTeacher);
         }
         Collections.sort(teacherLists);
         returnKey(teacherLists,arrKeys);
}
    }

    private static void checkLendList(int nowTime,int[][] teacherList,int[] arrKeys){
        for(int i=0;i<teacherList.length; i++){
            while(teacherList[i][1]==nowTime){
                arrKeys[i]=0;
            }
        }
    }
    private static void returnKey(List<Teacher> teacherLists,int[] arrKeys){
        int j=0;
        for(int i=0;i<teacherLists.size();i++){
            for(;j<arrKeys.length;j++){
                while(arrKeys[j]==0){
                    arrKeys[j]=teacherLists.get(i).keyNum;
                    break;
                }
            }
        }
    }
    private static void printKeys(int[] arrKeys)
    {
        for(int i=0; i<arrKeys.length; i++){
            System.out.println(arrKeys[i]+" ");
        }
    }
            }
class Teacher implements Comparable<Teacher>{
    int keyNum;
    int startTime;
    int needTime;
    int returnTime;
    Teacher(int keyNum,int startTime, int needTime){
        this.startTime=startTime;
        this.needTime=needTime;
        this.returnTime=startTime+needTime;
        this.keyNum=keyNum;
    }
    @Override
    public int compareTo(Teacher otherTeacher){
         int value=this.keyNum-otherTeacher.keyNum;
         return value;
    }
}
//元素选择器
/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:04
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _003 {

    public static void main(String[] args){
        List<node> nodeList=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();//文档行数
        int m = input.nextInt();//选择器个数
        int lastSpace=0;
        int level = 0;
        input.nextLine();
        for(int i=0; i<n;i++){
            String sign = input.nextLine();
            String name;
            String id;
            int nowSpace = 0;
            int indexDot=sign.lastIndexOf(".");
            int indexId=sign.indexOf("#");
            if(indexDot >0){
                nowSpace = indexDot;
            }
            if(nowSpace>lastSpace){
                level=level+1;
                lastSpace=nowSpace;
            }
            if(nowSpace<lastSpace){
                level=level-1;
                lastSpace=nowSpace;
            }
            if(indexId>0){
                id = sign.substring(indexId+1);
                name=tolwr(sign.substring(indexDot+1,indexId-1));
            }else{
                id="";
                name=tolwr(sign.substring(indexDot+1));
            }
            node aNode=new node(name,id,level,i+1);
            nodeList.add(aNode);
        }
        for(int i=0; i<m; i++){
            String scan = input.nextLine();
            List<node> matchNode = new ArrayList<>();
            int indexId = scan.lastIndexOf("#");
            if(indexId==0){
                String id = scan.substring(indexId+1);
//                     List<Integer> lineStr = new ArrayList<>();
                for(int j=0; j<n; j++){
//                         System.out.print(nodeList.get(j).id);
                    while(nodeList.get(j).id.equals(id)){
                        matchNode.add(nodeList.get(j));
                        break;
                    }

                }
            }
            else if(indexId>0){//说明不止一个标签
                String[] idList = scan.split("\\s");
                for(int j=0; j<idList.length; j++){
                    idList[j] = idList[j].substring(1);
                }
                int myLevel=0;
                for(int x=0; x<n;x++){
                    while(nodeList.get(x).id.equals(idList[idList.length-1])){
                        myLevel=nodeList.get(x).level;//寻找到符合要求的子标签
                        int j=idList.length-2;
                        for(; j>=0; j--){
                            if(!searchId(nodeList,x,myLevel,idList[j])) break;
                        }
                        if(j<0){
                            matchNode.add(nodeList.get(x));
                        }
                        break;
                    }
                }

            }
            else{
                String[] biaoQian = scan.split("\\s");
                for(int y=0; y<biaoQian.length; y++){
                    biaoQian[y]=tolwr(biaoQian[y]);
                }
                int myLevel=0;
                for(int x=0; x<n;x++){
                    while(nodeList.get(x).name.equals(biaoQian[biaoQian.length-1])){
                        myLevel=nodeList.get(x).level;//寻找到符合要求的子标签
                        int j=biaoQian.length-2;
                        for(; j>=0; j--){
                            if(!search(nodeList,x,myLevel,biaoQian[j])) break;
                            myLevel--;
                        }
                        if(j<0){
                            matchNode.add(nodeList.get(x));
                        }
                        break;
                    }
                }

            }
            System.out.print(matchNode.size()+" ");
            for(int x=0; x<matchNode.size(); x++)
            {
                System.out.print(matchNode.get(x).line+" ");
            }
            System.out.print("\n");
        }


    }
    public static String tolwr(String s){
        return s.toLowerCase();
    }
    public static boolean search(List<node> a,int startIndex, int myLevel, String s) {
        int matchedLevel = -2;
        for (int i = 0; i < startIndex; i++) {
            if (a.get(i).level == myLevel - 1 && a.get(i).name.equals(s)) {
                matchedLevel = myLevel - 1;
                for (int j = i+1; j < startIndex; j++) {
                    if (a.get(j).level > matchedLevel) {
                        continue;
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    public static boolean searchId(List<node> a, int startIndex, int myLevel, String s){
        int matchedLevel=-2;
        for(int i=0; i<startIndex;i++){
            if(a.get(i).level==myLevel-1 && a.get(i).id.equals(s)){
                matchedLevel=myLevel-1;
                for(int j=i+1; j<startIndex; j++){
                    if(a.get(j).level>matchedLevel){
                        continue;
                    }
                    else{
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
class node{
    String name,id;
    int level,line;
    public node(String name,String id,int level,int line){
        this.name=name;
        this.id=id;
        this.level=level;
        this.line=line;
    }
}

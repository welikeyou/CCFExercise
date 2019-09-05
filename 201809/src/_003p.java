import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/14
 * Time:20:35
 * Introduction:元素选择器改进版
 */
public class _003p {
    static int nowBlack = 0;
    static int nowIndex = 0;
    public static void main(String[] args){
        List<nodep> nodeList=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();//文档行数
        int m = input.nextInt();//选择器个数
        input.nextLine();
        for(int i=0; i<n;i++){
            String sign = input.nextLine();
            String name;
            String id;
            int indexDot=sign.lastIndexOf(".");
            int indexId=sign.indexOf("#");
            int black = indexDot+1;
            if(indexId>0){
                id = sign.substring(indexId+1);
                name=tolwr(sign.substring(indexDot+1,indexId-1));
            }else{
                id="";
                name=tolwr(sign.substring(indexDot+1));
            }
            nodep aNode=new nodep(name,id,black,i+1);
            nodeList.add(aNode);
        }
        for(int i=0; i<m; i++){
            String scan = input.nextLine();
            List<nodep> matchNode = new ArrayList<>();
            int indexId = scan.lastIndexOf("#");
            if(indexId==0){
                String id = scan.substring(indexId+1);
                for(int j=0; j<n; j++){
                    while(nodeList.get(j).id.equals(id)){
                        matchNode.add(nodeList.get(j));
                        break;
                    }
                }
            }
            else if(indexId>0){//说明是多级的ID查询
                String[] idList = scan.split("\\s");
                for(int j=0; j<idList.length; j++){
                    idList[j] = idList[j].substring(1);
                }
                for(int x=0; x<n;x++){
                    while(nodeList.get(x).id.equals(idList[idList.length-1])){
                        int j=idList.length-2;
                        nowBlack = nodeList.get(x).black;
                        nowIndex = x;
                        for(; j>=0; j--){
                            if(!searchId(nodeList,idList[j])) break;
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
                    System.out.print(biaoQian[y]);
                }
                for(int x=0; x<n;x++){
                    while(nodeList.get(x).name.equals(biaoQian[biaoQian.length-1])){
                        if(biaoQian.length==1){
                            matchNode.add(nodeList.get(x));
                            break;
                        }else{
                            int j=biaoQian.length-2;
                            nowBlack = nodeList.get(x).black;
                            nowIndex = x;
                            for(; j>=0; j--){
                                if(!search(nodeList,biaoQian[j])) break;
                            }
                            if(j<0){
                                matchNode.add(nodeList.get(x));
                            }
                            break;
                        }
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
    public static boolean search(List<nodep> a, String s) {
        for (int i = nowIndex-1; i >=0; i--) {
            if (a.get(i).black < nowBlack){
                nowBlack = a.get(i).black;
                if (a.get(i).name.equals(s)) {
                    nowIndex = i;
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean searchId(List<nodep> a, String s){
        for(int i=nowIndex-1; i>=0;i--){
            if (a.get(i).black < nowBlack){
                nowBlack = a.get(i).black;
                if (a.get(i).id.equals(s)) {
                    nowIndex = i;
                    return true;
                }
            }
        }
        return false;
    }
}
class nodep {
    String name;
    String id;
    int black;
    int line;
    public nodep(String name, String id, int black, int line){
        this.name=name;
        this.id=id;
        this.black=black;
        this.line=line;
    }
}

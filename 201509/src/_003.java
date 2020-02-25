import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:15:21
 * Introduction:
 */
public class _003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String,String> varmap = new HashMap();
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        StringBuilder str = new StringBuilder();
        while(n-->0){
            str.append(input.nextLine()).append("\n");
        }
        while(m-->0){
            String var = input.next();
            String value = input.nextLine();
            varmap.put(var,value.substring(2,value.length()-1));
        }
        while(str.indexOf("{{")!=-1){
            int start = str.indexOf("{{");
            int end = str.indexOf("}}");
            String var = str.substring(start+3,end-1);
            String value ="";
            if(varmap.containsKey(var)){
                value = varmap.get(var);
            }
            str.replace(start,end+2,value);
        }
        System.out.println(str);
    }
}

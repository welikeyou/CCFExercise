import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:13:02
 * Introduction:JSON查询
 */
public class _003p {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int m= input.nextInt();
        String jsonStr = "";
        Map<String,String> keyValue = new HashMap<>();
        while(n-->=0){
            String lineStr = input.nextLine();
            lineStr.replace(" ","");//去除所有空格
            jsonStr+=lineStr;
        }
        String str="";//保存临时的健
        String ss="";//保存临时对象的健
        boolean flag = true;//区分是健还是值，默认是健
        boolean type = true;//区分是字符串还是对象，默认是字符串
        for(int i=1;i<jsonStr.length()-1;i++){
            switch (jsonStr.charAt(i)){
                case '"':
                    String temp="";//保存临时的值
                    for(i=i+1; i<jsonStr.length(); i++){
                        if(jsonStr.charAt(i)=='\\'){
                           temp+=jsonStr.charAt(++i);
                        }else if(jsonStr.charAt(i)=='"'){
                            break;
                        }else{
                            temp+=jsonStr.charAt(i);
                        }
                    }
                    if(type){//字符串
                        if(flag){//健
                            str = temp;
                            ss = ss+"."+temp;
                            keyValue.put(str,null);
                        }else{
                            keyValue.put(str,temp);
                        }
                    }else{
                        if(flag){
                            ss=ss+"."+temp;
                            if(ss.indexOf(".")==0){
                                ss=ss.substring(1);//去掉s前面的.
                            }
                            keyValue.put(ss,null);
                        }else{
                            keyValue.put(ss,temp);
                        }
                    }
                    break;
                case ':':
                        flag=false;//表示下一个为值
                        break;
                case ',':
                    flag=true;
                    break;
                case '{':
                    type=false;//对象的开始
                    flag=true;
                    break;
                case'}':
                    type=true;
                    flag=true;
                    break;
            }
        }
        for(int i=0; i<m; i++){
           String queryStr = input.nextLine();
           if(keyValue.containsKey(queryStr)){
               String rs = keyValue.get(queryStr);
               if(rs==null){
                   System.out.println("OBJECT");
               }else{
                   System.out.println("STRING "+rs);
               }
           }else{
               System.out.println("NOTEXIST");
           }
        }


    }
}

import java.util.*;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/16
 * Time:9:05
 * Introduction:JSON查询
 * 递归法，思路障碍
 */
public class _003 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        int m= input.nextInt();
        String jsonStr="";
        while(n-->0){
            jsonStr += input.nextLine();
        }
        List<KeyValue> keyValue = parsonJson(jsonStr);
        String[] queryStr = new String[m];
        for(int i=0; i<m; i++){
            queryStr[i] = input.nextLine();
        }


    }
    public static List<KeyValue> parsonJson(String jsonStr){
        int startIndex = jsonStr.indexOf("{");
        int endIndex = jsonStr.lastIndexOf("}");
        String keyValueStr = jsonStr.substring(startIndex+1,endIndex);
        String[] keyValueArr = keyValueStr.split(",");
        List<KeyValue> keyValueList = new ArrayList<>();
        for(int i=0; i<keyValueArr.length; i++){
            String[] keyValue =  keyValueArr[i].split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            boolean isObject = value.contains("{");
            KeyValue keyValueObj = new KeyValue(key,value,isObject);
            keyValueList.add(keyValueObj);
        }
        return keyValueList;
    }
}
class KeyValue{
    List<Map<String, KeyValue>> mapKeyValue = new ArrayList<>();
    String valueStr;
    public KeyValue(String key, String valueStr,boolean isObject) {
        this.valueStr = valueStr;
        while (isObject) {
            List<KeyValue> childKeyValue = parseValue(valueStr);
//                mapKeyValue.put(key, childKeyValue);
        }

    }
    public  List<KeyValue> parseValues(List<KeyValue> keyValueList) {
        List<KeyValue> keyValueList1 =new ArrayList<>();
        for (int i = 0; i < keyValueList.size(); i++) {
            String jsonStr = keyValueList.get(i).valueStr;
            keyValueList1 =  parseValue(jsonStr);
        }
        return keyValueList1;
    }
    public List<KeyValue> parseValue(String jsonStr){
        int startIndex = jsonStr.indexOf("{");
        int endIndex = jsonStr.lastIndexOf("}");
        String keyValueStr = jsonStr.substring(startIndex+1,endIndex);
        String[] keyValueArr = keyValueStr.split(",");
        List<KeyValue> keyValueList = new ArrayList<>();
        for(int i=0; i<keyValueArr.length; i++){
            String[] keyValue =  keyValueArr[i].split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            boolean isObject = value.contains("{");
            KeyValue keyValueObj = new KeyValue(key,value,isObject);
            keyValueList.add(keyValueObj);
        }
        return keyValueList;
    }
    }


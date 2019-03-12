/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:7:10
 * Introduction:URL映射
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _003 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        List<Rule> rules=  new ArrayList<>();
        input.nextLine();
        for(int i=0; i<n; i++){
            String inputStr=input.nextLine();
            String[] inputArray=inputStr.split("\\s");
            Rule ruleObj = new Rule(inputArray[0],inputArray[1]);
            rules.add(ruleObj);
        }
        for(int i=0; i<m; i++){
            String URL0 = input.nextLine();
            if(!URL0.matches("^([a-zA-Z0-9]|\\/|\\-|\\_|\\.)*$")){
                System.out.println("404");
                continue;
            }
            String URL = URL0.substring(1);//去除前面的/
            boolean endWithSlash = URL.endsWith("/");
            String[] URLArray = URL.split("/");
            List<Rule> matchedRule = new ArrayList<>();
            if(endWithSlash){
                for(Rule rule : rules ){//除path外长度相同，且都以/结束
                    if((rule.endWithSlash&&rule.ruleList.size()==URLArray.length)||rule.hasPath){
                        matchedRule.add(rule);
                    }
                }
            }
            else{
                for(Rule rule : rules ){
                    if((!rule.endWithSlash&&rule.ruleList.size()==URLArray.length)||rule.hasPath){
                        matchedRule.add(rule);
                    }
                }
            }
            int j=0;
            for(; j<matchedRule.size(); j++){
                if(!matched(URLArray,matchedRule.get(j),endWithSlash)){
                    matchedRule.get(j).matchedStr.clear();
                    continue;
                }else{
                    printMatch(matchedRule.get(j));
                    matchedRule.get(j).matchedStr.clear();
                    break;
                }
            }
            if(j>=matchedRule.size()){//说明没有break
                System.out.println("404");
            }
        }
    }

    public static void printMatch(Rule matchRule){
        List<String> matchedStr = matchRule.matchedStr;
        System.out.print(matchRule.ruleName+" ");
        for(int i=0; i<matchedStr.size(); i++){
            System.out.print(matchedStr.get(i)+" ");
        }
        System.out.print("\n");
    }

    public static boolean matched(String[] urlStr, Rule rule,boolean endWithSlash){
        if(rule.hasPath){
            if(rule.ruleList.size()-1==urlStr.length){//path为空
                return false;
            }else{
                int j=0;
                for(; j<rule.ruleList.size()-1; j++){//path前的字符都要相同
                    if(urlStr[j].equals(rule.ruleList.get(j))){
                        continue;
                    }
                    return false;
                }
                String matchingStr = "";
                for(int x=j; x<urlStr.length; x++)
                {
                    matchingStr+=urlStr[x]+"/";
                }
                if(!endWithSlash){
                    matchingStr = matchingStr.substring(0,matchingStr.length()-1);
                }
                rule.matchedStr.add(matchingStr);
                return true;
            }
        }
        for(int i=0; i<urlStr.length; i++){
            if(rule.ruleList.get(i).equals("<int>")&&urlStr[i].matches("^[0-9]+$")){
                String matchingStr =urlStr[i];
                while(matchingStr.startsWith("0")){
                    matchingStr = matchingStr.substring(1);
                }
                rule.matchedStr.add(matchingStr);
                continue;
            }else if(rule.ruleList.get(i).equals("<str>")&&urlStr[i].matches("^([0-9a-zA-Z]|-|_|\\.)+$")){
                rule.matchedStr.add(urlStr[i]);
                continue;
            } else if(urlStr[i].equals(rule.ruleList.get(i))){
                continue;
            }
            return false;
        }
        return true;
    }
}
class Rule{
    List<String> ruleList = new ArrayList<>();
    List<String> matchedStr = new ArrayList<>();
    String ruleName;
    boolean endWithSlash=false;
    boolean hasPath = false;
    public Rule(String ruleStr,String ruleName){
        this.ruleName = ruleName;
        if(ruleStr.contains("<path>")){
            hasPath = true;
        }
        if(ruleStr.endsWith("/")){
            endWithSlash=true;
        }
        String[] ruleArray = ruleStr.split("/");
        for(int i=1; i<ruleArray.length; i++){
            ruleList.add(ruleArray[i]);
        }
    }
}



import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/9
 * Time:16:17
 * Introduction:
 */
public class _02 {
    public static void main(String[] args){
        HashMap<Character,Integer> prority = new HashMap();
        prority.put('+',1);
        prority.put('-',1);
        prority.put('x',2);
        prority.put('/',2);
        prority.put('#',0);

        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        boolean[] result = new boolean[n];
        for(int x=0; x<n; x++){
            Stack<Integer> number = new Stack();
            Stack<Character> option = new Stack();
            option.push('#');
            String str = input.nextLine();
            for(int i=0; i<7; i++){
                char item = str.charAt(i);
                if(item>='0'&&item<='9'){
                    number.push(item-'0');
                }else{
                    if(prority.get(item)>prority.get(option.peek())){
                        option.push(item);
                    }else{
                        int num1 = number.pop();
                        int num2 = number.pop();
                        char op = option.pop();
                        int num;
                        switch(op){
                            case '+':num = num1 +num2;break;
                            case '-':num = num2 - num1;break;
                            case 'x':num = num2*num1;break;
                            case '/':num = num2/num1;break;
                            default:num = 0;
                        }
                        number.push(num);
                        option.push(item);
                    }
                }
            }
            while(number.size()!=1){
                int num1 = number.pop();
                int num2 = number.pop();
                int num;
                char item = option.pop();
                switch(item){
                    case '+':num = num1 +num2;break;
                    case '-':num = num2 - num1;break;
                    case 'x':num = num2*num1;break;
                    case '/':num = num2/num1;break;
                    default:num = 0;
                }
                number.push(num);
            }
            if(number.peek()==24){
                result[x] = true;
            }
        }
        for(int i=0; i<n; i++){
            if(result[i]){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }
}

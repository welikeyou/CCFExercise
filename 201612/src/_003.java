import java.util.*;

/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/3/13
 * Time:9:10
 * Introduction:权限查询
 */
public class _003 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        Map<String,Integer> privilege = new HashMap<>();
        for(int i=0; i<p; i++){
            String privilegeStr = input.next();
            boolean hasLevel = privilegeStr.contains(":");
            if(hasLevel){//说明带等级
                String[] privilegeArr=privilegeStr.split(":");
                int level=Integer.parseInt(privilegeArr[1]);
                privilege.put(privilegeArr[0],level);
            }
            else{
                privilege.put(privilegeStr,-1);
            }

        }
        int r = input.nextInt();//r个角色
        Map<String,Map<String,Integer>> roles = new HashMap<>();
        for(int i=0; i<r;i++){
            String roleName = input.next();
            Map<String,Integer> hashPri = new HashMap<>();
            int s =input.nextInt();
            for(int j=0;j<s;j++){
                String privilegeStr = input.next();
                boolean hasLevel = privilegeStr.contains(":");
                if(hasLevel){//说明带等级
                    String[] privilegeArr=privilegeStr.split(":");
                    int level=Integer.parseInt(privilegeArr[1]);
                    if(!(hashPri.containsKey(privilegeArr[0])&&hashPri.get(privilegeArr[0])>=level))
                    {
                        hashPri.put(privilegeArr[0],level);
                    }

                }
                else{
                    hashPri.put(privilegeStr,-1);
                }
            }
            roles.put(roleName,hashPri);
        }
        int u = input.nextInt();//u个用户
        Map<String ,Map<String,Integer>> users = new HashMap<>();
        for(int i=0; i<u; i++){
            String userName = input.next();
            int t = input.nextInt();
            Map<String,Integer> hashRole = new HashMap<>();
            for(int j=0; j<t; j++){
                String role = input.next();
                Map<String,Integer> hashPri = roles.get(role);
                Iterator it = hashPri.keySet().iterator() ;
                while(it.hasNext()){
                    String key = it.next().toString();
                    if(!(hashRole.containsKey(key)&&hashRole.get(key)>=hashPri.get(key))){
                        int level = hashPri.get(key);
                        hashRole.put(key,hashPri.get(key));
                    }
                }
            }
            users.put(userName,hashRole);
        }
        int q = input.nextInt();
        for(int i=0; i<q; i++){
            String userName = input.next();
            if(!users.containsKey(userName))
            {
                System.out.println("false");
                input.next();
            }
            else{
                String privilegeStr = input.next();
                boolean containLevel = privilegeStr.contains(":");
                if(containLevel){//有权限级别的，需要比较是否有该权限以及级别，输出true or false
                    Map<String ,Integer> hashPri = users.get(userName);
                    String[] privilegeArr = privilegeStr.split(":");
                    int level = Integer.parseInt(privilegeArr[1]);
                    if(hashPri.containsKey(privilegeArr[0])&&hashPri.get(privilegeArr[0])>=level){
                        System.out.println("true");
                    }
                    else{
                        System.out.println("false");
                    }
                }else{//没有等级或有等级需要返回等级

                    Map<String ,Integer> hashPri = users.get(userName);
                    if(hashPri.containsKey(privilegeStr)){
                        int level =hashPri.get(privilegeStr);
                        if(level!=-1){
                            System.out.println(level);
                        }
                        else{
                            System.out.println("true");
                        }
                    }
                    else{
                        System.out.println("false");
                    }
                }

            }

            }
        }

    }
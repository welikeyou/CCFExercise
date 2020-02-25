/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/16
 * Time:13:59
 * Introduction:
 */
public class Solution1 {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 1;
        StringBuffer str = new StringBuffer("We Are Happy");
//        solution.Find(target,nums);
        System.out.print(solution.replaceSpace(str));
    }

}

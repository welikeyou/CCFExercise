/**
 * Created with IDEA
 * author:LiLan
 * Date:2019/9/14
 * Time:9:02
 * Introduction:
 */
class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 1;
        StringBuffer str = new StringBuffer("We Are Happy");
//        solution.Find(target,nums);
        System.out.print(solution.replaceSpace(str));
    }
    public boolean Find(int target, int [][] array) {
        int len = array[0].length;
        int wid = array.length;
        if(target<array[0][0]||target>array[wid-1][len-1]){
            return false;
        }
        for(int i=0; i<wid; i++){
            int low = 0;
            int high = len-1;
            while(low<=high){
                int mid = (low + high)/2;
                if(array[i][mid]==target){
                    return true;
                }else if(array[i][mid]>target){
                    high = mid -1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return false;
    }
    public String replaceSpace(StringBuffer str) {
      String  result = str.toString().replaceAll("\\s","%20");
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int lastLeft = -1;
        int lastRight = -1;
        int left = 0;
        int right = nums.length;
        StringBuilder str = new StringBuilder();
        while(left<right){
            int mid = (left + right)/2;
            if(target == nums[mid]){
                right = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid -1;
            }
        }
        lastLeft =left==right? left:-1;
        left = 0;
        right = nums.length;
        while(left<right){
            int mid = (left + right)/2;
            if(target == nums[mid]){
                left = mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid -1;
            }
        }
        lastRight =left==right? right:-1;
        int[] result = {lastLeft,lastRight};
        return result;

    }
}



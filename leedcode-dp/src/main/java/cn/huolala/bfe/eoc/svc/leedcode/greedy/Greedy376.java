package cn.huolala.bfe.eoc.svc.leedcode.greedy;

public class Greedy376 {
    public static int wiggleMaxLength(int[] nums) {
        int totalLength = nums.length-1;
        int result = 3;
        int slowIndex = 0;
        int fastIndex = slowIndex+2;
        //奇数 偶数
        while(fastIndex<=totalLength && slowIndex<=totalLength){
            if((nums[slowIndex+1]-nums[slowIndex])*(nums[fastIndex]-nums[slowIndex+1]) >= 0){
                return result;
            }
            result++;
            fastIndex ++;
            slowIndex++;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] test = new int[]{1, 7, 4, 9, 2, 5};
        wiggleMaxLength(test);
    }
}

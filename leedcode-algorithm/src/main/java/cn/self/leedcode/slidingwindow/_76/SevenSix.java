package cn.self.leedcode.slidingwindow._76;

public class SevenSix {

    public  static String findIndex(String source, String target) {
        if (source.length() < target.length()) {
            return "";
        }
        char[] sArr = source.toCharArray();
        char[] tArr = target.toCharArray();
        //26个数字数组
        int[] hash = new int[256];
        //在集合中标记目标字符串
        for (int i = 0; i < tArr.length; ++i) {
            //hash数组中对应标记位
            hash[tArr[i]]++;
        }
        //存放结果集
        String results = "";
        //left左指针 sourceIndex 右指针
        int left = 0, count = 0, targetLength = target.length();

        for (int rightIndex = 0; rightIndex < sArr.length; rightIndex++) {
            //右指针
            hash[sArr[rightIndex] ]--;
            //hash出现了target,转化为count数值
            if (hash[sArr[rightIndex]] >= 0) {
                count++;
            }
            //左指针
            //targetLength - 1  下标最大值,当前指针比target最大下标大
            if (rightIndex >= targetLength - 1) {

                hash[sArr[left]]++;
                //左右指针字母相同
                if (hash[sArr[left]] > 0) {
                    count--;
                }
                //左指针每次向右移动
                left++;
            }
            //右指针出现了所有target，左指针还未出现时
            if (count == targetLength) {
                //results.add(left);
            }
        }

        return results;
    }

    public static void main(String[] args) {

        String a = "ADOBECODEBANC";
        //System.out.println(findAnagrams(a, "ac"));
        System.out.println(findIndex(a, "ABC"));
    }
}
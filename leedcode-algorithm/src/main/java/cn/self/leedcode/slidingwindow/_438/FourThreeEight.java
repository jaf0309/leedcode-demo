package cn.self.leedcode.slidingwindow._438;

import java.util.ArrayList;
import java.util.List;

public class FourThreeEight {
    public String minWindow(String s, String t) {
        String result = "";
        if(t.length() > s.length() || t.length()<1){
            return result;
        }

        int tLen = t.length();
       
        for(int i = tLen-1;i < s.length();i++){

            String sSubstring = s.substring(i - 2, i);


        }
        return result;

    }

    private int existNum(String curr, String t){
        int existNum = 0;
        for(int i = 0;i<t.length();i++){
            if(curr.contains(String.valueOf(t.charAt(i)))){

            }
        }


        return 0;
    }


    public Object[]  existAllIndex(String s, String t){
        int [] existAllIndex = new int[t.length()];
        List<Integer> existAllIndexList = new ArrayList<>();

        for(int i = 0;i<t.length();i++){
            int existIndex = s.indexOf(String.valueOf(t.charAt(i)));
            if(existIndex> -1){
                existAllIndexList.add(existIndex);
            }
        }

        return existAllIndexList.toArray();
    }

    /**
     * 第一种
     * @param source
     * @param target
     * @return
     */
    public  static  List<Integer> findIndex(String source, String target) {
        if (source.length() < target.length()) {
            return new ArrayList<Integer>();
        }
        char[] sArr = source.toCharArray();
        char[] tArr = target.toCharArray();
        //26个数字数组
        int[] hash = new int[26];
        //在集合中标记目标字符串
        for (int i = 0; i < tArr.length; ++i) {
            //hash数组中对应标记位
            hash[tArr[i] - 'a']++;
        }
        //存放结果集
        List<Integer> results = new ArrayList<>();
        //left左指针 sourceIndex 右指针
        int left = 0, count = 0, targetLength = target.length();
        for (int rightIndex = 0; rightIndex < sArr.length; rightIndex++) {
            //右指针
            hash[sArr[rightIndex] - 'a']--;
            //hash出现了target,转化为count数值
            if (hash[sArr[rightIndex] - 'a'] >= 0) {
                count++;
            }
            //左指针
            //targetLength - 1  下标最大值,当前指针比target最大下标大
            if (rightIndex > targetLength - 1) {

                hash[sArr[left] - 'a']++;
                //左右指针字母相同
                if (hash[sArr[left] - 'a'] > 0) {
                    count--;
                }
                //左指针每次向右移动
                left++;
            }
            //右指针出现了所有target，左指针还未出现时
            if (count == targetLength) {
                results.add(left);
            }
        }

        return results;
    }

    /**
     * 第二种
     * @param s
     * @param p
     * @return
     */
    public  static  List<Integer> findAnagrams(String s, String p) {
    int n = s.length(), m = p.length();
    List<Integer> res = new ArrayList<>();
    if(n < m) {
        return res;
    }
    int[] pCnt = new int[26];
    int[] sCnt = new int[26];

    for(int i = 0; i < m; i++){
        pCnt[p.charAt(i) - 'a'] ++;
    }

    int left = 0;
    for(int right = 0; right < n; right++){
        int curRight = s.charAt(right) - 'a';
        sCnt[curRight]++;
        while(sCnt[curRight] > pCnt[curRight]){
            int curLeft = s.charAt(left) - 'a';
            sCnt[curLeft]--;
            left++;
        }
        if(right - left + 1 == m){
            res.add(left);
        }
    }
    return res;
    }

    public static void main(String[] args) {

        String a = "grhybtcagpacegq";
        System.out.println(findAnagrams(a, "ac"));
        //System.out.println(findIndex(a, "ac"));
    }

}
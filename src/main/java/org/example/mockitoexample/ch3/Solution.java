package org.example.mockitoexample.ch3;

/*
    @author : Eton.lin
    @description TODO
    @date 2025-04-20 下午 04:21
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                char indexStr = s.charAt(i);
                char targetStr = s.charAt(j);
                if(indexStr==targetStr){
                    int temp = j-i;
                    result = Math.max(result,temp);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}

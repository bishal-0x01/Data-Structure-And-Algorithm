/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Link : https://leetcode.com/problems/valid-anagram/
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> cache  = new HashMap<>();

        for(int i = 0 ;i < s.length(); i++){
            cache.put(s.charAt(i),cache.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i = 0 ;i < t.length(); i++){
            cache.put(t.charAt(i),cache.getOrDefault(t.charAt(i),0)-1);
        }


        for(Map.Entry<Character,Integer> entry : cache.entrySet()){
            if(entry.getValue() != 0) return false;
        }

        return true;
    }
}
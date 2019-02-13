package com.example.solutiontest;

import java.util.*;

public class test1 {

    public static  List<String> topKFrequent(String[] words, int k) {
        List<String> arr = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        for(String word: words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) +1);
        }

        // map 降序排列
        Map<String, Integer> sortMap = new LinkedHashMap<>();
         wordsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                 .forEachOrdered(e -> sortMap.put(e.getKey(), e.getValue()));

        for(Map.Entry<String, Integer> map: sortMap.entrySet()) {
            arr.add(map.getKey());
        }

        int len = words.length;
        for(int index=1; len > index; index++) {
            if(sortMap.get(arr.get(index)) == sortMap.get(arr.get(index-1)) ) {
                int value = printArray(words, arr.get(index - 1));
                int value2 = printArray(words, arr.get(index));
                if(value > value2) {
                    String temp = arr.get(index );
                    arr.set(index, arr.get(index - 1));
                    arr.set(index-1, temp);
                }
            }
        }



        return arr.subList(0,k);
    }

    //遍历数组
    public static int printArray(String[] array,String value){
        for(int i = 0; i<array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;//当if条件不成立时，默认返回一个负数值-1
    }

    public int[] twoSum(int[] nums, int target) {

        return null;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        topKFrequent(words, k);

    }
}

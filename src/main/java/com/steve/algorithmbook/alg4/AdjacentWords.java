package com.steve.algorithmbook.alg4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liu on 10/22/16.
 *
 * 找寻只有一个字母不同的相似单词(长度需要相同)
 * 使用Map<String,List<String>>去封装关键词和相似的单词
 * key 是单词，value是和key只有一个字母不相同的值。
 */
public class AdjacentWords {

    //输出相似的单词
    public static void printAdjacentWords(Map<String,List<String>> words){
        for(Map.Entry<String,List<String>> mapWords: words.entrySet()){
            String key = mapWords.getKey();
            List<String> value = mapWords.getValue();
            System.out.print(key + "(" + value.size() + ")" + ": ");
            for(String w : value){
                System.out.print(w+"\t");
            }
            System.out.println();
        }
    }

    //确认单词的形式为只有一个字母不同的单词
    public static boolean onCharOff(String word1,String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        //这个变量只是为了确定只有一个字母能不相同
        int deff = 0;

        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i) != word2.charAt(i)){
                if( ++deff >1){
                    return false;
                }
            }
        }
        //只有一个的话，deff的确等于１
        return deff == 1;
    }

    //更新单词进入Map集合
    public static <T> void update(Map<T,List<String>> m, T key,String value){
        //判断key是否存在原来的map集合中
        List<String> keyValue = m.get(key);
        //不存在
        if(keyValue == null){
            keyValue = new ArrayList<String>();
            m.put(key,keyValue);
        }
        //往Map中加值
        keyValue.add(value);
    }

    //接收单词并进行分组
    public static Map<String,List<String>> computeAdjacent1(List<String> words){
        if(words == null){
            return null;
        }
        Map<String,List<String>> wordMap = new TreeMap<>();

        String[] word = new String[words.size()];

        words.toArray(word);

        for(int i=0;i<words.size();i++){
            for(int j=i+1;j<words.size();j++){
                if(onCharOff(word[i],word[j])){
                    update(wordMap,word[i],word[j]);
                    update(wordMap,word[j],word[i]);
                }
            }
        }
        return wordMap;
    }

    //单单就处理一个长度的话，没必要，
    public static Map<String,List<String>> computeAdjacent2(List<String> words){
        if(words == null)
            return null;
        Map<String,List<String>> mapRe = new TreeMap<>();
        //构造一个以长度为key的map，书上说和１比较节省一半的时间，实践发现耗费更多的时间(*2)
        Map<Integer,List<String>> mapLen = new TreeMap<>();
        for(String word :words){
            update(mapLen,word.length(),word);
        }
        //根据长度来筛选是否相等，速度更快
        for(List<String> groupWords : mapLen.values()){
            String[] b = new String[groupWords.size()];
            groupWords.toArray(b);
            for(int i=0;i<words.size();i++){
                for(int j=0;j<words.size();j++) {
                    if (onCharOff(b[i], b[j])) {
                        update(mapRe,b[i],b[j]);
                        update(mapRe,b[j],b[i]);
                    }
                }
            }
        }
        return mapRe;
    }
    //这种方法想法是不错的，可惜for循环太多了，浪费时间了.
    public static Map<String,List<String>> computeAdjacent3(List<String> words){
        Map<String,List<String>> mapRe = new TreeMap<>();
        Map<Integer,List<String>> mapLen = new TreeMap<>();
        for(String w :words){
            update(mapLen,w.length(),w);
        }
        for(Map.Entry<Integer,List<String>> groupMap: mapLen.entrySet()){
            int groupNum = groupMap.getKey();
            List<String> groupValues = groupMap.getValue();
            //对每个单词长度进行去字母找集合运算
            for(int i=0;i<groupNum;i++){
                Map<String,List<String>> repToMap = new TreeMap<>();
                for(String str : groupValues){
                    String rep = str.substring(0,i)+str.substring(i+1);
                    update(repToMap,rep,str);
                }
                //最后将数据放入返回的集合中去
                for(List<String> wordClient:repToMap.values()){
                    if(wordClient.size() >=2){
                       for(String s1:wordClient){
                           for(String s2:wordClient){
                               if(s1!=s2){
                                   update(mapRe,s1,s2);
                               }
                           }
                       }
                    }
                }
            }
        }
        return mapRe;
    }
    public static void main(String... args){
        int N = 8900;
        long timeSTART = System.currentTimeMillis();
        for(int i=0;i<N;i++) {
            List<String> a = new ArrayList<String>();
            a = getWords(a);
            Map<String, List<String>> b = new TreeMap<>();
            b = computeAdjacent3(a);
            printAdjacentWords(b);
        }
        long timeEND = System.currentTimeMillis();
        System.out.println(timeEND - timeSTART);
    }
    public static List<String> getWords(List<String> a){
        String wordFile = "/home/liu/words.txt";
        File file = new File(wordFile);
        FileInputStream in = null;
        BufferedReader reader = null;
        try{
            in = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(in));
            String word = "";
            while((word = reader.readLine())!= null){
                a.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }
}

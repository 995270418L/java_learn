package com.steve.cow_guest.classes.c6;

import java.util.HashMap;

/**
 *  自定义一个结构RandomPool，实现三个方法，insert,delete,getRandom。时间复杂度都为O(1)。
 *  布隆过滤器部分功能实现(hash函数，分配字节涂黑);
 */
public class HashDemo {

    /**
     * 借用两个Map来实现这个结构，主要是getRandom，其次是delete方法
     */
    public static class RandomPool{
        private HashMap<String,Integer> mainMap ;
        private HashMap<Integer,String> helpMap ;
        private int size;

        public RandomPool(){
            mainMap = new HashMap();
            helpMap = new HashMap();
            this.size = 0;
        }

        /**
         * 插入的话，主Map key为插入值，value为size。帮助Map key为size，value为值。
         * @param key
         */
        public void insert(String key){
            if(!mainMap.containsKey(key)) {
                mainMap.put(key, size);
                helpMap.put(size++, key);
            }
        }

        /**
         * 删除操作两个Map都必须执行，但如果只删除，不进行任何操作会造成helpMap有空洞，进而影响getRandom方法的执行。
         * 所以每次删除一个key，都将hashMap中的最后一个key替换过来，helpMap也是一样。
         * @param key
         */
        public void delete(String key){
            if(mainMap.containsKey(key)){
                int index = mainMap.get(key);
                int lastIndex = size - 1;
                String lastKey = helpMap.get(lastIndex);
                //首先put，再删除
                mainMap.put(lastKey,index);
                helpMap.put(index,lastKey);
                mainMap.remove(key);
                helpMap.remove(lastIndex);
                size --;
            }else{
                System.out.println("key 不存在");
            }
        }

        /**
         * 从helpMap中取随机位置的下表，在根据key去取value。这是单个map所不能实现的。
         * @return
         */
        public String getRandom(){
            if(size == 0){
                System.out.println("mainMap 容量为0");
                return null;
            }
            int index = (int) (Math.random() * size);
            return helpMap.get(index);
        }
    }

    public static void main(String[] args) {
        hashOne("liu");
    }

    /**
     * 用md5的方法取前几个值作为一个hash方法a，后几个值作为另一个hash方法b。后面就可以生成任意多个hash方法了(a + i*b i = 0,1,2,3,4,5,6 ....),
     * 而且都是相互独立的。
     */
    public static int hashOne(String str){
        return 0;
    }

    public static void allocate(long capacity,long code){
        long[] space = new long[(int) (capacity/8/8)];          // 一个long类型有8个字节
        int index = (int) (code / 64);                          // 找到具体字节位置
        int rIndex = (int) (code % 64);                         // 找到需要涂黑的字节位，比如是34的位置需要涂黑
        space[index] = (space[index] | (1 << rIndex));          // 1 左移涂黑位再或上原先位置的数，就实现了涂黑(有1选1)的功能。
    }



}

package com.steve.algorithmbook.alg5;

/**
 * Created by liu on 11/4/16.
 *  二次探索哈希表
 *  公式: f(n) = f(n-1) + 2*n -1  -> f(n) = n^2
 */
public class QuadraticProbingHashTable<T> {

    //hashtable 的默认大小，必须是素数
    private static final int DEFAULT_TABLE_SIZE=3;
    //元素数组(对象数组必须初始化后才能使用 Object o = new Object())
    private HashEntry<T>[] array;
    //已经占用的位置大小
    private int currentSize;
    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    public QuadraticProbingHashTable(int size){
        allocateArray(size);
        makeEmpty();
    }
    //查找，插入，删除是散列表的基本操作，也是他的优点所在(O(1))
    public boolean contains(T x){
        int currentPos = findPox(x);
        return isActive(currentPos);
    }
    public boolean insert(T x){
        int currentPos = findPox(x);
        //不可插入
        if(isActive(currentPos))
            return false;
        if(array[currentPos] == null){
            ++currentSize;
        }
        array[currentPos] = new HashEntry<T>(x,true);
        //超过元素数组的一半就需要扩容。
        if(currentSize > array.length/2){
            rehash();
        }
        return true;
    }
    public boolean remove(T x){
        int currentPos = findPox(x);
        if(isActive(currentPos)){
            array[currentPos].isActive = false;
            currentSize --;
            return true;
        }else{
            //已经标记删除
            return false;
        }
    }
    /*
    * hashTable　Size
    * */
    public int size(){
        return currentSize;
    }
    /*
    *　返回内部元素数组的大小
    * */
    public int capacity(){
        return array.length;
    }
    public boolean isEmpty(){
        for(int i=0;i<array.length;i++){
            HashEntry<T> hash = array[i];
            if(hash.isActive == false)
                currentSize = 0;
        }
        return currentSize==0;
    }
    /*7
    * if true 不可插入
    * */
    private boolean isActive(int currentPos){
        return array[currentPos] != null && array[currentPos].isActive;
    }

    //冲突的解决方法 (f(n) = f(n-1) + 2*n -1 )
    public int findPox(T x){
        //遍历开端
        int offset = 1;
        //遍历时刻位置
        int currentPos = myhash(x);
        while((array[currentPos] != null) && !array[currentPos].element.equals(x)){
            currentPos += offset;
            offset += 2;

            if(currentPos >= array.length){
                currentPos -= array.length;
            }
        }
        return currentPos;
    }
    public int myhash(T x){
        int hashVal = x.hashCode();
        hashVal %= array.length;
        if(hashVal < 0){
            hashVal += array.length;
        }
        return hashVal;
    }
    //给表扩容
    private void rehash(){
        HashEntry[] oldArray = array;
        //扩大为2倍大小
        allocateArray(2*oldArray.length);
        currentSize = 0;
        for(HashEntry<T> entry: oldArray){
            if(entry != null && entry.isActive){
                insert(entry.element);
            }
        }
    }
    public void makeEmpty(){
        currentSize = 0;
        for(int i=0;i<array.length;i++){
            array[i] = null;
        }
    }
    //用于保存元素的hashEntry类　类似于上一节的list节点
    public static class HashEntry<T>{
        //element
        private T element;
        //isActive 是否标记删除状态(true 没有删除　false　标记删除)
        private boolean isActive;

        public HashEntry(T t){
            this(t,true);
        }
        public HashEntry(T t,boolean isActive){
            this.element = t;
            this.isActive = isActive;
        }
    }
    //给hash表分配大小
    public void allocateArray(int size){
        array = new HashEntry[nextPrime(size)];
    }
    //找寻一个至少比n大的或者等于n的素数
    private static int nextPrime(int n){
        if(n % 2 ==0){
            n++;
        }
        for(;!isPrime(n);n+=2)
            ;
        return n;
    }
    //判断当前数组大小是否为素数
    private static boolean isPrime(int n){
        if(n == 2 || n == 3)
            return true;
        if(n == 1 || n % 2 == 0)
            return false;
        //to this step it must be single num.
        for(int i=3;i*i<=n;i += 2)
            if(n % i ==0)
                return false;
        return true;
    }
    //这个求素数的方法比上面的几乎多了一倍的时间
    public static boolean isPrime2(int n){
        if(n==1){
            return false;
        }
        int i = 2;
        while(i<n){
            if(n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }
    public static void main1(String... args){
        QuadraticProbingHashTable<Integer> H = new QuadraticProbingHashTable<>();
        long start = System.currentTimeMillis();

        System.out.println( "Checking... (no more output means success)" );

        final int NUMS = 2000000;
        final int GAP = 37;
        for(int i=GAP;i!=0;i = (i+GAP)%NUMS)
            H.insert(i);
        for(int i=1;i<NUMS;i+=2)
            H.remove(i);
        for(int i=2;i<NUMS;i+=2)
            if(!H.contains(i))
                System.out.println("find failed"+i);
        for(int i=1;i<NUMS;i+=2)
            if(H.contains(i))
                System.out.println("OOPS..." +1);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time " + (end-start));
    }
    public static void main(String... args){
        QuadraticProbingHashTable<Integer> h = new QuadraticProbingHashTable<>();
        int[] a = {4371,1323,6173,4199,4344,9679,1989};
        for(int i=0;i<a.length;i++){
            h.insert(a[i]);
        }
    }
}

package com.steve.ifeve.jvm;

public class JvmGenerationLog {

    public static final int _1MB = 1024 * 1024;
    /**
     * -Xms10M -Xmx20M -Xmn10M
     * @param args
     */
//    public static void main(String[] args) {
//        byte[] byte1, byte2, byte3, byte4;
//        byte1 = new byte[2 * _1MB];
//        byte2 = new byte[2 * _1MB];
//        byte3 = new byte[2 * _1MB];
//        byte4 = new byte[4 * _1MB];
//    }

    /**
     * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 # 表示进入老年代的年龄  -Xloggc:F:\gc.log # gc 文件
     * -Xms20M -Xmx20M -Xmn10M -verbose:gc -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] byte1, byte2, byte3, byte4;
        byte1 = new byte[_1MB / 4];
        byte2 = new byte[4 * _1MB];
        byte3 = new byte[4 * _1MB];
        byte3 = null;
        System.gc();
        byte3 = new byte[4 * _1MB];
    }
}

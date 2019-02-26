package com.steve.ifeve.multipartline.chapter12;



/**
 * Created by liu on 6/7/17.
 * Junit test
 */
public class BoundedBufferTest {

    /**
     * 测试BoundedBuffer的后验条件和不变性条件
     */
    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
    }

}

package com.steve.ifeve.multipartline.chapter1;


import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liu on 4/9/17.
 * 线程安全的计数器
 */
@ThreadSafe
public class CountingFactory implements Servlet{

    public final AtomicInteger atomicInteger = new AtomicInteger(0);

    public long getAtomicInteger(){
        return atomicInteger.get();
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        atomicInteger.incrementAndGet();    //线程安全的自增
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

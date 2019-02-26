package com.steve.designModule.ProxyModule.Classes;

import com.steve.designModule.ProxyModule.Abstracts.BasicClass;

/**
 * Created by liu on 4/1/17.
 * 代理类 内部拥有被代理对象的实现(BasicImpl)
 */
public class LoggerProxy implements BasicClass {

    //代理对象
    private Logger logger = new Logger();

    //真实查询对象
    private BasicImpl test = new BasicImpl();

    /**
     * 代理对象在实现的方法上需要调用被代理对象的实现方法。在插入别的逻辑(此处是日志记录)
     */
    @Override
    public String DoMethod() {
        logger.beforeMethod(getMethodName());
        String returnString = null ;
        try {
            // 调用被代理类的实现方法
            returnString = test.DoMethod();
        }catch(Exception e){
            logger.afterMethodError(getMethodName());
        }
        logger.afterMethod(getMethodName());
        return returnString;
    }

    public String getMethodName(){
        return test.DoMethod();
    }

}

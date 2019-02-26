package com.steve.ifeve.JavaIo.ExceptionHandler;

import java.io.InputStream;

/**
 * Created by liu on 6/19/17.
 * 使用接口 + 非抽象类　来解决这个问题
 *
 */
public interface TemplateProcessExceptionInterface {

    void doProcess(InputStream inputStream);

}

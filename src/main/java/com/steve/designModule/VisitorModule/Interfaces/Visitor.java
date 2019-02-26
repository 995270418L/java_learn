package com.steve.designModule.VisitorModule.Interfaces;

import com.steve.designModule.VisitorModule.Classes.FullEmployees;
import com.steve.designModule.VisitorModule.Classes.PartTimeEmployees;

/**
 * Created by liu on 4/8/17.
 * 访问者类
 */
public interface Visitor {
    void visit(FullEmployees fullEmployees);
    void visit(PartTimeEmployees partTimeEmployees);
}

package com.steve.algorithms.company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 简化路径
 */
public class SimplePath {

    public static void main(String[] args) {
        SimplePath cm = new SimplePath();
        System.out.println(cm.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        if (path.equals("/")) return "/";
        String[] pathArr = path.split("/");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < pathArr.length; i++) {
            if (pathArr[i].equals("")) continue;
            String value = pathArr[i];
            if (value.equals("..")) {
                if (res.size() > 0) res.remove(res.size() - 1);
            } else if (!value.equals(".")) {
                res.add(value);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String str : res) {
            sb.append(str).append("/");
        }
        return sb.length() > 1 ? sb.toString().substring(0, sb.toString().length() - 1) : sb.toString();
    }

}

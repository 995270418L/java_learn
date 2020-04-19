package com.steve.algorithms.company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 简化路径
 */
public class RestoreIpAddress {

    private List<String> res;

    public static void main(String[] args) {
        RestoreIpAddress cm = new RestoreIpAddress();
        System.out.println(cm.restoreIpAddresses("1231231231234")); // 010010
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        return res;
    }

    public void dfs(int prevPos, int dots) {

    }

    /**
     * 暴力枚举法
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        for (int i = 1; i <= s.length() - 3; i++) {
            for (int j = i + 1; j <= s.length() - 2; j++) {
                for (int k = j + 1; k <= s.length() - 1; k++) {
                    String val = backtrace(i, j, k, s);
                    if (val != null) res.add(val);
                }
            }
        }
        return res;
    }

    public String backtrace(int i, int j, int k, String s) {
        Integer kVal = Integer.valueOf(s.substring(k));
        if (kVal > 255) return null;
        Integer jVal = Integer.valueOf(s.substring(j, k));
        if (jVal > 255) return null;
        Integer iVal = Integer.valueOf(s.substring(i, j));
        if (iVal > 255) return null;
        Integer fVal = Integer.valueOf(s.substring(0, i));
        if (fVal > 255) return null;
        String res = fVal + "." + iVal + "." + jVal + "." + kVal;
        if (res.length() == s.length() + 3) return res;
        return null;
    }

    /**
     * 回溯法
     */
    public void backtrace(String str) {

    }

}

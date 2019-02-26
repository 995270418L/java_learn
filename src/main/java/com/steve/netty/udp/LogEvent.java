package com.steve.netty.udp;

import java.net.InetSocketAddress;

/**
 * @Author: steve
 * @Date: Created in 8:54 2018/3/24
 * @Description:
 * @Modified By:
 */
public class LogEvent {

    private final char SEPERATOR = ':';
    private String logFile;
    private String msg;
    private long received;
    private InetSocketAddress address;

    public LogEvent(String logFile, String msg){
        this(null,-1,logFile,msg);
    }

    public LogEvent(InetSocketAddress address, long received, String logFile, String msg){
        this.address = address;
        this.received = received;
        this.logFile = logFile;
        this.msg = msg;
    }

    public char getSEPERATOR() {
        return SEPERATOR;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getReceived() {
        return received;
    }

    public void setReceived(long received) {
        this.received = received;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

    public void setAddress(InetSocketAddress address) {
        this.address = address;
    }
}

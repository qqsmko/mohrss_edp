package com.mohress.edp.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by youtao.wan on 2017/6/5.
 */
public class LocalMachine {
    private static final int TIME_STAMP = 1000 * 60 * 60 * 24 * 7;

    private static String localMachine;

    static {
        try {
            String ip = getAddress().getLocalHost().getHostAddress();
            localMachine = ip.substring(ip.lastIndexOf(".")+1);
        }catch (Throwable ignore){
            localMachine = String.valueOf(System.currentTimeMillis()%TIME_STAMP);
        }
    }

    private static InetAddress getAddress(){
        try {
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements();){
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual()|| !networkInterface.isUp()){
                    continue;
                }

                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                if (addresses.hasMoreElements()){
                    return addresses.nextElement();
                }
            }
        }catch (SocketException e){
            // ignore
        }
        return null;
    }

    public static String getLocalMachine(){
        return localMachine;
    }
}

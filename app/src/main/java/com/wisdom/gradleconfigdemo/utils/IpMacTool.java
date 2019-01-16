package com.wisdom.gradleconfigdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by chenqianghua on 2018/9/27.
 */

public class IpMacTool {

    private static Context mContext;
    private static final String END_WITH_ETH = "%eth0";
    private static final String END_WITH_WLAN = "%wlan0";
    private  static String ethIp_Group = "";
    private  static String ethIp_trans = "";
    private  static String wlanIp_Group = "";
    private  static String wlanIp_trans = "";
    private static String ipAddrShow = "";
    private static String macAddrShow = "";
    private  static String ethMac = "";
    private  static String wlanMac = "";
    public static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    public static final String ethPath = "/sys/class/net/eth0/address";
    private static int NET_ETHERNET = 1;
    private static int NET_WIFI = 2;
    private static int NET_4G = 0;
    private static boolean changeToWifiNet = false;


    public static String[] getAllLocalIpAndMac(Context context) {
        mContext = context;
        judgeNetworkType(mContext);
        //4GRouting displays CPE info
        ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo ethNetInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
        NetworkInfo wifiNetInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (null != networkInfo && networkInfo.isConnected()){
            // TODO: 2018/8/10 displays CPE MACAddress
        }

        boolean isEth0 = false;
        boolean isWlan0 = false;
        try {
            String ipv4 = null;
            List<NetworkInterface> nilist = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface ni : nilist) {
                List<InetAddress> ialist = Collections.list(ni.getInetAddresses());
                for (InetAddress address : ialist) {
                    ipv4 = address.getHostAddress();
                    if (!address.isLoopbackAddress()) {
//                        Log.d(TAG," ipv4 is " + ipv4);
                        if (null != ipv4){
                            if (isEth0){
                                ethIp_Group = ipv4;
                                isEth0 = false;
                            }
                            else if (isWlan0){
                                wlanIp_Group = ipv4;
                                isWlan0 = false;
                            }
                            if (ipv4.endsWith(END_WITH_ETH)){
                                ethIp_trans = ipv4.replace(END_WITH_ETH,"");
                                ethMac = getLocalMacAddressFromIp(ethIp_trans);
                                isEth0 = true;
                            }
                            else if (ipv4.endsWith(END_WITH_WLAN)){
                                isWlan0 = true;
                                wlanIp_trans = ipv4.replace(END_WITH_WLAN,"");
                                wlanMac = getLocalMacAddressFromIp(wlanIp_trans);
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {

        }
        if (!Objects.equals("",ethIp_Group) && ethNetInfo.isConnected()){
            if (changeToWifiNet){
                ipAddrShow = wlanIp_Group;
                macAddrShow = wlanMac.toUpperCase();
                changeToWifiNet = false;
            }
            else {
                ipAddrShow = ethIp_Group;
                macAddrShow = ethMac.toUpperCase();
            }
        }
        else if (!Objects.equals("",wlanIp_Group) && wifiNetInfo.isConnected()){
            ipAddrShow = wlanIp_Group;
            macAddrShow = wlanMac.toUpperCase();
        }
        return new String[]{ipAddrShow,wlanMac,ethMac};
    }


    public static  int judgeNetworkType(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ethNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
        NetworkInfo wifiNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        int returnType = NET_ETHERNET;
        if (ethNetInfo != null && ethNetInfo.isConnected()) {
            returnType = NET_ETHERNET;
        } else if (wifiNetInfo != null && wifiNetInfo.isConnected()) {
            returnType = NET_WIFI;
        } else if (mobileNetInfo != null && mobileNetInfo.isConnected()){
            returnType = NET_4G;
        }
        if (returnType == NET_WIFI && (ethNetInfo == null || !ethNetInfo.isConnected())){
            changeToWifiNet = true;
        }
        return returnType;
    }

    private static String getLocalMacAddressFromIp(String ip) {
        String mac_s = "";
        try {
            byte[] mac;
            InetAddress ipAddress = InetAddress.getByName(ip);
            if (ipAddress == null) {
                return mac_s;
            }
            NetworkInterface ne = NetworkInterface.getByInetAddress(ipAddress);
            mac = ne.getHardwareAddress();
            if (mac.length > 0) {
                mac_s = byte2mac(mac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return mac_s;
        }
    }

    private static String byte2mac(byte[] b) {
        StringBuffer hs = new StringBuffer(b.length);
        String stmp = "";
        int len = b.length;
        for (int n = 0; n < len; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1) {
                hs = hs.append("0").append(stmp);
            } else {
                hs = hs.append(stmp);
            }
        }
        StringBuffer str = new StringBuffer(hs);
        for (int i = 0; i < str.length(); i++) {
            if (i % 3 == 0) {
                str.insert(i, ':');
            }
        }
        return str.toString().substring(1);
    }

    public static String getCurrentNetworkType (Context context) {
        String type = "";
        ConnectivityManager connectMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ethNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
        NetworkInfo wifiNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        int returnType = NET_ETHERNET;
        if (ethNetInfo != null && ethNetInfo.isConnected()) {
            returnType = NET_ETHERNET;
            type = "eth";
        } else if (wifiNetInfo != null && wifiNetInfo.isConnected()) {
            returnType = NET_WIFI;
            type = "wifi";
        } else if (mobileNetInfo != null && mobileNetInfo.isConnected()){
            returnType = NET_4G;
            type = "4G";
        }
        if (returnType == NET_WIFI && (ethNetInfo == null || !ethNetInfo.isConnected())){
            changeToWifiNet = true;
        }
        return type;
    }
}

package com.wisdom.gradleconfigdemo.readassets.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created by hukun on 2018/1/5.
 */

@XStreamAlias("PresetAccount")
public class ServerCountConfigEntity {
    List<ServerCountEntity> mEntityList;

    public List<ServerCountEntity> getEntityList() {
        return mEntityList;
    }

    public void setEntityList(List<ServerCountEntity> entityList) {
        mEntityList = entityList;
    }

    @XStreamAlias("data")
   public static class ServerCountEntity {

        //    <serverType></serverType>
        //		<serverNum></serverNum>
        //		<name>PremiumStalker</name>
        //		<url>http://premium.absono.com:9696/c/</url>
        //		<port>9696</port>
        //		<account></account>
        //		<password></password>
        //		<autologin>false</autologin>
        //		<mac></mac> <!-- 不配置表示默认使用机器mac地址 -->
        //		<groupNum>0</groupNum>
        private String serverType;
        private String serverNum;
        private String name;
        private String url;
        private String port;
        private String account;
        private String password;
        private String autologin;
        private String mac;
        private String groupNum;

        public String getServerType() {
            return serverType;
        }

        public void setServerType(String serverType) {
            this.serverType = serverType;
        }

        public String getServerNum() {
            return serverNum;
        }

        public void setServerNum(String serverNum) {
            this.serverNum = serverNum;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAutologin() {
            return autologin;
        }

        public void setAutologin(String autologin) {
            this.autologin = autologin;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getGroupNum() {
            return groupNum;
        }

        public void setGroupNum(String groupNum) {
            this.groupNum = groupNum;
        }
    }
}

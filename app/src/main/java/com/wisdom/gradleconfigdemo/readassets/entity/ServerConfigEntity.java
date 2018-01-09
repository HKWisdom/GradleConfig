package com.wisdom.gradleconfigdemo.readassets.entity;

import java.util.List;

/**
 * Created by hukun on 2018/1/5.
 */

public class ServerConfigEntity {
//    {"server":[
//        {"name":"Informir Stalker", "position":4, "db_type":0, "server_name_glo":"","logo_path":""},
//        {"name":"Xtream-codes Stalker", "position":1, "db_type":1,"server_name_glo":"","logo_path":""},
//        {"name":"Xtream-codes Panel", "position":2, "db_type":3,"server_name_glo":"","logo_path":"/system/etc/server_logo_crown.png"},
//        {"name":"Load m3u", "position":3, "db_type":5,"server_name_glo":"","logo_path":""},
//        {"name":"M3u from web", "position":5, "db_type":7,"server_name_glo":"","logo_path":""},
//        {"name":"TV Club", "position":6, "db_type":4,"server_name_glo":"","logo_path":""}
//]}

    private List<ServerEntity> mServerEntityList;

    public List<ServerEntity> getServerEntityList() {
        return mServerEntityList;
    }

    public void setServerEntityList(List<ServerEntity> serverEntityList) {
        mServerEntityList = serverEntityList;
    }

    public static class ServerEntity {
        private String name;
        private int position;
        private int db_type;
        private String server_name_logo;
        private String logo_path;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getDb_type() {
            return db_type;
        }

        public void setDb_type(int db_type) {
            this.db_type = db_type;
        }

        public String getServer_name_logo() {
            return server_name_logo;
        }

        public void setServer_name_logo(String server_name_logo) {
            this.server_name_logo = server_name_logo;
        }

        public String getLogo_path() {
            return logo_path;
        }

        public void setLogo_path(String logo_path) {
            this.logo_path = logo_path;
        }
    }
}

package com.wisdom.gradleconfigdemo.readassets.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by hukun on 2018/1/5.
 */

@XStreamAlias("PresetDefaultData")
public class GlobalConfigEntity {
//    <showMac></showMac> 	 <!-- 配置要求：非必须配置。 配置描述：配置用于UI显示的mac地址，未配置则默认显示本机的mac。 值类型：正确的mac地址类型（xx:xx:xx:xx:xx:xx）-->
//	<defaultLockPassword></defaultLockPassword> 		<!-- 配置要求：非必须配置。 配置描述：配置本地加锁的默认密码，未配置则默认0000。 值类型：4位阿拉伯数字-->
//	<allowAddServer></allowAddServer>  		<!-- 配置要求：非必须配置。 配置描述：配置是否允许添加server，未配置则默认为true。 值类型：true或者false。 true：表示允许用户添加，false：表示不允许， -->
//	<serverTotal></serverTotal>			<!-- 配置要求：非必须配置。 配置描述：配置显示可添加server的个数，未配置默认为16。 值类型：阿拉伯数字。 最大32 -->
//	<menuLogo></menuLogo>			<!-- 配置要求：必须配置 固定配置，不可改变。 配置描述：MainMenu上显示的logo。 值为：menu_logo.png -->
//	<screenScale></screenScale>  	<!-- 配置要求：非必须配置。 配置描述： 配置播放长宽比，未配置默认为1。值类型： SCREEN_NORMAL:0 ， SCREEN_FULL:1  -->
//	<loginType></loginType>
//	<okListMode></okListMode>

    private String showMac;
    private String defaultLockPassword;
    private String allowAddServer;
    private String serverTotal;
    private String menuLogo;
    private String screenScale;
    private String loginType;
    private String okListMode;

    public String getShowMac() {
        return showMac;
    }

    public void setShowMac(String showMac) {
        this.showMac = showMac;
    }

    public String getDefaultLockPassword() {
        return defaultLockPassword;
    }

    public void setDefaultLockPassword(String defaultLockPassword) {
        this.defaultLockPassword = defaultLockPassword;
    }

    public String getAllowAddServer() {
        return allowAddServer;
    }

    public void setAllowAddServer(String allowAddServer) {
        this.allowAddServer = allowAddServer;
    }

    public String getServerTotal() {
        return serverTotal;
    }

    public void setServerTotal(String serverTotal) {
        this.serverTotal = serverTotal;
    }

    public String getMenuLogo() {
        return menuLogo;
    }

    public void setMenuLogo(String menuLogo) {
        this.menuLogo = menuLogo;
    }

    public String getScreenScale() {
        return screenScale;
    }

    public void setScreenScale(String screenScale) {
        this.screenScale = screenScale;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getOkListMode() {
        return okListMode;
    }

    public void setOkListMode(String okListMode) {
        this.okListMode = okListMode;
    }
}

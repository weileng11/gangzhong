package com.gangzhongbrigade.app.net;

public class RequestUrl {

    public interface SubPaths {
        /**
         * 登录
         */
        String Login_Tooth="DistributorLogin&MemLoginID=";
    }

//    public interface WebPath {
//        //获取用户守则
//        String getUserRule = "/user_code";
//        //关于我们
//        String aboutMe = "/about";
//        //用户注册协议
//        String userAgreement = "/user_agreement";
//        //
//        String pointRule = "/points_rule";
//        //广告详情
//        String advDetail = "/api.php/ad/ad_main";
//    }
//
//    public static final String socketHost = "219.137.154.4";
//    public static final int socketPort = 8877;

    public static String getRequestPath(String subPath) {
        return rootUrl + subPath;
    }

//    public static String getWebRequestPath(String subPath) {
//        return webRootUrl + subPath;
//    }
//
//    public static String getImgPath(String imgPath) {
//        return imgRootUrl + imgPath;
//    }

//    static final String rootUrl = "http://yafeng.ibona.cn/api.php";
//    static final String webRootUrl = "";
//    static final String imgRootUrl = "http://yafeng.ibona.cn";

    static final String rootUrl = "http://aclmmanage.jshec.cn:8856/APIInterface.ashx" +
            "?AppKey=2c07694b782c43859defb6b9bbed4c7d&md5Key=78403D5AE398E69CA83A19A743240A9687EBAE78" +
            "&method=";
//    static final String webRootUrl = "http://666.1kb.ren:8899/api.php/Html";
//    static final String imgRootUrl = "http://666.1kb.ren:8899";
}
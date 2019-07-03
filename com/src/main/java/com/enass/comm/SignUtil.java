package com.enass.comm;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Created on 2018/8/14
 */
public class SignUtil {
    private final static String CLIENT_ID = "c9efby65fe1258ye";
    private final static String CLIENT_SECRET = "b1870a6209b14b6db5d8baaa27297f22";

    public static void main(String[] args) throws Exception {
        /*String user_id = "50000003160117";
        String org_id = "6070000";
        String mobile ="13681358160";
        String account ="009_system";
        String email ="zhangsansi01@qq.com";
        String action_id ="100000019";
        String open_id = "949fb70df9e24b6a8ee1cf436a24d4ad";
        String matching = "1";
        String system_id = "101";
        String name = "qy17600850069";
        String info_id = "5960000";
//        String parent_name = "交通运输、仓储和邮政业";
        String q = "公司";
        String grant_type = "refresh_token";
        String refresh_token = "2d9b719df5674f6b98e9e7175edc3b65";
        String code = "k7qz8yiu";
        String redirect_uri = "http://www.casicloud.com/";
        String access_token = "tRLshOloDnpzqXuAVFJHkjwKhD4WWx0CxHwHD2V6dVre8XzfIRlzDpinLwHOxEJHZXUyWntmxyV2gOaTRU15An9Meb3gPNMWLHUKQxisnAg=";

        System.out.println(signQuery("access_token=" + access_token));
//        System.out.println(signQuery("grant_type=" + grant_type + "&code=" + code + "&redirect_uri=" + redirect_uri));
        System.out.println(signQuery("grant_type=" + grant_type + "&refresh_token=" + refresh_token));
//        System.out.println(signQuery("info_id=" + info_id));
//        System.out.println(signQuery("matching=" + matching + "&name=" + name));
//        System.out.println(signQuery("user_id=" + user_id + "&org_id=" + org_id));
//        System.out.println(signQuery("mobile=" + mobile + "&org_id=" + org_id));
//        System.out.println(signQuery("mobile=" + mobile ));
//        System.out.println(signQuery("account=" + account ));
//        System.out.println(signQuery("org_id=" + org_id ));
//        System.out.println(signQuery("user_id=" + user_id ));
//        System.out.println(signQuery("action_id=" + action_id ));
//        System.out.println(signQuery("open_id=" + open_Id ));
//        System.out.println(signQuery("name=" + name ));
//        System.out.println(signQuery("system_id=" + system_id ));
//        System.out.println(signQuery("q=" + URLEncoder.encode("公司","utf-8")));
//        System.out.println(signQuery("access_token=" + URLEncoder.encode("交通运输、仓储和邮政业","utf-8")));
//        System.out.println(signQuery("name=" + URLEncoder.encode("航天云网","utf-8")));
*/
        System.out.println(signQuery(""));

    }


    public static String signQuery(String query) throws Exception {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(query)) {
            builder.append(query);
            builder.append("&");
        }
        builder.append("client_id=").append(CLIENT_ID);
        builder.append("&ts=").append(System.currentTimeMillis());
        builder.append("&sign=").append(getSign(queryToMap(builder.toString()), CLIENT_SECRET));
        return builder.toString();
    }

    private static String getSign(Map<String, String> params, String clientSecret) {
        if (StringUtils.isEmpty(clientSecret) || params == null || params.size() == 0)
            return "";
        List<String> paramNames = new ArrayList<>(params.keySet());
        Collections.sort(paramNames);
        StringBuilder builder = new StringBuilder();
        for (String name : paramNames) {
            builder.append(name);
            builder.append("=");
            builder.append(params.get(name));
        }
        builder.append(clientSecret);
        try {
            return md5(builder.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    private static Map<String, String> queryToMap(String query) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(query))
            return map;
        String[] array = query.split("&");
        for (String item : array) {
            String[] p = item.split("=");
            if (p.length == 2)
                map.put(p[0], p[1]);
        }
        return map;
    }

    private static String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(data.getBytes(Charset.forName("UTF-8")));
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String result = bigInt.toString(16);
        if (result.length() < 32) {
            StringBuffer buffer = new StringBuffer(result);
            while (buffer.length() < 32) {
                buffer.insert(0, '0');
            }
            result = buffer.toString();
        }
        return result;
    }
}

package com.yuque.sdk.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author nanchen
 * @Date 2023/10/27 14:19
 * 一些工具方法
 **/
public class Func {

    //转为url路径，以/分割。
    public static String convertUrlPath(String... strs) {
        String urlPath = Arrays.stream(strs).collect(Collectors.joining("/"));
        return removeRepeatSlash(urlPath);
    }

    //去除请求路径的重复斜杠
    private static String removeRepeatSlash(String str) {
        if (!str.contains("//")) {
            return str;
        }
        str = str.replace("//", "/");
        return removeRepeatSlash(str);
    }

    public static String removeUnLegalFolderChar(String str) {
        return str.replaceAll("[/\\\\:\\*\\?\"<>\\|]", "").replace(" ","");
    }
}

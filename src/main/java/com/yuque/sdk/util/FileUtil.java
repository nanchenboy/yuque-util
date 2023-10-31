package com.yuque.sdk.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author nanchen
 * @Date 2023/10/24 16:59
 **/
@Slf4j
public class FileUtil {

    public static void exportFile(String text, String outputFilePath,String fileName) {
        try {
            File outputFile = new File(outputFilePath);
            if (!outputFile.exists()) {
                outputFile.mkdirs();
            }
            FileWriter fw = new FileWriter(outputFilePath+fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            // 导出文件
            bw.write(text);
            bw.close();
            fw.close();
        } catch (IOException e) {
            log.error("导出失败{}",fileName);
            log.error(e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        exportFile("a","D:\\Desktop\\公司\\yuqueBackUp\\浙江省自然资源网上交易系统（一级市场）\\","a.txt");
    }
}

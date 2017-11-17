package com.wdt.ddshop.upload.test;

import com.wdt.ddshop.common.util.FtpUtils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpUploadTest {
  /*  @Test
    public void  testFtpUploadUtil()throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("e:\\1.jpg"));
        FtpUtils.uploadFile("10.31.161.42",21,"ftpuser","wdt123wdt","/home/ftpuser/www/images","/2017/09/11","matter.jpg",fileInputStream);
    }

    @Test
    public void  testFtpUpload()throws IOException {
        FTPClient ftpClient=new FTPClient();
        ftpClient.connect("10.31.161.42",21);
        ftpClient.login("ftpuser","wdt123wdt");
        //读取本地上传文件
        FileInputStream fileInputStream=new FileInputStream(new File("e:\\1.jpg"));
        // 上传路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/2017/9");
        ////设置上传文件的类型为二进制类型
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //remote传入文件命名
        ftpClient.storeFile("shi.jpg",fileInputStream);
        fileInputStream.close();
        ftpClient.logout();
     }*/

}

package com.suns.download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class imageDownload {
    public static void main(String[] args) {
//        String url = "http://localhost:8080/image/touxiang.png";
        String url = "http://47.107.146.57:9080/eic-web/res/lib/atlantislite/img/profile.jpg";
        downloadPicture(url);
    }
    //链接url下载图片
    private static void downloadPicture(String urlList) {
        URL url = null;
        int imageNumber = 0;

        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            String imageName =  "D:/test.jpg";

            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            byte[] context=output.toByteArray();
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
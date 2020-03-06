package com.huhuamin.starter.fdb;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/5 15:13
 * @Description:
 */
public interface FdbService {
    /**
     * 二进制转云图片地址
     *
     * @param img
     * @return
     */
    String convertByteToOssObject(byte[] img);

    /**
     * 文件上传转云图片路径
     *
     * @param doc
     * @param request
     * @return
     * @throws IOException
     */
    String convertFileToOssObject(MultipartFile doc, HttpServletRequest request) throws IOException;

    /**
     * 多文件上传处理 base64
     *
     * @param compImages
     * @param bf
     * @throws IOException
     */
    void multiImageOss(String[] compImages, StringBuffer bf) throws IOException;

    String singleImageOss(String oriData);

    String multiFileOss(MultipartFile doc, HttpServletRequest request) throws IOException;

    String muchImageOss(String[] images);

    String convertByteToOssPDF(byte[] file);
    public String singlePdfOss(MultipartFile file);
}

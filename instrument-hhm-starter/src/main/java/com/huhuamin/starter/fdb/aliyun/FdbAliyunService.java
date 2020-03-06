package com.huhuamin.starter.fdb.aliyun;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.huhuamin.starter.Uuid22Util;
import com.huhuamin.starter.fdb.FdbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 胡化敏(huhuamin)
 * @email 175759041@qq.com
 * @date 2018/5/18 下午2:43
 */
public class FdbAliyunService implements FdbService {
    private AliyunCosProperties aliyunCosProperties;
    private OSSClient ossClient;

    public FdbAliyunService(AliyunCosProperties aliyunCosProperties, OSSClient ossClient) {
        this.aliyunCosProperties = aliyunCosProperties;
        this.ossClient = ossClient;
    }

    public FdbAliyunService() {

    }

    @Override
    public String convertByteToOssObject(byte[] img) {
        String filename = "";
        if (null != img && img.length > 0) {
            String targetDirectory = aliyunCosProperties.getBuckName() + "/";
            ;
            String secPath = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
            String targetFileName = secPath.concat("/").concat(Uuid22Util.generateUuid22().concat(".jpg"));
            filename = targetDirectory + targetFileName;
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(img.length);
            InputStream input = new ByteArrayInputStream(img);
            PutObjectResult result = ossClient.putObject(aliyunCosProperties.getBuckName(), filename, input, meta);
        }

        return filename;
    }

    @Override
    public String convertFileToOssObject(MultipartFile doc, HttpServletRequest request) throws IOException {
        String filename = "";
        String targetDirectory = aliyunCosProperties.getBuckName() + "/";
        String secPath = new SimpleDateFormat("yyyyMMdd").format(new Date());

        ObjectMetadata meta = new ObjectMetadata();
        String targetFileName = secPath.concat("/").concat(Uuid22Util.generateUuid22().concat(".jpg"));
        String savaUrl = targetDirectory + targetFileName;
        PutObjectResult result = ossClient.putObject(aliyunCosProperties.getBuckName(), savaUrl, doc.getInputStream(), meta);
        filename = targetDirectory + targetFileName;
        return filename;
    }


    /**
     * 数组图片处理
     *
     * @param compImages 原始图片流
     * @param bf         保存的路径
     * @throws IOException
     */
    @Override
    public void multiImageOss(String[] compImages, StringBuffer bf) throws IOException {
        for (String compImage : compImages) {
            if (!StringUtils.isBlank(compImage) && compImage.contains(",")) {
                String tempImg = compImage.split(",")[1];
                BASE64Decoder decoder22 = new BASE64Decoder();
                byte[] bytes33 = decoder22.decodeBuffer(tempImg);
                String fileName = convertByteToOssObject(bytes33);
                bf.append("/" + fileName).append(",");
            }

        }

    }

    @Override
    public String singleImageOss(String oriData) {
        try {
            //处理logo
            if (StringUtils.isNotEmpty(oriData) && oriData.contains("data:image")) {
                String headImg = oriData.split(",")[1];
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] bytes1 = new byte[0];
                bytes1 = decoder.decodeBuffer(headImg);
                String fileName = convertByteToOssObject(bytes1);
                return fileName;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String singlePdfOss(MultipartFile file) {
        try {
            byte[] bytes1 = new byte[0];
            bytes1 = file.getBytes();
            String fileName = convertByteToOssPDF(bytes1);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String convertByteToOssPDF(byte[] file) {
        String filename = "";
        if (null != file && file.length > 0) {
            String targetDirectory = "suzong/";
            String secPath = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String targetFileName = secPath.concat("/").concat(UUID.randomUUID().toString().concat(".pdf"));
            // 上传文件
            filename = targetDirectory + targetFileName;
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();

            // 必须设置ContentLength
            InputStream input = new ByteArrayInputStream(file);
            PutObjectResult result = ossClient.putObject(aliyunCosProperties.getBuckName(), filename, input, meta);
        }
        return filename;

    }

    /**
     * 多图处理
     */
    @Override
    public String muchImageOss(String[] images) {
        String strImg = "";
        String ossImgs = "";
        if (null != images) {
            for (int i = 0; i < images.length; i++) {
                int j = (i + 1) / 2;
                if (("").equals(strImg)) {
                    strImg = strImg + images[i] + ",";
                } else {
                    strImg = strImg + images[i];
                    if (("").equals(ossImgs)) {
                        ossImgs = singleImageOss(strImg);
                    } else {
                        ossImgs = ossImgs + "," + singleImageOss(strImg);
                    }
                    strImg = "";
                }
            }
        }
        return ossImgs;
    }

    @Override
    public String multiFileOss(MultipartFile doc, HttpServletRequest request) throws IOException {
        String fileName = convertFileToOssObject(doc, request);
        return fileName;
    }


}

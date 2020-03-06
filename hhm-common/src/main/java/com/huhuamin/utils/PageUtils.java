package com.huhuamin.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author 胡化敏
 * @Description: 分页处理工具类
 * @Date Create 2017/11/20 09:56
 * @Modified By:
 * @Since:
 */
public class PageUtils {

    public static Integer ifNullPageNumWithDeafult(String pageNum) {

        if (StringUtils.isBlank(pageNum)) {
            return 1;
        }
        Integer pageNumInt = Integer.valueOf(pageNum);
        if (pageNumInt.intValue() == 0) {
            return 1;
        } else {
            return pageNumInt;
        }

    }

    public static Integer ifNullPageSizeWithDeafult(String pageSize) {

        if (StringUtils.isBlank(pageSize)) {
            return 10;
        }
        Integer pageSizeInt = Integer.valueOf(pageSize);
        if (pageSizeInt.intValue() == 0) {
            return 10;
        } else {
            return pageSizeInt;
        }

    }
}

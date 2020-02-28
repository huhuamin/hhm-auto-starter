package com.huhuamin.validate;

import com.huhuamin.req.ReqComm;
import com.huhuamin.req.constants.DeviceType;

/**
 * @Auther: Huhuamin
 * @Date: 2020/2/28 11:15
 * @Description:
 */
public class CommonValidate {
    /**
     * 检查是否需要设备ID
     *
     * @param reqComm
     * @return
     */
    public static boolean checkDeviceId(ReqComm reqComm) {
        if (androidOrIos(reqComm)) {
            return true;
        } else return false;
    }

    /**
     * 检查是否需要设备ID,增加小程序版本，默认不增加
     *
     * @param reqComm
     * @return
     */
    public static boolean checkDeviceIdWithMp(ReqComm reqComm) {
        if (androidOrIosAndMp(reqComm)) {
            return true;
        } else return false;
    }

    /**
     * 判断是否是安卓和IOS
     *
     * @param reqComm
     * @return
     */
    public static boolean androidOrIos(ReqComm reqComm) {
        return DeviceType.Android == reqComm.getRegisterSource() || DeviceType.IOS == reqComm.getRegisterSource();
    }

    /**
     * 判断是否是安卓和IOS 还有小程序
     *
     * @param reqComm
     * @return
     */
    public static boolean androidOrIosAndMp(ReqComm reqComm) {
        return DeviceType.Android == reqComm.getRegisterSource() || DeviceType.IOS == reqComm.getRegisterSource();
    }
}

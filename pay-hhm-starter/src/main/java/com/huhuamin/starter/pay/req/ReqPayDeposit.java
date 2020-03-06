package com.huhuamin.starter.pay.req;

import com.huhuamin.req.ReqToken;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Huhuamin
 * @Date: 2020/3/7 00:07
 * @Description:
 */
public class ReqPayDeposit extends ReqToken {

    /**
     * 支付方式[1-支付宝 2-微信 空-直接提交]
     */
    @NotNull(message = "支付类型不能为空")
    private Byte orderSource;

    public Byte getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
    }

}

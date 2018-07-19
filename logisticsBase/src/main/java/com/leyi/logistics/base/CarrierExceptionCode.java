/**
 * CarrierExceptionCode class
 *
 * @author Jerry Yang
 * @date 2018/7/17 12:24.
 */
package com.leyi.logistics.base;

import com.zhaoguanche.saas.core.exception.BaseExceptionCode;

public enum CarrierExceptionCode implements BaseExceptionCode {

    MISS_CARRIER_ORDER(-1,"缺失实体数据"),
    MISS_CARRIER_ORDER_CODE(-1, "缺失运单号码"),

    ;

    private  int code;
    private  String msg;

    CarrierExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

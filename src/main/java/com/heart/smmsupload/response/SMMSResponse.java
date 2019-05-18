package com.heart.smmsupload.response;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 13:59
 */
public class SMMSResponse {

    private String code;

    private String msg;

    private String data;

    public String getCode() {
        return code;
    }

    public SMMSResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SMMSResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getData() {
        return data;
    }

    public SMMSResponse setData(String data) {
        this.data = data;
        return this;
    }
}

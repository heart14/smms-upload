package com.heart.smmsupload.response;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/18 13:59
 */
public class SMMSResponse {

    private String msg;

    private List<Map<String, String>> data;

    public String getMsg() {
        return msg;
    }

    public SMMSResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public SMMSResponse setData(List<Map<String, String>> data) {
        this.data = data;
        return this;
    }
}

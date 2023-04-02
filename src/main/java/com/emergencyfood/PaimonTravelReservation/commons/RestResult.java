package com.emergencyfood.PaimonTravelReservation.commons;

import lombok.Data;

@Data
public class RestResult<T> {

    /**
     * 错误码。
     *
     * 1. code = 1000 时表示正常处理
     * 2. code = 其它值的含义，由业务方自己定义
     */
    private int code;
    /**
     * 错误详情
     */
    private String message;
    /**
     * 真实的数据
     */
    private T data;

    /**
     * 调用成功时使用
     */
    public static <T> RestResult<T> success(T data) {
        RestResult<T> res = new RestResult<>();
        res.code = 200;
        res.message = "success";
        res.data = data;
        return res;
    }

    /**
     * 失败时使用
     */
    public static <T> RestResult<T> fail(int code, String message) {
        RestResult<T> res = new RestResult<>();
        res.code = code;
        res.message = message;
        return res;
    }

}

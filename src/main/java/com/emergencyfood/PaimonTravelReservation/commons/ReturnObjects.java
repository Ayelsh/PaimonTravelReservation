package com.emergencyfood.PaimonTravelReservation.commons;

import lombok.Data;

@Data
public class ReturnObjects {

    private String code;//处理成功获取失败的标记：1---成功,0---失败
    private String message;//提示信息
    private Object retData;//其它数据

}

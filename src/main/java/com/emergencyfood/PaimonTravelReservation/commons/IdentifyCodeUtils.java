package com.emergencyfood.PaimonTravelReservation.commons;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class IdentifyCodeUtils {

    //随机产生数字和字母组合的字符串
    private static String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    
    /**
    * 获取验证码
    *
    * @return
    */
    public static String getIdentifyCode() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            char c = randString.charAt(random.nextInt(randString.length()));
            buffer.append(c);
        }
        return buffer.toString();
    }
    

    
    
}


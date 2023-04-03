package com.emergencyfood.PaimonTravelReservation.commons;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JWTUtil {
    private static final Logger log = LoggerFactory.getLogger(JWTUtil.class);
    private final static long EXPIRE_TIME = 2 * 3600 * 1000L;


    private final static String SECRET = "AyelshXhopeT131116QSX";

    /**
     * 生成 token
     */
    public static String jwtCreate(String userid) {
        try {

            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withClaim("userid", userid)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 校验 token是否正确
     *
     * @param token token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            verifier.verify(token);

            return true;
        } catch (Exception e) {
            log.info("token is invalid");
            return false;
        }
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUserid(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userid").asString();
        } catch (JWTDecodeException e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }




}

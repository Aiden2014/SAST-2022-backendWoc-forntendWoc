package com.sast.woc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sast.woc.entity.User;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;
import java.util.logging.Logger;

public class JwtUtil {
    private static final Logger logger = Logger.getLogger(JwtUtil.class.getName());
    //定义token返回头部
    private static String header;
    private static String tokenPrefix;
    private static String secret = "88888888";
    private static long expireTime;
    public static final String USER_LOGIN_TOKEN = "USER_LOGIN_TOKEN";
    public static void setExpireTime(long expireTime){JwtUtil.expireTime = expireTime * 1000L * 60; }
    public static void setTokenPrefix(String tokenPrefix){JwtUtil.tokenPrefix = tokenPrefix; }
    public static String getSecret(){return secret; }
    public static String getTokenPrefix(){return tokenPrefix; }
    public static String getHeader(){return header; }
    //创建token
    public static String createToken(User user){
        return JWT.create()
                .withClaim("id",user.getId())
                .withClaim("userName",user.getUserName())
                .withClaim("email",user.getEmail())
                .withClaim("role",user.getRole())
                //设置超时时间
                .sign(Algorithm.HMAC256(secret));
    }
    //验证token
    public static Map<String, Claim> valifyToken(String token){
        try{
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token)
                    .getClaims();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

package com.changgou;/**
 * @Author panqian
 * @Date 2020/11/25 16:52
 * @Version 1.0.0
 */


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author panqian
 * @Date 2020/11/25 16:52
 * @Version 1.0.0
 */
public class Base64Test {
    public static void main(String[] args) throws Exception {
//        String str1 = "123456";
//      byte[] encode =  Base64.getEncoder().encode(str1.getBytes());
//      String str2 = new String(encode,"UTF-8");
//        System.out.println(str2);
//       byte[] decode = Base64.getDecoder().decode("");
//        String str3 = new String(decode,"UTF-8");
//        System.out.println(str3);
//        JwtBuilder builder = Jwts.builder();
//        builder.setIssuedAt(new Date());
//        builder.setIssuer("潘谦");
//        builder.setSubject("JWT令牌测试");
//        builder.signWith(SignatureAlgorithm.HS256,"hello world");
//        Map<String,Object> map = new HashMap<>();
//
//        Red red = new Red();
//        red.setColor("红色");
//        red.setName("灯");
//        red.setUse("红绿灯");
//        map.put("name","潘谦");
//        map.put("address","益阳");
//        map.put("sex","男");
//        map.put("color",red);
//        builder.addClaims(map);
//        System.out.println(builder.compact());
//        String token = builder.compact();
//        Claims claims = Jwts.parser()
//                .setSigningKey("hello world")
//                .parseClaimsJws(token)
//                .getBody();
//        System.out.println(claims.toString());

    }
}

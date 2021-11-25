package com.lincheng.study.oauth2.jjwt;

import com.lincheng.study.oauth2.StudySecurityOauth2Application;
import com.lincheng.study.common.utils.DateUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @description:
 * @author: linCheng
 * @create: 2021-11-24 23:03
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudySecurityOauth2Application.class)
public class JjwtTest {

    /**
     * 获取token
     */
    @Test
    public void getToken() {
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置id 等同于 {"jti":"888"}
                .setId("888")
                //签发用户 等同于{"sub":"lincheng"}
                .setSubject("lincheng")
                //签发时间 等同于{"iat":"xxxxx"}
                .setIssuedAt(new Date())
                //
                .signWith(SignatureAlgorithm.HS256, "xxxx");

        String token = jwtBuilder.compact();
        System.out.println(token);
        String[] split = token.split("\\.");
        //头部
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        //负载
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //签名
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));

    }

    /**
     * 解析token
     */
    @Test
    public void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJsaW5jaGVuZyIsImlhdCI6MTYzNzc2NjkxNH0.6kEpcQ3-8yw_pQJ16S8YJAj-aYp1k8SS96fOiPn1A_o";
        //获取claims(荷载)
        Claims claims = Jwts.parser()
                .setSigningKey("xxxx")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("jti" + claims.getId());
        System.out.println("sub" + claims.getSubject());
        System.out.println("iat" + claims.getIssuedAt());
    }


    /**
     * 获取token(过期时间)
     */
    @Test
    public void getTokenHasExp() {
        long now = System.currentTimeMillis();
        //一分钟过期
        long exp = now + 60 * 1000;

        JwtBuilder jwtBuilder = Jwts.builder()
                //设置id 等同于 {"jti":"888"}
                .setId("888")
                //签发用户 等同于{"sub":"lincheng"}
                .setSubject("lincheng")
                //签发时间 等同于{"iat":"xxxxx"}
                .setIssuedAt(new Date())
                //盐
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                //设置过期时间 等同于{"exp":"xxxxx"}
                .setExpiration(new Date(exp));

        String token = jwtBuilder.compact();
        System.out.println(token);
        String[] split = token.split("\\.");
        //头部
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        //负载
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //签名
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));

    }

    /**
     * 解析token(过期时间)
     */
    @Test
    public void parseTokenHasExp() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJsaW5jaGVuZyIsImlhdCI6MTYzNzc3MDMzOSwiZXhwIjoxNjM3NzcwMzk5fQ.AC2cgvueVEKTGef7rEwagea-2EYpHZVzksXTmxxRxtU";
        //获取claims(荷载)
        Claims claims = Jwts.parser()
                .setSigningKey("xxxx")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("jti" + claims.getId());
        System.out.println("sub" + claims.getSubject());
        System.out.println("签发时间" + DateUtils.dateToString(claims.getIssuedAt()));
        System.out.println("当前时间" + DateUtils.dateToString(new Date()));
        System.out.println("过期时间" + DateUtils.dateToString(claims.getExpiration()));
    }



    /**
     * 获取token(自定义申明)
     */
    @Test
    public void getTokenHasClaims() {
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置id 等同于 {"jti":"888"}
                .setId("888")
                //签发用户 等同于{"sub":"lincheng"}
                .setSubject("lincheng")
                //签发时间 等同于{"iat":"xxxxx"}
                .setIssuedAt(new Date())
                //
                .signWith(SignatureAlgorithm.HS256, "xxxx")
                //自定义申明 map同时多个申明
                //.addClaims()
                //自定义申明 一条申明
                .claim("logo","xxx.xxx")
                .claim("自定义申明","claim");

        String token = jwtBuilder.compact();
        System.out.println(token);
        String[] split = token.split("\\.");
        //头部
        System.out.println(Base64Codec.BASE64.decodeToString(split[0]));
        //负载
        System.out.println(Base64Codec.BASE64.decodeToString(split[1]));
        //签名
        System.out.println(Base64Codec.BASE64.decodeToString(split[2]));

    }

    /**
     * 解析token(自定义申明)
     */
    @Test
    public void parseTokenHasClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJsaW5jaGVuZyIsImlhdCI6MTYzNzc3MDcwMywibG9nbyI6Inh4eC54eHgiLCLoh6rlrprkuYnnlLPmmI4iOiJjbGFpbSJ9.by-_xAxnQvq12qCbsi0zOj3i7eOtl52ZqA_SBvSAcLA";
        //获取claims(荷载)
        Claims claims = Jwts.parser()
                .setSigningKey("xxxx")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("jti" + claims.getId());
        System.out.println("sub" + claims.getSubject());
        System.out.println("iat" + claims.getIssuedAt());
        System.out.println("logo:" + claims.get("logo"));
        System.out.println("自定义申明:" + claims.get("自定义申明"));
    }

}

package com.store.storeend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @className: JwtTokenUtil
 * @description:
 * @author: 15506
 * @date: 2024/2/14 16:59
 */
@Component
public class JwtTokenUtil {

    @Value("${spring.jwt.secret}")
    private String secret; // 从配置文件中读取的JWT密钥

    @Value("${spring.jwt.expiration}")
    private long expiration; // 从配置文件中读取的JWT过期时间

    // 生成JWT Token
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    // 创建JWT Token
    private String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret) // 使用HS512算法和密钥对JWT进行签名
                .compact(); // 压缩为字符串表示形式
    }

    // 从JWT Token中提取声明
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 提取JWT Token中的所有声明
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // 从JWT Token中提取用户名
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 从JWT Token中提取过期时间
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // 验证JWT Token是否过期
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 验证JWT Token是否有效
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}

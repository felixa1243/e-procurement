package com.enigma.shared.utils;

import com.enigma.shared.exception.UnauthorizedException;
import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Getter @Setter
public class JwtUtils {
    @Value("${token.jwt.secret}")
    private String secret;
    @Value("${token.jwt.expiration}")
    private Integer expiration;

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
    }

    public boolean validateToken(String token) throws Exception {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new UnauthorizedException("expired token");
        } catch (UnsupportedJwtException e) {
            throw new UnauthorizedException("Token unsupported");
        } catch (MalformedJwtException e) {
            throw new UnauthorizedException("Token malformed");
        } catch (SignatureException e) {
            throw new UnauthorizedException("Signature unknown");
        } catch (IllegalArgumentException e) {
            throw new UnauthorizedException("Token is invalid");
        }
    }
}

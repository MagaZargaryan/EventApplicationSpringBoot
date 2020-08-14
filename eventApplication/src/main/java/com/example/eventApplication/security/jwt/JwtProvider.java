package com.example.eventApplication.security.jwt;

import com.example.eventApplication.security.service.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSectret;

    @Value("${app.jwtExpiration}")
    private String jwtExpiration;

    public String generateJwtToken(Authentication authentication){
        UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
          return Jwts.builder()
                .setSubject((userPrinciple.getUsername()))
                .setIssuedAt(new Date())
//                  .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                 .signWith(SignatureAlgorithm.HS512, jwtSectret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser()
                .setSigningKey(jwtSectret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(jwtSectret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e){
            logger.error("Invalid -> Message : {}", e);
        } catch (MalformedJwtException e){
            logger.error("Invalid -> Message : {}", e);
        } catch (ExpiredJwtException e){
            logger.error("Invalid -> Message : {}", e);
        } catch (UnsupportedJwtException e){
            logger.error("Invalid -> Message : {}", e);
        } catch (IllegalArgumentException e){
            logger.error("Invalid -> Message : {}", e);
        }
        return false;
    }

}

package rs.ac.uns.ftn.portal_poverenika.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;

import java.util.Date;

import static rs.ac.uns.ftn.portal_poverenika.security.SecurityConstants.TOKEN_EXP;
import static rs.ac.uns.ftn.portal_poverenika.security.SecurityConstants.TOKEN_PREFIX;
import static rs.ac.uns.ftn.portal_poverenika.security.SecurityConstants.TOKEN_SECRET;

public class JwtUtil {

    public String createJwt(User user) {
        return TOKEN_PREFIX + Jwts.builder()
                .setSubject(user.getEmail())
                .claim("user", user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
                .signWith(Keys.hmacShaKeyFor(TOKEN_SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}

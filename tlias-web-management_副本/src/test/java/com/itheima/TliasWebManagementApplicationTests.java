package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testJWT(){


        Map<String, Object> maps= new HashMap<>();
        maps.put("name","123");
        maps.put("namename","123123");
        String wsw123 = Jwts.builder().signWith(SignatureAlgorithm.HS256, "wsw123").setClaims(maps)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 1000)).compact();
        System.out.println(wsw123);


    }
    @Test
    void testParse(){
        Claims wsw123 = Jwts.parser().setSigningKey("wsw123").parseClaimsJwt("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lbmFtZSI6IjEyMzEyMyIsIm5hbWUiOiIxMjMiLCJleHAiOjE2ODM2MjQyMTF9.t15Wpv_mx0MitmyY_6q6W7J_uY-5hTR0OXJxqqRlbn8")
                .getBody();
        System.out.println(wsw123);
    }

}

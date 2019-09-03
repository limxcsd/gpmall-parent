package com.study.gpmall.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.study.gpmall.common.constants.ResultCodeConstants;
import com.study.gpmall.common.exception.ValidateException;
import lombok.Builder;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

/**
 * @ClassName: JwtTokenUtils
 * @Description: JwtToken生成的工具类
 * @author: limingxing
 * @Date: 2019-08-23 20:10
 */
@Slf4j
@Builder
public class JwtTokenUtils {
    /**
     * 传输信息，必须是json格式
     */
    private String msg;
    /**
     * 所验证的jwt
     */
    @Setter
    private String token;

    private final String secret = "324iu23094u598ndsofhsiufhaf_+0wq-42q421jiosadiusadiasd";

    public static String ACCESS_TOKEN = "access_token";

    public static String USER_INFO_KEY = "userInfo";

    /**
     * 生成token
     *
     * @return
     */
    public String creatJwtToken() {
        msg = new AESUtils(msg).encrypt();//先对信息进行aes加密(防止被破解）
        String token = null;
        try {
            token = JWT.create()
                    .withIssuer("wlgzs").withExpiresAt(DateTime.now().plusDays(1).toDate())
                    .withClaim("user", msg)
                    .sign(Algorithm.HMAC256(secret));
        } catch (Exception e) {
            throw e;
        }
        log.info("加密后：{}", token);
        return token;
    }

    /**
     * 解密jwt并验证是否正确
     */
    public String freeJwt() {
        DecodedJWT decodedJWT = null;
        try {
            //使用hmac256加密算法
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer("wlgzs")
                    .build();
            decodedJWT = verifier.verify(token);
            log.info("签名人：" + decodedJWT.getIssuer() + " 加密方式：" + decodedJWT.getAlgorithm() + " 携带信息：" + decodedJWT.getClaim("user").asString());
        } catch (Exception e) {
            log.info("jwt解密出现错误，jwt或私钥或签证人不正确");
            throw new ValidateException(ResultCodeConstants.TOKEN_VALID_FAILED.getCode(), ResultCodeConstants.TOKEN_VALID_FAILED.getMessage());
        }
        //获得token的头部，载荷和签名，只对比头部和载荷
        String[] headPayload = token.split("\\.");
        //获得jwt解密后头部
        String header = decodedJWT.getHeader();
        //获得jwt解密后载荷
        String payload = decodedJWT.getPayload();
        if (!header.equals(headPayload[0]) && !payload.equals(headPayload[1])) {
            throw new ValidateException(ResultCodeConstants.TOKEN_VALID_FAILED.getCode(), ResultCodeConstants.TOKEN_VALID_FAILED.getMessage());
        }
        return new AESUtils(decodedJWT.getClaim("user").asString()).decrypt();
    }

}

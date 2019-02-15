package com.poppy.admin.security;

import lombok.extern.log4j.Log4j;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 处理用户授权异常
 */
@Component
@Log4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        /**
         * 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应
         */
        log.info("未携带token");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException==null?"Unauthorized":authException.getMessage());
    }
}

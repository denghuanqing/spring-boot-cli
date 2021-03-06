package com.poppy.security.config.jwt;

import com.poppy.security.config.service.CustomUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(
            OAuth2AccessToken accessToken,
            OAuth2Authentication authentication) {
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        String roles = "";
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) customUserDetails.getAuthorities();
        for (GrantedAuthority grantedAuthority : grantedAuthorities) {
            roles = roles.concat(" " + grantedAuthority.getAuthority());
        }
        roles = roles.trim();

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("uuid", customUserDetails.getId());
        additionalInfo.put("role", roles);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }
}
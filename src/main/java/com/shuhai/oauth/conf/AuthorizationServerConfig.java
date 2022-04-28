package com.shuhai.oauth.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret(passwordEncoder.encode("654321"))
                .autoApprove("all")
                .accessTokenValiditySeconds(3600)
                .redirectUris("http://www.baidu.com", "http://www.cnblogs.com")
                .scopes("all")
                //配置grant_type，表示授权码授权
                .authorizedGrantTypes("authorization_code");

    }


    /**
     * todo  oauth_client_details
     *{@link org.springframework.security.oauth2.provider.client.JdbcClientDetailsService}
      */
    @Bean
    public ClientDetailsService getClientDetailsService() {
        ClientDetailsService clientDetailsService = new ClientDetailsService() {
            @Override
            public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
                return null;
            }
        };
        return clientDetailsService;
    }

}

package br.dev.simon.hroauth.services;

import br.dev.simon.hroauth.entities.User;
import br.dev.simon.hroauth.feignclients.UserFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClients userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: " + email);
            throw new IllegalStateException("Email not found");
        }
        logger.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: " + email);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("Email found: " + email);
        return user;
    }
}

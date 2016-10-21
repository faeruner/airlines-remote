package by.pvt.module4.client.common;

import by.pvt.module4.client.service.UserService;
import by.pvt.module4.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {
    private Logger log = LogManager.getLogger(AuthenticationService.class);
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        if (login != null) {
            log.info("Login: " + login);
            user = userService.getUserByLogin(login);
        }
        if (user == null) {
            log.info("User not found.");
            throw new UsernameNotFoundException("User not found");
        }
        log.info("User: " + user);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword()
                , true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName().toUpperCase()));
        log.info("authorities: " + authorities);
        return authorities;
    }
}

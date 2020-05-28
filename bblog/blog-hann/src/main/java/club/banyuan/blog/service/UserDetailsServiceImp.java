package club.banyuan.blog.service;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.security.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("db")
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //username --> user
        User user = userService.findByName(s);
        if (user == null){
            throw new UsernameNotFoundException(s + "Not Found");
        }else {
            //user --> userDetails
            return new UserDetailsImp(user);
        }
    }
}

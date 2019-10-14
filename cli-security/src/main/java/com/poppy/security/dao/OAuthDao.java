package com.poppy.security.dao;

import com.poppy.security.domain.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class OAuthDao {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    public UserEntity getUserDetails(String username) {
        Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
        String userSQLQuery = "SELECT * FROM USERS WHERE USERNAME=?";
//        List<UserEntity> list = jdbcTemplate.query(userSQLQuery, new String[]{username},
//                (ResultSet rs, int rowNum) -> {
//
//                    UserEntity user = new UserEntity();
//                    user.setUsername(username);
//                    user.setPassword(rs.getString("PASSWORD"));
//                    return user;
//                });
        ArrayList<UserEntity> list = new ArrayList<>(16);
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword("123456");
        list.add(user);

        if (list.size() > 0) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
            grantedAuthoritiesList.add(grantedAuthority);
            list.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
            return list.get(0);
        }
        return null;
    }
} 
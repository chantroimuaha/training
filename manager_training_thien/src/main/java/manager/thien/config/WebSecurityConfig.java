package manager.thien.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Dùng để cấu hình Spring Security
 * @author nguyenducthien
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/logout","/js/**","/css/**","/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll().defaultSuccessUrl("/listUsers")
                .and()
            .logout()
                .permitAll().logoutSuccessUrl("/home");
    }
    @Autowired
    DataSource ds;
    /**
     * Dùng để cấu hình cho Spring Security kiểm tra đăng nhập
     * @param auth AuthenticationManagerBuilder
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new Md5PasswordEncoder())
    	.usersByUsernameQuery("SELECT username, password ,'true' as enable FROM tbl_user WHERE username = ?")
    	.authoritiesByUsernameQuery("SELECT username, 'member' as authority  FROM tbl_user as authorities WHERE username = ?");
    	auth.inMemoryAuthentication().withUser("thien").password("thien").roles("admin");
    }
}

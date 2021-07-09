
package VingadoresDoYahoo.HoraMarcada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.core.userdetails.*;

import VingadoresDoYahoo.HoraMarcada.repositories.ConsumidorRepository;
import VingadoresDoYahoo.HoraMarcada.services.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*    
    @Autowired
    private SSUserDetailsService userDetailsService;
    */

    @Autowired
    private ConsumidorRepository consumidorRepository;

    /*
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(consumidorRepository);
    }
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/consumidores/novo").permitAll()
            .antMatchers(HttpMethod.POST, "/consumidores").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/lista").hasAuthority("ADMIN")
            .antMatchers("consumidorForm").hasAnyAuthority("CONSUMIDOR","ADMIN")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/", true).
            and().
            logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
        .withUser("admin@teste").password(passwordEncoder().encode("password")).authorities("ADMIN")
        .and()
        .withUser("consumidor@teste").password(passwordEncoder().encode("password")).authorities("CONSUMIDOR");
        auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
    }

}
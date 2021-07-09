/*package VingadoresDoYahoo.HoraMarcada.services;

import VingadoresDoYahoo.HoraMarcada.models.*;
import VingadoresDoYahoo.HoraMarcada.repositories.ConsumidorRepository;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService{
    
    private ConsumidorRepository consumidorRepository;

    public SSUserDetailsService(ConsumidorRepository consumidorRepository){
        this.consumidorRepository = consumidorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Consumidor consumidor = ConsumidorRepository.findByEmail(email);
            if(email==null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(consumidor.getUsuario().getEmail(), consumidor.getUsuario().getSenha(), getAuthories(consumidor));
        } 
        
        catch (Exception e) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
    }

   
    private Set<GrantedAuthority> getAuthories(Consumidor consumidor){
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority grantedAuthorities = new SimpleGrantedAuthority(role.getRole());
        authorities.add(grantedAuthorities);
        }
        return authorities;
    }
    
}
*/
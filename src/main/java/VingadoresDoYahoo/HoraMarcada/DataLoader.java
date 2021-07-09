package VingadoresDoYahoo.HoraMarcada;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import VingadoresDoYahoo.HoraMarcada.repositories.*;
import VingadoresDoYahoo.HoraMarcada.models.Consumidor;
import VingadoresDoYahoo.HoraMarcada.models.Usuario;
//import VingadoresDoYahoo.HoraMarcada.models.RoleType;

public class DataLoader implements CommandLineRunner{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception{
        //roleRepository.save(new RoleType("CONSUMIDOR"));
        //roleRepository.save(new Role("PSERVICOS"));
        //roleRepository.save(new Role("ADMIN"));

        //Role consumidorRole = roleRepository.findByRole("CONSUMIDOR");
        //Role pservicosRole = roleRepository.findByRole("PSERVICOS");
        //Role adminRole = roleRepository.findByRole("ADMIN");



        //Consumidor consumidor = new Consumidor(new Usuario("Marcelo", "marceloteste@teste", passwordEncoder.encode("password"), "11944951703"));
        //consumidor.setRoles(Arrays.asList(adminRole));

        //consumidor = new Consumidor("consumidor", "consumidorteste@teste", passwordEncoder.encode("password"), "11944951703");
        //consumidor.setRoles(Arrays.asList(consumidorRole));
    }

}
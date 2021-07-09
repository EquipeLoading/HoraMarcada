package VingadoresDoYahoo.HoraMarcada.repositories;

import org.springframework.data.repository.CrudRepository;
import VingadoresDoYahoo.HoraMarcada.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    static Usuario findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }
}
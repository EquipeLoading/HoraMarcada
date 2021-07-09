package VingadoresDoYahoo.HoraMarcada.repositories;

import org.springframework.data.repository.CrudRepository;
import VingadoresDoYahoo.HoraMarcada.models.Consumidor;

public interface ConsumidorRepository extends CrudRepository<Consumidor,Long>{
    public static Consumidor findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }
}
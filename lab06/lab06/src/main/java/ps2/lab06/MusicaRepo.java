package ps2.lab06;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MusicaRepo extends CrudRepository<Musica, Long> {
    List<Musica> findByTitulo(String titulo);
}

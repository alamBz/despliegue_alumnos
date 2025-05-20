package prueba.curso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.curso.modelo.Modelo;

@Repository                                      //Obtenemos metodos CRUD
public interface IRepositorio extends JpaRepository<Modelo, Integer> {
}

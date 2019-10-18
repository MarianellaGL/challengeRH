package ar.com.ada.challengerh.challengerh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.challengerh.challengerh.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Categoria findByCategoriaId(int categoriaId);

}
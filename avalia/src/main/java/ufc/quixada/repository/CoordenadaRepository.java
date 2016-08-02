package ufc.quixada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufc.quixada.model.Coordenada;

@Repository
public interface CoordenadaRepository extends JpaRepository<Coordenada, Integer>{

}

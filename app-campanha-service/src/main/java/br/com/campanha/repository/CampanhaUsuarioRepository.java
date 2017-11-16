package br.com.campanha.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.campanha.model.CampanhaUsuario;

@Repository
public interface CampanhaUsuarioRepository extends JpaRepository<CampanhaUsuario, Long> {
    
	@Query("select count(c) from CampanhaUsuario c where c.idUsuario=:idUsuario")
	Long isCampanhaUsuario(@Param("idUsuario") Long idUsuario);
	
}

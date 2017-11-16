package br.com.campanha.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.campanha.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
    
	
	@Query("select c from Campanha c where c.dataFimVigencia=:dataFimVigencia")
	List<Campanha> buscarAtivasParaPeriodo(@Param("dataFimVigencia") LocalDate dataFimVigencia);

	@Query("select c from Campanha c")
	List<Campanha>  buscarTodas();
	
	@Query("select c from Campanha c where c.dataFimVigencia>=:dataAtual")
	List<Campanha>  buscarAtivas(@Param("dataAtual") LocalDate dataAtual);
	
	@Query("select c from Campanha c where c.idTime=:id")
	List<Campanha> buscarPorTime(@Param("id") Long id);
	 
	@Query(value="select c from Campanha c left join c.campanhasUsuario u  where c.idTime=:idTime and c.dataFimVigencia >=:dataAtual and not u.idUsuario=:idUsuario or u.idUsuario is null")
	List<Campanha> buscarSemAssociacaoUsuario(@Param("idUsuario") Long idUsuario,@Param("idTime") Long idTime, @Param("dataAtual") LocalDate dataAtual);
	
}

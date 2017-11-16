package br.com.campanha.mock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.campanha.model.Campanha;

@Component
public class CampanhaMock {
    
	
	public static Campanha getCampanha() {
		Campanha campanha = new Campanha();
		campanha.setNome("Campanha 1");
		campanha.setIdTime(1l);
		campanha.setDataInicioVigencia(LocalDate.of(2016, 01, 01));
		campanha.setDataFimVigencia(LocalDate.of(2017, 12, 01));
		
		return campanha;
	}
	

	public static Campanha getCampanhaSalva() {
		Campanha campanha = new Campanha();
		campanha.setId(1l);
		campanha.setNome("Campanha 1");
		campanha.setIdTime(1l);
		campanha.setDataInicioVigencia(LocalDate.of(2016, 01, 01));
		campanha.setDataFimVigencia(LocalDate.of(2017, 12, 01));
		
	 return campanha;
	
	}
	
	public static Campanha getCampanhaAtualizada() {
		Campanha campanha = new Campanha();
		campanha.setId(1l);
		campanha.setNome("Campanha 1 Atualizada");
		campanha.setIdTime(2l);
		campanha.setDataInicioVigencia(LocalDate.of(2016, 01, 01));
		campanha.setDataFimVigencia(LocalDate.of(2017, 12, 01));

		return campanha;
	}

	
	public static List<Campanha> getListaCampanhaNaoAssociadaAoUsuario() {
		Campanha campanha1 = new Campanha();
		campanha1.setId(1l);
		campanha1.setNome("Campanha 1");
		campanha1.setIdTime(2l);
		campanha1.setDataInicioVigencia(LocalDate.of(2016, 01, 01));
		campanha1.setDataFimVigencia(LocalDate.of(2017, 12, 01));
		
		Campanha campanha2 = new Campanha();
		campanha2.setId(1l);
		campanha2.setNome("Campanha 1");
		campanha2.setIdTime(2l);
		campanha2.setDataInicioVigencia(LocalDate.of(2016, 01, 01));
		campanha2.setDataFimVigencia(LocalDate.of(2017, 12, 01));
		
		
		Campanha campanha3 = new Campanha();
		campanha3.setId(1l);
		campanha3.setNome("Campanha 1");
		campanha3.setIdTime(2l);
		campanha3.setDataInicioVigencia(LocalDate.of(2016, 01, 01));
		campanha3.setDataFimVigencia(LocalDate.of(2017, 12, 01));
		
		
	 return Arrays.asList(campanha1,campanha2,campanha3);
	
	}
}

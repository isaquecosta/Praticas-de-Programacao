package br.cesed.exemplo1;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data@Entity
public class Banco {
	
	@Id
	private int cnpj;
	
	private String nomeBanco;
	
	
	

}

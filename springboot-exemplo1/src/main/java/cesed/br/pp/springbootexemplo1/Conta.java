package cesed.br.pp.springbootexemplo1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data 
public class Conta {

	@Id
	private int numConta;

	@Column(length = 50)
	private String titular;
	
	@Column(unique = true)
	private long cpf;
	
	private int agencia;
	
	private double saldo;
	
	
	

}

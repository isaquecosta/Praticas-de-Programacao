package br.cesed.exemplo1;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity
public class Conta {
	
	private int numeroAgencia;
	
	@Id
	private int numeroConta;
	
	private String titular;
	
	private double saldo;

}

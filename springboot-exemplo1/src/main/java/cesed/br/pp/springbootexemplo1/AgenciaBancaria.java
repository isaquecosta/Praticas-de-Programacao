package cesed.br.pp.springbootexemplo1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity @Data
public class AgenciaBancaria {

	 	@Column(name="nomeagencia")
		private String nomeAgencia;
		
		@Id
		private int numAgencia;

		
}

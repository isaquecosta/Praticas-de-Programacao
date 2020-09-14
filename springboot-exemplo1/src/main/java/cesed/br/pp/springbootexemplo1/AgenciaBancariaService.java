package cesed.br.pp.springbootexemplo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service@Validated
public class AgenciaBancariaService {

	@Autowired
	private AgenciaBancariaRepository repository;
	
	public List<AgenciaBancaria> getAgencias() {
		return (List<AgenciaBancaria>) repository.findAll();
	}

	public Optional<AgenciaBancaria> getAgencia(int id) {
		return repository.findById(id);
	}

	public void deleteAgenciaId(int id) {
		repository.deleteById(id);
	}

	public AgenciaBancaria postAgencia(AgenciaBancaria agencia) {
		return repository.save(agencia);
	}

	public void putAgencia(int id, AgenciaBancaria newAgencia) {
		this.getAgencia(id).get().setNomeAgencia(newAgencia.getNomeAgencia());
		this.getAgencia(id).get().setNumAgencia(newAgencia.getNumAgencia());
		
	}

}

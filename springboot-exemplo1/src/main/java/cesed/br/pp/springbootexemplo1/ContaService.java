package cesed.br.pp.springbootexemplo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public List<Conta> getContas() {
		return (List<Conta>) repository.findAll();
	}

	public Optional<Conta> getConta(int id) {

		return repository.findById(id);
	}

	public void deleteContaId(int id) {
		repository.deleteById(id);
	}

	public Conta postConta(Conta conta) {
		return repository.save(conta);
	}

	public void putConta(int id, Conta newConta) {
		this.getConta(id).get().setCpf(newConta.getCpf());
		this.getConta(id).get().setAgencia(newConta.getAgencia());
		this.getConta(id).get().setNumConta(newConta.getNumConta());
		this.getConta(id).get().setTitular(newConta.getTitular());
		this.getConta(id).get().setSaldo(newConta.getSaldo());
	}

}

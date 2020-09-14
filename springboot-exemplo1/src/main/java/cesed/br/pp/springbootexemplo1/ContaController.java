package cesed.br.pp.springbootexemplo1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContaController {

	@Autowired
	private ContaService service;

	@PostMapping("/conta")
	public ResponseEntity<Conta> criarConta(@RequestBody Conta novaConta) {

		try {
			Conta contaNova = service.postConta(novaConta);
			return new ResponseEntity<Conta>(contaNova, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Conta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/conta/{id}")
	public ResponseEntity<Conta> buscarConta(@PathVariable int id) {

		Optional<Conta> conta = service.getConta(id);

		if (conta == null) {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Conta>(HttpStatus.OK);
		}
	}

	@GetMapping("/conta")
	public ResponseEntity<List<Conta>> listarContas() {
		List<Conta> contas = service.getContas();
		return new ResponseEntity<List<Conta>>(contas,HttpStatus.OK);
	}

	@DeleteMapping("/conta/{id}")
	public ResponseEntity<Conta> deleteConta(@PathVariable int id) {
		service.deleteContaId(id);
		Optional<Conta> cont = service.getConta(id);
		if (cont.isEmpty()) {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Conta>(HttpStatus.OK);
		}
	}

	@PutMapping("/conta/{id}")
	private ResponseEntity<Conta> alterarConta(@PathVariable int id, @RequestBody Conta novaConta) {
		service.putConta(id, novaConta);
		Optional<Conta> cont = service.getConta(id);
		if (cont.isEmpty()) {
			return new ResponseEntity<Conta>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Conta>(HttpStatus.OK);
		}
	}
}

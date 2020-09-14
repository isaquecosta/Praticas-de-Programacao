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
public class AgenciaBancariaController {

	@Autowired
	private AgenciaBancariaService service;

	@PostMapping("/agencia")
	public ResponseEntity<AgenciaBancaria> criarAgencia(@RequestBody AgenciaBancaria novaAgencia) {

		try {
			AgenciaBancaria agenciaNova = service.postAgencia(novaAgencia);
			return new ResponseEntity<AgenciaBancaria>(agenciaNova, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/agencia/{id}")
	public ResponseEntity<AgenciaBancaria> buscarAgencia(@PathVariable int id) {

		Optional<AgenciaBancaria> agencia = service.getAgencia(id);

		if (agencia == null) {
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.OK);
		}
	}

	@GetMapping("/conta")
	public ResponseEntity<List<AgenciaBancaria>> listarAgencias() {
		List<AgenciaBancaria> agencias = service.getAgencias();
		return new ResponseEntity<List<AgenciaBancaria>>(agencias,HttpStatus.OK);
	}

	@DeleteMapping("/conta/{id}")
	public ResponseEntity<AgenciaBancaria> deleteAgencia(@PathVariable int id) {
		service.deleteAgenciaId(id);
		Optional<AgenciaBancaria> cont = service.getAgencia(id);
		if (cont.isEmpty()) {
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.OK);
		}
	}

	@PutMapping("/agencia/{id}")
	private ResponseEntity<AgenciaBancaria> alterarAgencia(@PathVariable int id, @RequestBody AgenciaBancaria novaAgencia) {
		service.putAgencia(id, novaAgencia);
		Optional<AgenciaBancaria> ag = service.getAgencia(id);
		if (ag.isEmpty()) {
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<AgenciaBancaria>(HttpStatus.OK);
		}
	}
}

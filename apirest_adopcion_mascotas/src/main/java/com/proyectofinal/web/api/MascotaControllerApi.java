package com.proyectofinal.web.api;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyectofinal.data.MascotaRepository;
import com.proyectofinal.model.Mascota;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")
public class MascotaControllerApi {

	@Autowired
	private MascotaRepository mascotaRepo;
	
	@GetMapping("/mascota/{id}")
	public ResponseEntity<Mascota> mascotaById(@PathVariable("id") Long id) {
		Optional<Mascota> optMascota = mascotaRepo.findById(id);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(path="/mascota", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota postMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}
	
	@PutMapping("/mascota")
	public Mascota updateMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}
	
	@GetMapping("/mascota")
	public Iterable<Mascota> allMascotas(){
		return mascotaRepo.findAll();
	}
	
	@GetMapping("/mascota/recents/{pag}/{qtty}")
	public Iterable<Mascota> recentMascotas(@PathVariable("pag") int pag, @PathVariable("qtty") int qtty){
		PageRequest page = PageRequest.of(pag, qtty, Sort.by("nacimiento").descending());
		return mascotaRepo.findAll(page);
	}
	
	@GetMapping("/mascota/pag/{pag}")
	public Iterable<Mascota> mascotasByPage(@PathVariable("pag") int pag) {
		PageRequest page = PageRequest.of(pag, 5, Sort.by("nacimiento").descending());
		return mascotaRepo.findAll(page);
	}
	
	@DeleteMapping("/mascota/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMascota(@PathVariable("id") Long id) {
		mascotaRepo.deleteById(id);
	}
	
	@GetMapping("/mascota/nombre/{nombre}")
	public ResponseEntity<Mascota> findMascotaByNombre(@PathVariable("nombre") String nombre) {
		Optional<Mascota> optMascota = mascotaRepo.findMascotaByNombre(nombre);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
 
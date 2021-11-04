package com.empresa.AppTurismo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.empresa.AppTurismo.models.entity.Paises;
import com.empresa.AppTurismo.models.services.IPaisService;
import com.empresa.AppTurismo.models.services.SequenceGeneratorService;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost"})
@RestController
@RequestMapping("/api")
public class PaisRestController {
	@Autowired
	private IPaisService paisService;
	@Autowired
	private SequenceGeneratorService service;
	@GetMapping("/paises")
	public List<Paises> index(){
		return paisService.findAll();
	}
	@GetMapping("/paises/{id}")
	public Optional<Paises> show(@PathVariable Long id) {
		return paisService.findById(id);
	}
	@PostMapping("/paises")
	@ResponseStatus(HttpStatus.CREATED)
	public Paises create(@RequestBody Paises pais) {
		pais.setId_pais((long) service.getSequenceNumber(Paises.SEQUENCE_NAME));
		return paisService.save(pais);
	}
	@PutMapping("/paises/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Paises update(@RequestBody Paises pais,@PathVariable Long id) {
		Optional<Paises> sitioActual = paisService.findById(id);
		Paises sitioValues=sitioActual.get();
		sitioValues.setNombre_pais(pais.getNombre_pais());
		return paisService.save(sitioValues);
	}
	@DeleteMapping("/paises/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		paisService.delete(id);
	}
}
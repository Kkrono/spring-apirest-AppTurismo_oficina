package com.empresa.AppTurismo.controllers;

import java.util.List;

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

import com.empresa.AppTurismo.models.entity.Sitios;
import com.empresa.AppTurismo.models.services.SequenceGeneratorService;
import com.empresa.AppTurismo.models.services.sitios.ISitioService;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost"})
@RestController
@RequestMapping("/api")
public class SitioRestController {
	@Autowired
	private ISitioService sitioService;
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/sitio")
	public List<Sitios> index(){
		return sitioService.getAll();
	}
	@GetMapping("/sitio/{id}")
	public Sitios show(@PathVariable Long id) {
		return sitioService.get(id);
	}
	
	@PostMapping("/sitio")
	@ResponseStatus(HttpStatus.CREATED)
	public Sitios create(@RequestBody Sitios sitios) {
		sitioService.verificarRegionExiste(sitios);
		sitios.setId_sit((long) service.getSequenceNumber(Sitios.SEQUENCE_NAME));
		return sitioService.save(sitios);
	}

	@PutMapping("/sitio/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Sitios update(@RequestBody Sitios sitios,@PathVariable Long id) {
		Sitios sitioActual = sitioService.get(id);
		Sitios sitioValues=sitioActual;
		sitioValues.setNombre_sit(sitios.getNombre_sit());
		sitioService.verificarRegionExiste(sitios);
		sitioValues.setId_reg_fk(sitios.getId_reg_fk());
		sitioValues.setDescripcion_sit(sitios.getDescripcion_sit());
		sitioValues.setImagen_sit(sitios.getImagen_sit());
		return sitioService.save(sitioValues);
	}
	
	@DeleteMapping("/sitio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		sitioService.delete(id);
	}
}
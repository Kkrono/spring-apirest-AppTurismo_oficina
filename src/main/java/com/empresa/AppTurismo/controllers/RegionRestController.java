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

import com.empresa.AppTurismo.models.entity.Regiones;
import com.empresa.AppTurismo.models.services.SequenceGeneratorService;
import com.empresa.AppTurismo.models.services.regiones.IRegionService;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost"})
@RestController
@RequestMapping("/api")
public class RegionRestController {
	@Autowired
	private IRegionService regionService;
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/region")
	public List<Regiones> index(){
		return regionService.getAll();
	}
	@GetMapping("/region/{id}")
	public Regiones show(@PathVariable String id) {
		return regionService.get(id);
	}
	
	@PostMapping("/region")
	@ResponseStatus(HttpStatus.CREATED)
	public Regiones create(@RequestBody Regiones regiones) {
		regionService.verificarDepExiste(regiones);
		regiones.setId_reg(service.getSequenceNumber(Regiones.SEQUENCE_NAME));
		return regionService.save(regiones);
	}

	@PutMapping("/region/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Regiones update(@RequestBody Regiones regiones,@PathVariable String id) {
		Regiones sitioActual = regionService.get(id);
		Regiones sitioValues=sitioActual;
		sitioValues.setNombre_reg(regiones.getNombre_reg());
		regionService.verificarDepExiste(regiones);
		sitioValues.setDep(regiones.getDep());
		return regionService.save(sitioValues);
	}
	
	@DeleteMapping("/region/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		regionService.delete(id);
	}
}
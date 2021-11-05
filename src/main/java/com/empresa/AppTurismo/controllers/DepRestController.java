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

import com.empresa.AppTurismo.models.entity.Departamentos;
import com.empresa.AppTurismo.models.services.SequenceGeneratorService;
import com.empresa.AppTurismo.models.services.departamento.IDepService;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost"})
@RestController
@RequestMapping("/api")
public class DepRestController {
	@Autowired
	private IDepService depService;
	@Autowired

	private SequenceGeneratorService service;
	@GetMapping("/dpto")
	public List<Departamentos> index(){
		return depService.getAll();
	}
	@GetMapping("/dpto/{id}")
	public Departamentos show(@PathVariable Long id) {
		return depService.get(id);
	}
	
	@PostMapping("/dpto")
	@ResponseStatus(HttpStatus.CREATED)
	public Departamentos create(@RequestBody Departamentos dep) {
		depService.verificarPaisExiste(dep);
		dep.setId_dep((long) service.getSequenceNumber(Departamentos.SEQUENCE_NAME));
		return depService.save(dep);
	}

	@PutMapping("/dpto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Departamentos update(@RequestBody Departamentos dep,@PathVariable Long id) {
		Departamentos sitioActual = depService.get(id);
		Departamentos sitioValues=sitioActual;
		sitioValues.setNombre_dep(dep.getNombre_dep());
		return depService.save(sitioValues);
	}
	
	@DeleteMapping("/dpto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		depService.delete(id);
	}
}
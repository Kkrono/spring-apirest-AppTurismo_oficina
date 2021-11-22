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

import com.empresa.AppTurismo.models.entity.ComidasTipicas;
import com.empresa.AppTurismo.models.services.SequenceGeneratorService;
import com.empresa.AppTurismo.models.services.comidastipicas.IComidasTipicasService;


@CrossOrigin(origins = {"http://localhost:4200","http://localhost"})
@RestController
@RequestMapping("/api")
public class ComidasTipicasRestController {
	@Autowired
	IComidasTipicasService comidasTipicasService;
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/comidas_tipicas")
	public List<ComidasTipicas> index(){
		return comidasTipicasService.getAll();
	}
	@GetMapping("/comidas_tipicas/{id}")
	public ComidasTipicas show(@PathVariable String id) {
		return comidasTipicasService.get(id);
	}
	
	@PostMapping("/comidas_tipicas")
	@ResponseStatus(HttpStatus.CREATED)
	public ComidasTipicas create(@RequestBody ComidasTipicas comidas_tipicas) {
		comidasTipicasService.verificarSitiosExiste(comidas_tipicas);
		comidas_tipicas.setId_pla(service.getSequenceNumber(ComidasTipicas.SEQUENCE_NAME));
		return comidasTipicasService.save(comidas_tipicas);
	}

	@PutMapping("/comidas_tipicas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ComidasTipicas update(@RequestBody ComidasTipicas comidas_tipicas,@PathVariable String id) {
		ComidasTipicas sitioActual = comidasTipicasService.get(id);
		ComidasTipicas sitioValues=sitioActual;
		sitioValues.setNombre_pla(comidas_tipicas.getNombre_pla());
		
		comidasTipicasService.verificarSitiosExiste(comidas_tipicas);//guardar el resto de datos del JSON
		sitioValues.setSitio(comidas_tipicas.getSitio());
		sitioValues.setDescipcion_pla(comidas_tipicas.getDescipcion_pla());
		sitioActual.setImagen_pla(comidas_tipicas.getImagen_pla());
		
		return comidasTipicasService.save(sitioValues);
	}
	
	@DeleteMapping("/comidas_tipicas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		comidasTipicasService.delete(id);
	}
}
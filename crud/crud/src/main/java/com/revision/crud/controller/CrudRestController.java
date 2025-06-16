package com.revision.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revision.crud.dao.CrudDao;
import com.revision.crud.entity.AnimeDtls;
import com.revision.crud.exception.AnimeNotFoundException;
import com.revision.crud.service.CrudService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class CrudRestController {
	
	CrudDao crudDao;
	ObjectMapper objectMapper;
	CrudService crudService;
	
	@Autowired
	public CrudRestController(CrudDao crudDao, ObjectMapper objectMapper, CrudService crudService) {
		super();
		this.crudDao = crudDao;
		this.objectMapper = objectMapper;
		this.crudService = crudService;
	}
	
	@PostConstruct
	public void postConstruct()
	{
		System.out.println("Called only once post bean is created.");
	}

	@GetMapping("/start")
	public String startTest()
	{
		return "Started";
	}
	
	@PostMapping("/create")
	public String insertAnimeDtls(@RequestBody AnimeDtls animeDtls)
	{
		try {
			crudDao.saveAnimeDtls(animeDtls);
		}
		catch(Exception e)
		{
			return "Save not successful : " + e.getMessage();
		}
		return "Save Successful";
	}
	
	@GetMapping("/all")
	public List<AnimeDtls> getAllAnimeDtls()
	{
//		return crudDao.getAllAnimeDtls();
		return crudService.findAll();
	}
	
	@GetMapping("/particular/{id}")
	public AnimeDtls getAnimeDtlsById(@PathVariable int id)
	{
		try {
			return crudDao.getAnimeById(id);
		}
		catch(Exception e)
		{
			throw new AnimeNotFoundException("Anime id not found : " + id);
		}
	}
	
	@PutMapping("/update")
	public AnimeDtls update(@RequestBody AnimeDtls payload)
	{
		AnimeDtls oldDtls = getAnimeDtlsById(payload.getId());
		if(oldDtls==null)
			throw new AnimeNotFoundException("Anime id not found : " + payload.getId());
		try {
			return crudService.updateAnimeDtls(payload);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Not able to update anime details witn id : " + payload.getId());
		}
	}
	
	@PatchMapping("/partialupdate/{id}")
	public AnimeDtls partialUpdateAnimeDtls(@PathVariable int id, @RequestBody Map<String,Object> patchPayload)
	{
		AnimeDtls oldDtls = getAnimeDtlsById(id);
		if(oldDtls==null)
		{
			throw new AnimeNotFoundException("Anime id not found : " + id);
		}
		if(patchPayload.containsKey("id"))
		{
			throw new RuntimeException("Employee Id not allowed in request body : " + id);
		}
		
		AnimeDtls updatedPayload = transformPayload(patchPayload, oldDtls);
		return crudService.updateAnimeDtls(updatedPayload);
	}

	private AnimeDtls transformPayload(Map<String, Object> patchPayload, AnimeDtls oldDtls) {
		ObjectNode animeNode = objectMapper.convertValue(oldDtls, ObjectNode.class);
		ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
		
		animeNode.setAll(patchNode);
		
		return objectMapper.convertValue(animeNode, AnimeDtls.class);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAnimeById(@PathVariable int id)
	{
		AnimeDtls anime = getAnimeDtlsById(id);
		if(anime==null)
		{
			throw new AnimeNotFoundException("Anime id not found : " + id);
		}
		
		try {
			crudService.deleteAnimeById(anime);
			return "Delete Successfull!";
		}
		catch(Exception e)
		{
			throw new RuntimeException("Delete unsuccessfull for anime id : " + id);
		}
		
	}
	
	
//	@ExceptionHandler
//	public ResponseEntity<AnimeErrorResponse> handleException(AnimeNotFoundException ex)
//	{
//		AnimeErrorResponse error = new AnimeErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setTimestamp(System.currentTimeMillis());
//		error.setMessage(ex.getMessage());
//		
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//		
//	}
//	
//	// To catch any exception
//	
//	@ExceptionHandler
//	public ResponseEntity<AnimeErrorResponse> handleException(Exception ex)
//	{
//		AnimeErrorResponse error = new AnimeErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(ex.getMessage());
//		error.setTimestamp(System.currentTimeMillis());
//		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//	}
	
}

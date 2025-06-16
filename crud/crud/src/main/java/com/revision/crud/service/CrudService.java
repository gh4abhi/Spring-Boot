package com.revision.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revision.crud.dao.CrudDao;
import com.revision.crud.entity.AnimeDtls;
import com.revision.crud.jparepository.CrudJpaRepository;

@Service
public class CrudService {
	CrudDao crudDao;
	CrudJpaRepository crudJpaRepository;
	
	@Autowired
	public CrudService(CrudDao crudDao, CrudJpaRepository crudJpaRepository)
	{
		this.crudDao = crudDao;
		this.crudJpaRepository = crudJpaRepository;
	}
	
	public List<AnimeDtls> findAll()
	{
		List<AnimeDtls> result = crudJpaRepository.findAll();
		return result;
	}
	
	@Transactional
	public AnimeDtls updateAnimeDtls(AnimeDtls updatedAnime)
	{
		return crudDao.updateAnimeDtls(updatedAnime);
	}
	
	@Transactional
	public void deleteAnimeById(AnimeDtls anime)
	{
		crudDao.deleteAnimeById(anime);
	}
	
}

package com.revision.crud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revision.crud.entity.AnimeDtls;
import com.revision.crud.repository.CrudRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CrudDao implements CrudRepository {

	EntityManager entityManager;

	@Autowired
	public CrudDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void saveAnimeDtls(AnimeDtls animeDtls) {
		entityManager.persist(animeDtls);
	}

	@Override
	public List<AnimeDtls> getAllAnimeDtls() {
		TypedQuery<AnimeDtls> custQuery = entityManager.createQuery("From AnimeDtls a order by a.id", AnimeDtls.class);
		return custQuery.getResultList();
	}

	@Override
	public AnimeDtls getAnimeById(int id) {
		TypedQuery<AnimeDtls> custQuery = entityManager.createQuery("From AnimeDtls a where a.id = :id",
				AnimeDtls.class);
		custQuery.setParameter("id", id);
		return custQuery.getSingleResult();
	}

	@Override
	public AnimeDtls updateAnimeDtls(AnimeDtls updatedAnime) {
		AnimeDtls newAnime = entityManager.merge(updatedAnime);
		return newAnime;
	}

	@Override
	public void deleteAnimeById(AnimeDtls anime) {
		entityManager.remove(anime);
	}

}

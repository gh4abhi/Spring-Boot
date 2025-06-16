package com.revision.crud.repository;

import java.util.List;

import com.revision.crud.entity.AnimeDtls;

public interface CrudRepository {
	void saveAnimeDtls(AnimeDtls animeDtls);
	List<AnimeDtls> getAllAnimeDtls();
	AnimeDtls getAnimeById(int id);
	AnimeDtls updateAnimeDtls(AnimeDtls updatedAnime);
	void deleteAnimeById(AnimeDtls anime);
}

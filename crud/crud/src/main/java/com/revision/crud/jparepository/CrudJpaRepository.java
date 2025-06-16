package com.revision.crud.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revision.crud.entity.AnimeDtls;

public interface CrudJpaRepository extends JpaRepository<AnimeDtls, Integer>{

}

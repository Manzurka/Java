package com.manzuraz.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.manzuraz.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepo extends PagingAndSortingRepository<Ninja, Long>, CrudRepository<Ninja,Long> {
	List<Ninja> findAll();
	
	@Query("SELECT d.name, n.firstName, n.lastName FROM Ninja n JOIN n.dojo d")
	Page<Object[]> ninjaDojos(Pageable pageable);
	
}

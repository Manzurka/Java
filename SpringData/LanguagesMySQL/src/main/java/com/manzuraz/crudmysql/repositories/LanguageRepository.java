package com.manzuraz.crudmysql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manzuraz.crudmysql.models.Language;


@Repository
	public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language>findAll();
}

//	in case if we need custom methods:
//  interface CustomizedRepository {
//		List<Language>set(Long id, Language lang);
//	}
//
//	class CustomizedRepositoryImpl implements CustomizedRepository {
//
//		  public List<Language>set(Long id, Language lang);
//		
//		  }
//		}
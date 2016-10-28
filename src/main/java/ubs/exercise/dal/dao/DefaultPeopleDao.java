package ubs.exercise.dal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ubs.exercise.dal.PeopleRepository;
import ubs.exercise.dal.transformer.PeopleTransformer;
import ubs.exercise.service.domain.People;

@Component
public class DefaultPeopleDao implements PeopleDao {
	
	@Autowired
	private PeopleRepository repository;
	
	@Autowired
	private PeopleTransformer transformer;

	public void savePeople(List<People> people) {
		repository.save(transformer.transform(people));
	}
	
	public List<People> retrievePeople(){
		return transformer.transform(repository.findAll());
	}

}

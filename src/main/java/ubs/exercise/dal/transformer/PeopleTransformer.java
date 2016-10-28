package ubs.exercise.dal.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ubs.exercise.dal.domain.PeopleEntity;
import ubs.exercise.service.domain.People;

@Component
public class PeopleTransformer {

	public PeopleEntity transform(People people){
		PeopleEntity peopleEntity = new PeopleEntity();
		peopleEntity.setId(people.getId());
		peopleEntity.setFirstName(people.getFirstName());
		peopleEntity.setLastName(people.getLastName());
		peopleEntity.setPlaceOfBirth(people.getPlaceOfBirth());
		peopleEntity.setAge(people.getAge());
		peopleEntity.setProfession(people.getProfession());
		return peopleEntity;
	}
	
	public List<PeopleEntity> transform(List<People> people){
		List<PeopleEntity> peopleEntites = new ArrayList<>();
		for(People person : people){
			peopleEntites.add(transform(person));
		}
		return peopleEntites;
	}
	
	public List<People> transform(Iterable<PeopleEntity> peopleEntities){
		List<People> people = new ArrayList<>();
		for(PeopleEntity peopleEntity : peopleEntities){
			people.add(transform(peopleEntity));
		}
		return people;
	}
	
	public People transform(PeopleEntity peopleEntity){
		People people = new People();
		people.setId(peopleEntity.getId());
		people.setFirstName(peopleEntity.getFirstName());
		people.setLastName(peopleEntity.getLastName());
		people.setPlaceOfBirth(peopleEntity.getPlaceOfBirth());
		people.setAge(peopleEntity.getAge());
		people.setProfession(peopleEntity.getProfession());
		return people;
	}
	
}

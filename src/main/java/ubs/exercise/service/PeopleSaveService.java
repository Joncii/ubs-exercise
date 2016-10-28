package ubs.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ubs.exercise.dal.dao.PeopleDao;
import ubs.exercise.service.domain.People;
import ubs.exercise.service.domain.filter.Predicate;

@Service
public class PeopleSaveService {
	
	@Autowired
	private PeopleDao peopleDao;
	
	public void save(List<People> people){
		peopleDao.savePeople(people);
	}
	
	public void save(List<People> people, Predicate<People> filter){
		List<People> filteredPeople = new ArrayList<>();
		for(People person : people){
			if(filter.apply(person)){
				filteredPeople.add(person);
			}
		}
		peopleDao.savePeople(filteredPeople);
	}
	
}

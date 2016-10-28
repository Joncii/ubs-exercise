package ubs.exercise.dal.dao;

import java.util.List;

import ubs.exercise.service.domain.People;

public interface PeopleDao {

	void savePeople(List<People> people);
	
	List<People> retrievePeople();
	
}

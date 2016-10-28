package ubs.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ubs.exercise.dal.dao.PeopleDao;
import ubs.exercise.service.domain.People;

@Service
public class PeopleListService {

	@Autowired
	private PeopleDao peopleDao;
	
	public List<People> listAll(){
		return peopleDao.retrievePeople();
	}
}

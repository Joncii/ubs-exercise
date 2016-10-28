package ubs.exercise.dal;

import org.springframework.data.repository.CrudRepository;

import ubs.exercise.dal.domain.PeopleEntity;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Long>{

}

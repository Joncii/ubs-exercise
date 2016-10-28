package ubs.exercise.service;

import org.joda.time.LocalDateTime;
import org.joda.time.Years;
import org.springframework.stereotype.Service;

@Service
public class AgeConverterService {

	public Integer convert(LocalDateTime birthDate){
		LocalDateTime now = LocalDateTime.now();
		return Years.yearsBetween(birthDate, now).getYears();
	}
	
}

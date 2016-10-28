package ubs.exercise.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ubs.exercise.service.domain.People;

@Service
public class CSVPeopleReaderService {

	private static final Logger LOG = LoggerFactory.getLogger(CSVPeopleReaderService.class);
	private static final String CSV_PEOPLE_PATH_PROPERTY = "CSV.PEOPLE.PATH";
	private static final String PROPERTY_PATH = "people.properties";

	@Autowired
	private PropertyReaderService propertyReaderService;
	
	@Autowired
	private AgeConverterService ageConverterService;
	
	public List<People> parse(){
		Properties peopleProperties = propertyReaderService.read(PROPERTY_PATH);
		String peoplePath = peopleProperties.getProperty(CSV_PEOPLE_PATH_PROPERTY);
		List<People> people = new ArrayList<>();
		try {
			CSVParser parse = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(new FileReader(peoplePath));
			for(CSVRecord record : parse.getRecords()){
				People person = new People();
				person.setFirstName(record.get(0).trim());
				person.setLastName(record.get(1).trim());
				person.setAge(ageConverterService.convert(LocalDateTime.parse(record.get(2).trim(), DateTimeFormat.forPattern("YYYY.MM.dd"))));
				person.setPlaceOfBirth(record.get(3).trim());
				person.setProfession(record.get(4).trim());
				people.add(person);
			}
		} catch (IOException e) {
			LOG.error("Cannot read csv file. Embedded exception: " + e.getMessage());
		}
		return people;
	}

}

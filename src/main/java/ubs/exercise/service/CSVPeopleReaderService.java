package ubs.exercise.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ubs.exercise.service.domain.People;

@Service
public class CSVPeopleReaderService {

	private static final Logger LOG = LoggerFactory.getLogger(CSVPeopleReaderService.class);
	private static final String CSV_PEOPLE_PATH_PROPERTY = "CSV.PEOPLE.PATH";
	private static final String CSV_SPLIT_REGEX = "\\s*,\\s*";
	@Autowired
	private PropertyReaderService propertyReaderService;
	private List<People> people;
	
	public List<People> parse(){
		people = new ArrayList<>();
		Properties peopleProperties = propertyReaderService.read("people.properties");
		String peoplePath = peopleProperties.getProperty(CSV_PEOPLE_PATH_PROPERTY);
		if(peoplePath != null){
			try(BufferedReader csvReader = new BufferedReader(new FileReader(peoplePath))){
				String csvLine;
				int lineCount  = 0;
				while((csvLine = csvReader.readLine()) != null){
					lineCount++;
					readLine(csvLine, lineCount);
				}
			} catch (FileNotFoundException e) {
				LOG.error("Provided file ("+ peoplePath +") cannot be found.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			LOG.error("Property CSV.PEOPLE.PATH is not provided. Cannot parse CSV file.");			
		}
		return people;
	}
	
	private void readLine(String csvLine, int lineCount) {
		if(csvLine != null){
			String[] splitLine = csvLine.split(CSV_SPLIT_REGEX);
			if(splitLine.length < 5){
				LOG.warn("Line " + lineCount + " cannot be parsed.");
			} else {
				People person = new People();
				person.setFirstName(splitLine[0].trim());
				person.setLastName(splitLine[1].trim());
				person.setAge(Integer.valueOf(splitLine[2].trim()));
				person.setPlaceOfBirth(splitLine[3].trim());
				person.setProfession(splitLine[4].trim());
				people.add(person);
			}
		}
	}

}

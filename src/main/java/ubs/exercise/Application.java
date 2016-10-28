package ubs.exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ubs.exercise.config.DataBaseConfig;
import ubs.exercise.dal.dao.PeopleDao;
import ubs.exercise.service.CSVPeopleReaderService;
import ubs.exercise.service.PeopleSaveService;
import ubs.exercise.service.domain.People;
import ubs.exercise.service.domain.filter.Predicate;

/**
 * Hello world!
 *
 */
public class Application 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);

        Predicate<People> peopleFilter = new Predicate<People>() {
        	
        	@Override
        	public boolean apply(People element) {
        		return element.getAge() > 18 && element.getPlaceOfBirth().equalsIgnoreCase("Budapest") && element.getProfession().equalsIgnoreCase("programozó");
        	}
        };
        CSVPeopleReaderService csvPeopleReaderService = context.getBean(CSVPeopleReaderService.class);
        PeopleSaveService peopleSaveService = context.getBean(PeopleSaveService.class);
        peopleSaveService.save(csvPeopleReaderService.parse(), peopleFilter);
        PeopleDao peopleDao = context.getBean(PeopleDao.class);
        for(People people : peopleDao.retrievePeople()){
        	System.out.println(people.getId() + " " + people.getFirstName() + " " + people.getLastName() +  " " + people.getAge() + " " + people.getPlaceOfBirth() + " " + people.getProfession());
        }
        
        ((ConfigurableApplicationContext) context).close();
    }
}

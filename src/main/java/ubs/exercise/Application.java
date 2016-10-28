package ubs.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ubs.exercise.config.DataBaseConfig;
import ubs.exercise.service.CSVPeopleReaderService;
import ubs.exercise.service.PeopleListService;
import ubs.exercise.service.PeopleSaveService;
import ubs.exercise.service.domain.People;
import ubs.exercise.service.domain.filter.Predicate;

/**
 * Hello world!
 *
 */
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfig.class);

		Predicate<People> peopleFilter = new Predicate<People>() {

			@Override
			public boolean apply(People element) {
				return element.getAge() > 18 && element.getPlaceOfBirth().equalsIgnoreCase("Budapest")
						&& element.getProfession().equalsIgnoreCase("programozó");
			}
		};
		CSVPeopleReaderService csvPeopleReaderService = context.getBean(CSVPeopleReaderService.class);
		PeopleSaveService peopleSaveService = context.getBean(PeopleSaveService.class);
		peopleSaveService.save(csvPeopleReaderService.parse(), peopleFilter);
		PeopleListService peopleListService = context.getBean(PeopleListService.class);
		for (People people : peopleListService.listAll()) {
			LOG.info(people.getId() + " " + people.getFirstName() + " " + people.getLastName() + " " + people.getAge() + " "
					+ people.getPlaceOfBirth() + " " + people.getProfession());
		}
	}
}

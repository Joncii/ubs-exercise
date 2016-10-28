package ubs.exercise.dal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PEOPLE")
public class PeopleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "people_id_seq_gen")
	@SequenceGenerator(name = "people_id_seq_gen", sequenceName = "people_id_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "PLACE_OF_BIRTH")
	private String placeOfBirth;

	@Column(name = "PROFESSION")
	private String profession;

	
	public Long getId() {
		return id;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public Integer getAge() {
		return age;
	}

	
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	
	public String getProfession() {
		return profession;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public void setAge(Integer age) {
		this.age = age;
	}

	
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	
	public void setProfession(String profession) {
		this.profession = profession;
	}
}

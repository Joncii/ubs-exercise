package ubs.exercise.service.domain;

public class People {

	private Long id;

	private String firstName;

	private String lastName;

	private Integer age;

	private String placeOfBirth;

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

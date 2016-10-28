package ubs.exercise.service.domain.filter;


public interface Predicate<T> {
	
	boolean apply(T element);

}

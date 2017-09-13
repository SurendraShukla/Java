package org.fun.exercises;

import org.fun.movies.Movie;
import org.fun.movies.MovieClub;
import org.fun.movies.Person;
import org.fun.office.Employee;
import org.fun.office.Gender;
import org.fun.util.PrettyPrint;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsTest {
	private static Stream<Employee> employeeStream() {return Employee.getEmployees().stream();}


	@Test
	public void test1() {

		Function<Employee, LocalDate> getDateOfJoining = Employee::getDateOfJoining;
		Function<LocalDate, Month> localDateMonthFunction = e -> e.getMonth();
		Function<Employee, Month> employeeMonthFunction = getDateOfJoining.andThen(localDateMonthFunction);

		List<LocalDate> dateOfJoining = employeeStream()
				.map(getDateOfJoining)
				.collect(toList());
		PrettyPrint.list(dateOfJoining);

		PrettyPrint.list(employeeStream()
				.map(getDateOfJoining.andThen(localDateMonthFunction))
//				.map(employeeMonthFunction)
				.collect(Collectors.toList()));


	}

	@Test
	public void testNew() {
		 Employee.getEmployees().stream();
	}

	@Test
	public void filterTest() {

		Predicate<Employee> male = this::isMale;
		Predicate<Employee> aprilJoiners = joinedIn(Month.APRIL);

		Predicate<Employee> eligibleForAward = male.negate().and(aprilJoiners);

		System.out.println("\n\n");
	 	StreamsTest.employeeStream()
//			.filter(this::isMale)
//			.filter(withGender(Gender.MALE))
//			.filter(joinedIn(Month.APRIL))
			.forEach(System.out::println);

		System.out.println("\n\n");
		StreamsTest.employeeStream()
 			.filter(male.and(aprilJoiners))
				.forEach(System.out::println);

		System.out.println("\n\n");
		StreamsTest.employeeStream()
				.filter(eligibleForAward)
				.forEach(System.out::println);
	}

	private Predicate<Employee> joinedIn(Month month) {
		return e->e.getDateOfJoining().getMonth() == month;
	}

	private Predicate<? super Employee> withGender(Gender gender) {
		return e -> e.getGender() == gender;
	}

	private boolean isMale(Employee employee) {
		return employee.getGender() == Gender.MALE;
	}


	@Test
	public void sortTest() {
		employeeStream()
//				.sorted() 		// All collections doesn't implement comparable
//				.sorted((e1, e2) -> e1.getId() - e2.getId())
//				.sorted(Comparator.comparing(Employee::getId))
				.sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName).reversed())
				.forEach(System.out::println);
	}

	@Test
	public void flatMap() {

		Set<Person> gang = MovieClub.president().getFriendCircle();
		gang.forEach(System.out::println);

		MovieClub.gang().stream().forEach(System.out::println);

		MovieClub.gang().stream()
				.flatMap(e-> e.getMovies().stream())
				.distinct()
				.forEach(System.out::println);

		List<Movie> movieList = MovieClub.gang().stream()
				.flatMap(e -> e.getMovies().stream())
				.distinct()
				.collect(toList());

//		movieList.forEach(System.out::println);
		PrettyPrint.list(movieList);
	}

//	private Predicate<Employee>
//	http://stackoverflow.com/questions/3704804/how-to-sort-an-arraylist-using-multiple-sorting-criteria

}

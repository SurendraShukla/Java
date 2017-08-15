package org.fun.exercises;

import org.fun.office.Employee;
import org.fun.util.PrettyPrint;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Function;
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

//	private Predicate<Employee>
//	http://stackoverflow.com/questions/3704804/how-to-sort-an-arraylist-using-multiple-sorting-criteria

}

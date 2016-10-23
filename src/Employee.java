package mis;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mamgainv on 8/29/14.
 */
public class Employee {

	int id;
	String firstName;
	String lastName;
	Gender gender;
	LocalDate dateOfJoining;
	String workstationId;
	String team;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public String getWorkstationId() {
		return workstationId;
	}

	public String getTeam() {
		return team;
	}

	public Employee(int id, String firstName, String lastName, Gender gender, LocalDate dateOfJoining, String workstationId, String team) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.workstationId = workstationId;
		this.team = team;
	}

	public boolean isNeighbor(Employee e) {
		int ws1 = extractWsId(getWorkstationId());
		int ws2 = extractWsId(e.getWorkstationId());
		if (Math.abs(ws1 - ws2) == 1) return true;
		return false;
	}

	private int extractWsId(String ws) {
		return Integer.parseInt(ws.substring(3));
	}

	@Override
	public String toString() {
		return id + ": " + getFullName();
	}

	public String getYearsInADPText(){
		Period p = Period.between(dateOfJoining,LocalDate.now());
		return p.getYears() + "." + p.getMonths() + " years";
	}

	public double getYearsInADP(){
		Period p = Period.between(dateOfJoining,LocalDate.now());
		return p.getYears() + p.getMonths()/12d;
	}

	public String fullDetails() {
		return id +
				": " + firstName + ' ' + lastName +
				" (" + gender +
				"), JoinedOn: " + dateOfJoining +
				", WS: " + workstationId +
				", Team: " + team;
	}

	public static List<Employee> getEmployees() {
		List<Employee> members = new ArrayList<>();
		members.add(new Employee(203654, "Sachin", "Patade", Gender.MALE, LocalDate.of(2007, 4, 2), "1FE195", "i18n"));
		members.add(new Employee(249102, "Surendra", "Shukla", Gender.MALE, LocalDate.of(2011, 3, 14), "1FE225", "OOS"));
		members.add(new Employee(250327, "Ashish", "Chande", Gender.MALE, LocalDate.of(2011, 4, 25), "1FE215", "Channel"));
		members.add(new Employee(252836, "Rishikesh", "Dhokare", Gender.MALE, LocalDate.of(2011, 7, 18), "1FE241", "Infra"));
		members.add(new Employee(255022, "Gampeshwar", "Sahu", Gender.MALE, LocalDate.of(2011, 10, 3), "1FE226", "OOS"));
		members.add(new Employee(256212, "Kumar", "Rohit", Gender.MALE, LocalDate.of(2011, 10, 17), "1FE222", "Platform"));
		members.add(new Employee(258609, "Vishnu", "Gupta", Gender.MALE, LocalDate.of(2012, 1, 12), "1FE239", "Infra"));
		members.add(new Employee(266370, "Vijay", "Dey", Gender.MALE, LocalDate.of(2012, 5, 17), "1FE240", "Channel"));
		members.add(new Employee(267247, "Ashish", "Agarwal", Gender.MALE, LocalDate.of(2012, 6, 13), "1FE221", "i18n"));
		members.add(new Employee(269012, "Amresh", "Das", Gender.MALE, LocalDate.of(2012, 8, 6), "1FE223", "Platform"));
		members.add(new Employee(273430, "Prasad", "Shindikar", Gender.MALE, LocalDate.of(2012, 11, 12), "1FE246", "Channel"));
		members.add(new Employee(279648, "Prateek", "Singh", Gender.MALE, LocalDate.of(2013, 5, 6), "1FE244", "Infra"));
		members.add(new Employee(282235, "Sandeep", "Gondal", Gender.MALE, LocalDate.of(2013, 6, 20), "1FE242", "Platform"));
		members.add(new Employee(282378, "Tushar", "Pawar", Gender.MALE, LocalDate.of(2013, 6, 24), "1FE248", "Channel"));
		members.add(new Employee(284413, "Ashish", "Kumar", Gender.MALE, LocalDate.of(2013, 8, 12), "1FE249", "Platform"));
		members.add(new Employee(297122, "Gaurav", "Pasarkar", Gender.MALE, LocalDate.of(2014, 6, 16), "1FE218", "Infra"));
		members.add(new Employee(251693, "Deepti", "Ghan", Gender.FEMALE, LocalDate.of(2011, 6, 6), "1FE224", "Infra"));
		members.add(new Employee(252835, "Nivedita", "Lugade", Gender.FEMALE, LocalDate.of(2011, 7, 18), "1FE214", "i18n"));
		members.add(new Employee(293372, "Bhagyashree", "Bhagat", Gender.FEMALE, LocalDate.of(2014, 3, 10), "1FE250", "i18n"));
		members.add(new Employee(296502, "Rashmee", "Doshi", Gender.FEMALE, LocalDate.of(2014, 6, 2), "1FE243", "Channel"));
		members.add(new Employee(297909, "Amruta", "Dravid", Gender.FEMALE, LocalDate.of(2014, 6, 30), "1FE225", "AdOps"));
		members.add(new Employee(298097, "Supriya ", "Patil", Gender.FEMALE, LocalDate.of(2014, 7, 7), "1FE226", "i18n"));
		return members;
	}
	public static enum Gender {
		MALE, FEMALE;
	}

}

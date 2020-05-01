package me.surendra.design_patterns.Composite.organization;

import org.junit.Test;

public class Client
{
    @Test
    public void test()
    {
        Developer dev1 = new Developer(100, "Surendra Shukla", "Developer1");
        Developer dev2 = new Developer(101, "Suren Shukla", "Developer2");
        CompanyDirectory engDirectory = new CompanyDirectory();
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);

        Manager man1 = new Manager(200, "Todd Curie", "DASH Manager");
        Manager man2 = new Manager(201, "Osman ", "DAP Manager");

        CompanyDirectory accDirectory = new CompanyDirectory();
        accDirectory.addEmployee(man1);
        accDirectory.addEmployee(man2);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.showEmployeeDetails();
    }
}

package me.surendra.design_patterns.Factory.SimpleFactory.Course;

public class NetCourse extends AbstractCourse{
    @Override
    void createCourseMaterial() {
        System.out.println(".Net course material created");
    }

    @Override
    void createSchedule() {
        System.out.println(".Net course schedule created");
    }
}

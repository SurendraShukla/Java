package me.surendra.design_patterns.Factory.SimpleFactory.Course;

public class JavaCourse extends AbstractCourse {
    @Override
    void createCourseMaterial() {
        System.out.println("Java course material created");
    }

    @Override
    void createSchedule() {
        System.out.println("Java course schedule created");
    }
}

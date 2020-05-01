package me.surendra.design_patterns.Factory.SimpleFactory.Course;

public abstract class AbstractCourse {

    private int courseDuration;
    private String courseName;

    abstract void createCourseMaterial();
    abstract void createSchedule();

}

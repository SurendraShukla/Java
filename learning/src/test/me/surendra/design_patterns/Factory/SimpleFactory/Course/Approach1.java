package me.surendra.design_patterns.Factory.SimpleFactory.Course;

public class Approach1 {

    public static AbstractCourse createCourse(String scheduleType)
    {
        AbstractCourse objCourse = null;
        switch(scheduleType)
        {
            case "N":
                objCourse = new NetCourse();
                break;
            case "J":
                objCourse = new JavaCourse();
                break;
            //Add more case conditions here for VC++ and C++
        }
        objCourse.createCourseMaterial();
        objCourse.createSchedule();
        return objCourse;
    }

    public static void main(String[] args) {
        Approach1.createCourse("J");
    }

}

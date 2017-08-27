package suren.design_patterns.Factory.SimpleFactory.Course;

public class CourseFactory {

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
}

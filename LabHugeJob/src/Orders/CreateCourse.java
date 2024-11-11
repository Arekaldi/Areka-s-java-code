package Orders;

import Courses.Course;
import CoursesOperate.CourseCreateOperate;
import Functions.Function;
import UsersInfo.TeacherUser;

public class CreateCourse {
    public static void createCourse(String[] orderArgs) {
        double coursePrice = -1;
        int courseStudyTime = -1;
        if(Function.isNumber(orderArgs[2]))
            coursePrice = Double.parseDouble(orderArgs[2]);
        if(Function.isNumber(orderArgs[3]))
            courseStudyTime = Integer.parseInt(orderArgs[3]);
        Course course = new Course(new TeacherUser(), orderArgs[0], orderArgs[1], coursePrice, courseStudyTime);
        CourseCreateOperate.courseCreateCheck(course);
    }
}

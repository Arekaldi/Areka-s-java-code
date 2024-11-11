package UsersInfo;

import Courses.Course;
import Courses.CourseCreatedInfo;

import java.util.List;

public class TeacherUser extends User {
    private int teacherHasCourseNumber;
    public TeacherUser() {}
    public TeacherUser(User user) {
        super(user.userId, user.userName, user.userPassword, user.userConfirmPassword, user.userType);
        this.teacherHasCourseNumber = 0;
    }

    public TeacherUser(String userId, String userName, String userPassword, String userConfirmPassword, String userType) {
        super(userId, userName, userPassword, userConfirmPassword, userType);
        this.teacherHasCourseNumber = 0;
    }

    public TeacherUser(String[] userInfo, int teacherHasCourse) {
        super(userInfo);
        this.teacherHasCourseNumber = teacherHasCourse;
    }

    public void setTeacherHasCourseNumber(int teacherHasCourse) {
        this.teacherHasCourseNumber = teacherHasCourse;
    }

    public int getTeacherHasCourseNumber() {
        return teacherHasCourseNumber;
    }

    public boolean teacherHasCourseCheck() {
        return this.teacherHasCourseNumber < 10;
    }

    public List<Course> getTeacherHasCourse() {
        return CourseCreatedInfo.getCreatedCoursesByTeacher(this);
    }
}

package UsersInfo;

import Courses.Course;

import java.util.ArrayList;
import java.util.List;

public class StudentUser extends User {
    public StudentUser() {}
    public StudentUser(User user) {
        super(user.userId, user.userName, user.userPassword, user.userConfirmPassword, user.userType);
    }
    public StudentUser(String userId, String userName, String userPassword, String userConfirmPassword, String userType) {
        super(userId, userName, userPassword, userConfirmPassword, userType);
    }
    public StudentUser(String[] userInfo) {
        super(userInfo);
    }

    private List<Course> selectedCourses = new ArrayList<>();

    public List<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public boolean isSelectedCourse() {
        return !selectedCourses.isEmpty();
    }

    public List<Course> getSelectedCourseByTeacher(String teacherId) {
        List<Course> selectedCourseByTeacher = new ArrayList<>();
        for(Course course : selectedCourses) {
            if(course.getCourseCreator().getUserId().equals(teacherId)) {
                selectedCourseByTeacher.add(course);
            }
        }
        return selectedCourseByTeacher;
    }

    public void addSelectedCourse(Course course) {
        selectedCourses.add(course);
    }

    public void removeSelectedCourse(Course course) {
        selectedCourses.remove(course);
        return;
    }
    public void removeAllSelectedCourse() {
        selectedCourses.clear();
        return;
    }
    public int getUserIdPriority() {
        if(userId.charAt(0) == 'B')
            return 1;
        else if(userId.charAt(0) == 'S')
            return 2;
        else if(userId.charAt(0) == 'Z')
            return 3;
        else
            return 4;
    }
}

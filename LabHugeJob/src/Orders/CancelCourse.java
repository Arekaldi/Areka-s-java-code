package Orders;

import CoursesOperate.CourseCancelOperate;

public class CancelCourse {
    public static void cancelCourse(String[] orderArgs) {
        CourseCancelOperate.cancelCourseCheck(orderArgs[0]);
        return;
    }
}

package test.assignment.model;

public class CourseSchedule {

    public final static int MAX_STUDENTS_IN_A_COURSE_SCHEDULE = 4;
    public final static int TOTAL_WEEKENDS = 8;
    public enum DAYS {
        SATURDAY, SUNDAY;
    }

    int studentsEnrolled = 0;
    final int courseDuration = 60; // Minutes

    public int getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(int studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCourseDuration() {
        return courseDuration;
    }
}

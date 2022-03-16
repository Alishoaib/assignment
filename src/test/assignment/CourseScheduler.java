package test.assignment;

import test.assignment.model.Course;
import test.assignment.model.CourseSchedule;

import java.util.HashMap;
import java.util.Map;

import static test.assignment.model.CourseSchedule.TOTAL_WEEKENDS;

public class CourseScheduler {
    enum CourseName {
        YOGA,
        ZOMBA,
        AQUA_CISE,
        BOX_FIT,
        BODY_BLITZ
    }

    final Map<CourseName, Course[]> courses = new HashMap<>();

    public CourseScheduler() {
        for (CourseName courseName : CourseName.values()) {
            Course[] totalCourses = new Course[TOTAL_WEEKENDS];
            for (int i = 0; i < totalCourses.length; i++) {
                Course course = new Course();
                for (CourseSchedule.DAYS day: course.getDaysMap().keySet()) {
                    CourseSchedule[] courseDay = course.getDaysMap().get(day);
                    for (int j = 0; j < 3; j++) {
                        courseDay[j] = new CourseSchedule();
                    }
                }

                totalCourses[i] = course;
            }
            courses.put(courseName, totalCourses);
        }
    }

    public void EnrollStudent(Course course) {

    }

    public Course maxEarningCourse() {
        return null;
    }

    public void addRanking(Course course, int ranking) {

    }
}

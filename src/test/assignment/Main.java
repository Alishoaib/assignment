package test.assignment;

import static test.assignment.CourseScheduler.CourseName.*;

public class Main {
    public static void main(String[] args) {
        CourseScheduler courseScheduler = new CourseScheduler();

        // enroll 6 students ( 5 in BODY_BLITZ and 1 in AQUA_CISE)
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(AQUA_CISE);

        // 3 rankings
        courseScheduler.addRanking(BODY_BLITZ, 1, 5);
        courseScheduler.addRanking(BODY_BLITZ, 1, 2);
        courseScheduler.addRanking(AQUA_CISE, 1, 8);
        courseScheduler.addRanking(YOGA, 1, 10); // will not add this ranking, because no students enrolled in this course

        // max earning
        CourseScheduler.CourseName maxEarningCourse = courseScheduler.maxEarningCourse();
        System.out.println("Max Earning Course -> " + maxEarningCourse);

        // max ranked
        CourseScheduler.CourseName maxRankedCourse = courseScheduler.maxRankedCourse();
        System.out.println("Max Ranked Course -> " + maxRankedCourse);
    }
}

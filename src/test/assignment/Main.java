package test.assignment;

import java.util.Scanner;

import static test.assignment.CourseScheduler.CourseName.*;

public class Main {
    public static void main(String[] args) {
        CourseScheduler courseScheduler = new CourseScheduler();

        // enroll 6 students ( 5 in BODY_BLITZ and 1 in AQUA_CISE)
        /*courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(BODY_BLITZ);
        courseScheduler.enrollStudent(AQUA_CISE);*/

        // 3 rankings
       /* courseScheduler.addRanking(BODY_BLITZ, 1, 5);
        courseScheduler.addRanking(BODY_BLITZ, 1, 2);
        courseScheduler.addRanking(AQUA_CISE, 1, 8);
        courseScheduler.addRanking(YOGA, 1, 10);*/ // will not add this ranking, because no students enrolled in this course

        Scanner in = new Scanner(System.in);


        for (int i = 0; i < 5; i++) {
            int counter = 0;
            System.out.println("Plz select Course name to enroll student");
            for (CourseScheduler.CourseName courseName: CourseScheduler.CourseName.values()) {
                System.out.println(++counter+" "+courseName.name());

            }

            int courseNameIndex = in.nextInt();
            if (courseNameIndex > 0 && courseNameIndex <= values().length){
                courseScheduler.enrollStudent(CourseScheduler.CourseName.values()[courseNameIndex-1]);
                System.out.println("Student enrolled");
            }
        }

        for (int i = 0; i < 5; i++) {
            int counters = 0;
            System.out.println("Plz select Course name to rank");

            for (CourseScheduler.CourseName courseName: CourseScheduler.CourseName.values()) {
                System.out.println(++counters+" "+courseName.name());

            }

            int courseNameIndex = in.nextInt();
            System.out.println("Plz enter week no (1 to 8)");
            int weekNo = in.nextInt();
            System.out.println("Plz enter ranking");
            int rank = in.nextInt();
            if (courseNameIndex > 0 && courseNameIndex <= values().length){
                courseScheduler.addRanking(CourseScheduler.CourseName.values()[courseNameIndex-1], weekNo, rank);
                System.out.println("Ranking Added");
            }

        }



        // max earning
        CourseScheduler.CourseName maxEarningCourse = courseScheduler.maxEarningCourse();
        System.out.println("Max Earning Course -> " + maxEarningCourse);

        // max ranked
        CourseScheduler.CourseName maxRankedCourse = courseScheduler.maxRankedCourse();
        System.out.println("Max Ranked Course -> " + maxRankedCourse);
    }
}

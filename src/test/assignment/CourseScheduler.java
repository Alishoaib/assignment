package test.assignment;

import test.assignment.model.Course;
import test.assignment.model.CourseFee;
import test.assignment.model.CourseSchedule;
import test.assignment.model.Ranking;

import java.util.*;

import static test.assignment.model.CourseSchedule.MAX_STUDENTS_IN_A_COURSE_SCHEDULE;
import static test.assignment.model.CourseSchedule.TOTAL_WEEKENDS;

public class CourseScheduler {
    final Map<CourseName, Course[]> courses = new HashMap<>();

    public CourseScheduler() {
        for (CourseName courseName : CourseName.values()) {
            Course[] totalCourses = new Course[TOTAL_WEEKENDS];
            for (int i = 0; i < totalCourses.length; i++) {
                Course course = new Course();
                for (CourseSchedule.DAYS day : course.getDaysMap().keySet()) {
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

    public boolean enrollStudent(CourseName courseName) {
        // find all the schedules available for this course
        Course[] courseSchedules = courses.get(courseName);
        if (Objects.nonNull(courseSchedules)) {
            // iterate on all 8 weeks
            for (Course courseSchedule : courseSchedules) {
                // iterate on weekends days
                for (CourseSchedule.DAYS weekend : CourseSchedule.DAYS.values()) {
                    //get course schedule on weekend days (SATURDAY, SUNDAY)
                    CourseSchedule[] availableSchedules = courseSchedule.getDaysMap().get(weekend);
                    if (Objects.nonNull(availableSchedules)) {
                        // iterate on all schedules in 1 day, i.e. 3
                        for (CourseSchedule scheduleOnWeekend : availableSchedules) {
                            if (scheduleOnWeekend.getStudentsEnrolled() < MAX_STUDENTS_IN_A_COURSE_SCHEDULE) {
                                enrollStudent(courseName, courseSchedule, scheduleOnWeekend);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void enrollStudent(CourseName courseName, Course courseSchedule, CourseSchedule scheduleOnWeekend) {
        scheduleOnWeekend.setStudentsEnrolled(scheduleOnWeekend.getStudentsEnrolled() + 1);

        CourseFee courseFee = courseSchedule.getCourseFee();
        double totalFeePaidSoFar = courseFee.getTotalFee() + courseName.getFee();
        courseFee.setTotalFee(totalFeePaidSoFar);
        courseSchedule.setCourseFee(courseFee);
    }

    public CourseName maxEarningCourse() {
        CourseName maxEarningCourse = null;
        double maxCourseFeeCollected = -1d;
        for (CourseName courseName : courses.keySet()) {
            Course[] coursesWeeks = courses.get(courseName);

            double totalCourseFeeCollected = Arrays.stream(coursesWeeks).map(Course::getCourseFee)
                    .mapToDouble(CourseFee::getTotalFee)
                    .sum();

            if (maxCourseFeeCollected == -1d || totalCourseFeeCollected > maxCourseFeeCollected) {
                maxCourseFeeCollected = totalCourseFeeCollected;
                maxEarningCourse = courseName;
            }
        }

        return maxEarningCourse;
    }

    public CourseName maxRankedCourse() {
        CourseName maxEarningCourse = null;
        int maxRankingsCollected = -1;
        for (CourseName courseName : courses.keySet()) {
            Course[] coursesWeeks = courses.get(courseName);

            int totalRankingsCollectedSoFar = Arrays.stream(coursesWeeks).map(Course::getRanking)
                    .map(Ranking::getRankings)
                    .flatMap(Collection::stream)
                    .mapToInt(i -> i)
                    .sum();

            if (maxRankingsCollected == -1d || totalRankingsCollectedSoFar > maxRankingsCollected) {
                maxRankingsCollected = totalRankingsCollectedSoFar;
                maxEarningCourse = courseName;
            }
        }

        return maxEarningCourse;
    }

    public void addRanking(CourseName courseName, int weekNumber, int ranking) {
        if (!courses.isEmpty() &&
                weekNumber > 0 && // array numbering is 0 based, but we are giving an option to user to use 1 as starting index
                courses.values().size() > weekNumber) {
            Course course = courses.get(courseName)[weekNumber - 1];
            // will not allow ranking for a scheduled course without students
            int totalStudentsInCourse = course.getDaysMap().values().stream()
                    .flatMap(Arrays::stream)
                    .mapToInt(CourseSchedule::getStudentsEnrolled)
                    .sum();

            if (totalStudentsInCourse > 0) {
                Ranking ranks = course.getRanking();
                ranks.getRankings().add(ranking);
            }
        }
    }

    enum CourseName {
        YOGA(100d),
        ZOMBA(100d),
        AQUA_CISE(100d),
        BOX_FIT(100d),
        BODY_BLITZ(100d);

        final double fee;

        CourseName(double fee) {
            this.fee = fee;
        }

        public double getFee() {
            return fee;
        }
    }
}

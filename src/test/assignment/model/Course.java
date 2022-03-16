package test.assignment.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    CourseFee courseFee;
    Ranking ranking;

    final Map<CourseSchedule.DAYS, CourseSchedule[]> daysMap;

    public Course() {
        daysMap = new LinkedHashMap<>();
        daysMap.put(CourseSchedule.DAYS.SATURDAY, new CourseSchedule[3]);
        daysMap.put(CourseSchedule.DAYS.SUNDAY, new CourseSchedule[3]);
    }

    public CourseFee getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(CourseFee courseFee) {
        this.courseFee = courseFee;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public Map<CourseSchedule.DAYS, CourseSchedule[]> getDaysMap() {
        return daysMap;
    }
}

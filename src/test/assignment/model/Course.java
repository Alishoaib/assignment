package test.assignment.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Course {
    CourseTotalFee courseTotalFee;
    Ranking ranking;

    final Map<CourseClass.DAYS, CourseClass[]> daysMap;

    public Course() {
        daysMap = new LinkedHashMap<>();
        daysMap.put(CourseClass.DAYS.SATURDAY, new CourseClass[3]);
        daysMap.put(CourseClass.DAYS.SUNDAY, new CourseClass[3]);

        courseTotalFee = new CourseTotalFee();
        ranking = new Ranking();
    }

    public CourseTotalFee getCourseFee() {
        return courseTotalFee;
    }

    public void setCourseFee(CourseTotalFee courseTotalFee) {
        this.courseTotalFee = courseTotalFee;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public Map<CourseClass.DAYS, CourseClass[]> getDaysMap() {
        return daysMap;
    }
}

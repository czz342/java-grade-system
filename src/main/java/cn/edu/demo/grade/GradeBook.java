package cn.edu.demo.grade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradeBook {
    private final Student student;
    private final List<ScoreRecord> records = new ArrayList<ScoreRecord>();

    public GradeBook(Student student) {
        this.student = student;
    }

    public void addScore(Course course, double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        records.add(new ScoreRecord(course, score));
    }

    public Student getStudent() {
        return student;
    }

    public List<ScoreRecord> getRecords() {
        return Collections.unmodifiableList(records);
    }

    public static class ScoreRecord {
        private final Course course;
        private final double score;

        public ScoreRecord(Course course, double score) {
            this.course = course;
            this.score = score;
        }

        public Course getCourse() {
            return course;
        }

        public double getScore() {
            return score;
        }
    }
}

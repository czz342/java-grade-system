package cn.edu.demo.grade;

import java.util.List;

public class GradeService {
    public double average(GradeBook gradeBook) {
        List<GradeBook.ScoreRecord> records = gradeBook.getRecords();
        if (records.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (GradeBook.ScoreRecord record : records) {
            total += record.getScore();
        }
        return total / records.size();
    }

    public String level(double average) {
        if (average >= 90) {
            return "优秀";
        }
        if (average >= 80) {
            return "良好";
        }
        if (average >= 60) {
            return "及格";
        }
        return "不及格";
    }

    public void printReport(GradeBook gradeBook) {
        System.out.println("学生：" + gradeBook.getStudent());
        for (GradeBook.ScoreRecord record : gradeBook.getRecords()) {
            System.out.printf("  %-16s %.1f%n", record.getCourse(), record.getScore());
        }
        double average = average(gradeBook);
        System.out.printf("平均分：%.1f，等级：%s%n", average, level(average));
    }
}

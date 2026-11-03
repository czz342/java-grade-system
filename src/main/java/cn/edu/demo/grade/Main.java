package cn.edu.demo.grade;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("2026001", "张三");
        GradeBook gradeBook = new GradeBook(student);
        gradeBook.addScore(new Course("SE101", "软件工程导论"), 92);
        gradeBook.addScore(new Course("CS201", "数据结构"), 86);
        gradeBook.addScore(new Course("DB301", "数据库原理"), 88);

        new GradeService().printReport(gradeBook);
    }
}

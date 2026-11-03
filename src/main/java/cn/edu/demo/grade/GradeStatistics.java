package cn.edu.demo.grade;

public final class GradeStatistics {
    private GradeStatistics() {
    }

    public static double highest(double... scores) {
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("At least one score is required.");
        }

        double highest = scores[0];
        for (double score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    public static double lowest(double... scores) {
        if (scores == null || scores.length == 0) {
            throw new IllegalArgumentException("At least one score is required.");
        }

        double lowest = scores[0];
        for (double score : scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }
}

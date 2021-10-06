import java.text.DecimalFormat;
import java.util.Scanner;


public class GradeStudent {
    private static DecimalFormat df = new DecimalFormat("#.0");
    int weightcheck = 0;
    public static void main(String[] args) {
        GradeStudent gs = new GradeStudent();

        begin();
        double midweightedscore = gs.midTerm();
        double finalweightedscore = gs.finalTerm();
        double hwweightedscore = gs.homework();
        report(midweightedscore, finalweightedscore, hwweightedscore);
        System.out.println();
        System.out.println("Thank you for using this program. Have a nice day!");
    }
    public static void begin() {
        System.out.println("______________________________________________________________________________");
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println();
    }
    public double midTerm() {

        System.out.println("Midterm:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight (0-100)? ");
        int midweight = sc.nextInt();
        if (midweight > 100) {
            System.out.println("Total weight input not added up to 100, please re-enter from the beginning");
            System.out.println("Restarting program...");
            System.out.println();
            main(null);
        }
        System.out.print("Score earned? ");
        int score = sc.nextInt();
        System.out.print("Were scores shifted (1 = yes, 2 = no): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Shift amount? ");
            int finalshift = sc.nextInt();
            score += finalshift;
            if (score >= 100) score = 100;
        }
        System.out.println("Total points = " + score + " / " + "100");
        double midweightedscore = (score / 100.0) * midweight;
        System.out.println("Weighted score = " + df.format(midweightedscore) + " / " + midweight);

        System.out.println();
        weightcheck += midweight;
        return midweightedscore;
    }

    public double finalTerm() {

        System.out.println("Final:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight (0-100)? ");
        int finalweight = sc.nextInt();
        if (finalweight > 100) {
            System.out.println("Total weight input not added up to 100, please re-enter from the beginning");
            System.out.println("Restarting program...");
            System.out.println();
            main(null);
        }
        System.out.print("Score earned? ");
        int score = sc.nextInt();
        System.out.print("Were scores shifted (1 = yes, 2 = no): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Shift amount? ");
            int finalshift = sc.nextInt();
            score += finalshift;
            if (score >= 100) score = 100;
        }
        System.out.println("Total points = " + score + " / " + "100");
        double finalweightedscore = (score / 100.0) * finalweight;
        System.out.println("Weighted score = " + df.format(finalweightedscore) + " / " + finalweight);

        System.out.println();
        weightcheck += finalweight;
        return finalweightedscore;
    }

    public double homework() {
        int totalscore = 0;
        int totalmax = 30;
        Scanner sc = new Scanner(System.in);
        System.out.println("Homework: ");
        System.out.print("Weight (0-100)? ");
        int weight = sc.nextInt();
        if (weight > 100) {
            System.out.println("Total weight input not added up to 100, please re-enter from the beginning");
            System.out.println("Restarting program...");
            System.out.println();
            main(null);
        }
        weightcheck += weight;
        if (weightcheck != 100) {
            System.out.println("Total weight input not added up to 100, please re-enter from the beginning");
            System.out.println("Restarting program...");
            System.out.println();
            main(null);
        }
        System.out.print("Number of assignments: ");
        int assignments = sc.nextInt();
        for (int i = 1; i <= assignments; i++) {
            System.out.print("Assignment " + i + " score and max: ");
            int score = sc.nextInt();
            int max = sc.nextInt();
            totalscore += score;
            totalmax += max;
        }
        if (totalscore >= 150) totalscore = 150;
        System.out.print("How many sections did you attend: ");
        int attend = sc.nextInt();
        int sectionpoint = 5 * attend;
        totalscore += sectionpoint;
        if (sectionpoint >= 30) sectionpoint = 30;
        System.out.println("Section point = " + sectionpoint + " / 30");
        System.out.println("Total point = " + totalscore + " / " + totalmax);
        double hwweightedscore = totalscore * 1.0 / totalmax * weight;
        System.out.println("Weighted score = " + df.format(hwweightedscore) + " / " + weight);
        System.out.println();
        return hwweightedscore;
    }

    public static void report(double midweightedscore, double finalweightedscore, double hwweightedscore) {
        double grade = midweightedscore + finalweightedscore + hwweightedscore;
        System.out.println("Overall percentage = " + df.format(grade));
        double gpa = 0.0;
        if (grade >= 60 && grade < 75) gpa = 0.7;
        else if (grade >= 75 && grade < 85) gpa = 2.0;
        else if (grade >= 85) gpa = 3.0;
        System.out.println("Your grade will be at least: " + gpa);
        if (gpa <= 2.0) System.out.println("Your GPA falls below average, please try harder!");
        else if (gpa > 2.0 && gpa <= 3.0) System.out.println("Average GPA but you could score higher, please keep trying!");
        else if (gpa > 3.0) System.out.println("Good result, please keep up the good work!");
    }


}

import java.text.DecimalFormat;
import java.util.Scanner;

public class GPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("**********GPA CALCULATOR**********");
        System.out.println("This program is to calculate the GPA(10 Scale)");
        System.out.println("This program is created by Mohammed Rasheed M ©");
        System.out.println("**********************************");
        System.out.println();

        Integer TotalPoints = 0;
        Integer TotalCredits = 0;
        Boolean Res = false;
        do {
            Integer Credits = 0;
            boolean ValidCredit = true;
            do {
                ValidCredit = true;
                System.out.print("Enter the Credit of the Course : ");
                String CreditsS = sc.nextLine();
                try {
                    Credits = Integer.parseInt(CreditsS);
                } catch (NumberFormatException e) {
                    System.out.println("Please Enter the valid Integer : ");
                    ValidCredit = false;
                }
            } while (!ValidCredit);

            Boolean ValidGrade = true;
            Integer GradeValue = 0;
            String Grade = "";
            do {
                ValidGrade = true;
                System.out.print("Enter the Grade of the Course : ");
                Grade = sc.nextLine();

                if (Grade.equalsIgnoreCase("S")) {
                    GradeValue = 10;
                } else if (Grade.equalsIgnoreCase("A")) {
                    GradeValue = 9;
                } else if (Grade.equalsIgnoreCase("B")) {
                    GradeValue = 8;
                } else if (Grade.equalsIgnoreCase("C")) {
                    GradeValue = 7;
                } else if (Grade.equalsIgnoreCase("D")) {
                    GradeValue = 6;
                } else if (Grade.equalsIgnoreCase("E")) {
                    GradeValue = 5;
                } else if (Grade.equalsIgnoreCase("U")) {
                    GradeValue = 0;
                } else if (Grade.equalsIgnoreCase("W")) {
                    GradeValue = 0;
                } else if (Grade.equalsIgnoreCase("I")) {
                    GradeValue = 0;
                } else if (Grade.equalsIgnoreCase("AB")) {
                    GradeValue = 0;
                } else {
                    System.out.println("You didn't enter a valid grade !!!");
                    ValidGrade = false;
                }

            } while (!ValidGrade);

            Integer Points = GradeValue * Credits;
            TotalPoints += Points;
            TotalCredits += Credits;

            System.out.print("Would u like to add another course (Y/N) !? ");
            String Responses = sc.nextLine();
            Res = Responses.equalsIgnoreCase("Y");
        } while (Res);

        System.out.println();

        DecimalFormat d = new DecimalFormat("0.00");
        Double GPA = Double.valueOf(TotalPoints) / Double.valueOf(TotalCredits);
        System.out.println("Total Credits : " + TotalCredits);
        System.out.println("Total Points : " + TotalPoints);
        System.out.println("------------------");
        System.out.println("GPA : " + d.format(GPA));
        System.out.println("------------------");
        sc.close();
    }
}
import java.util.Scanner;
	class Question {
    public static void main(String[] args) {
        System.out.println("Welcome to the java Quize");
        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("Question 1: When an array is passed to a method, what does the method receive?");
        System.out.println("a. The reference of the array");
        System.out.println("b. A copy of the array");
        System.out.println("c. Length of the array");
        System.out.println("d. Copy of first element");
        String answer1 = input.nextLine().toLowerCase();
        if (answer1.equals("a")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, the correct answer is The reference of the array.");
        }
        System.out.println("Question 2: what is the size of float and double in java?");
        System.out.println("a. 32 and 32");
        System.out.println("b. 64 and 64");
        System.out.println("c. 32 and 64");
        System.out.println("d. 64 and 32");
        String answer2 = input.nextLine().toLowerCase();
        if (answer2.equals("c")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, the correct answer is 32 and 64.");
        }
        System.out.println("Question 3: Number of primitive data types in java are?");
        System.out.println("a. 6");
        System.out.println("b. 7");
        System.out.println("c. 9");
        System.out.println("d. 8");
        String answer3= input.nextLine().toLowerCase();
        if (answer3.equals("d")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, the correct answer is 8.");
        }
            System.out.println("Question 4: Automatic type conversion is possible in which of the possible case?");
            System.out.println("a. Byte to int");
            System.out.println("b. Int to long");
            System.out.println("c. Long to int");
            System.out.println("d. Short to int");
            String answer4 = input.nextLine().toLowerCase();
            if (answer4.equals("b")) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Sorry, the correct answer is Int to long.");
            }
        System.out.println("Question 5: Array in java are?");
        System.out.println("a. object references");
        System.out.println("b. Object");
        System.out.println("c. Primitive data type");
        System.out.println("d. None");
        String answer5 = input.nextLine().toLowerCase();
        if (answer5.equals("b")) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Sorry, the correct answer is Object.");
        }
        System.out.println("Your final score is: " + score);
    }
}

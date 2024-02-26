import java.io.*;
import java.util.*;

class ExpenseTracker {

    private Map<String, List<Expense>> userExpenses = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        expenseTracker.run();
    }

    public void run() {
        loadUserData();
        while (true) {
            System.out.println("Expense Tracker");
            System.out.println("1. Log in");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    saveUserData();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (!userExpenses.containsKey(username)) {
            System.out.println("User not found. Creating a new account...");
            userExpenses.put(username, new ArrayList<>());
        }
        showMenu(username);
    }

    private void showMenu(String username) {
        while (true) {
            System.out.println("\nWelcome, " + username + "!");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Category-wise Summation");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExpense(username);
                    break;
                case 2:
                    viewExpenses(username);
                    break;
                case 3:
                    viewCategoryWiseSummation(username);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addExpense(String username) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Expense expense = new Expense(date, category, amount);
        userExpenses.get(username).add(expense);
        System.out.println("Expense added successfully.");
    }

    private void viewExpenses(String username) {
        List<Expense> expenses = userExpenses.get(username);
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        System.out.println("Expenses for " + username + ":");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    private void viewCategoryWiseSummation(String username) {
        Map<String, Double> categorySumMap = new HashMap<>();
        List<Expense> expenses = userExpenses.get(username);
        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();
            categorySumMap.put(category, categorySumMap.getOrDefault(category, 0.0) + amount);
        }
        System.out.println("Category-wise Summation for " + username + ":");
        for (Map.Entry<String, Double> entry : categorySumMap.entrySet()) {
            System.out.println(entry.getKey() + ": Rs " + entry.getValue());
        }
    }

    private void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userData.dat"))) {
            userExpenses = (Map<String, List<Expense>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }

    private void saveUserData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userData.dat"))) {
            oos.writeObject(userExpenses);
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    private static class Expense implements Serializable {
        private String date;
        private String category;
        private double amount;

        public Expense(String date, String category, double amount) {
            this.date = date;
            this.category = category;
            this.amount = amount;
        }

        public String getCategory() {
            return category;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Date: " + date + ", Category: " + category + ", Amount: Rs " + amount;
        }
    }
}
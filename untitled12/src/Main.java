import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = getValidInput(scanner);

        System.out.println("Виберіть дію: 1 - Перевернути рядок, 2 - Перевернути слова");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println(reverseString(input));
        } else {
            System.out.println(reverseEachWord(input));
        }
        scanner.close();
    }

    private static String getValidInput(Scanner scanner) {
        String input;
        while (true) {
            System.out.println("Введіть рядок (мін. 2 слова, кожне від 3 символів):");
            input = scanner.nextLine();
            String[] words = input.split(" ");
            if (words.length >= 2 && input.matches(".*\\b\\w{3,}\\b.*")) break;
            System.out.println("Помилка. Спробуйте знову.");
        }
        return input;
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String reverseEachWord(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return String.join(" ", words);
    }
}

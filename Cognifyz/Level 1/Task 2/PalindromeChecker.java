import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a word or phrase: ");
        String text = input.nextLine();

        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z0-9]", "");

        int length = text.length();

        boolean isPalindrome = true;

        for (int i = 0; i < length / 2; i++) {
            if (text.charAt(i) != text.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The word or phrase is a palindrome.");
        } else {
            System.out.println("The word or phrase is not a palindrome.");
        }

        input.close();
    }
}
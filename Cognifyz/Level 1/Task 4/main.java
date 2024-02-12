import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many unique random passwords do you want to generate? :");
        int total = scanner.nextInt();

        System.out.println("How many characters long do you want your random passwords to be?:");
        int length = scanner.nextInt();

        String[] randomPasswords = new String[total];

        for (int i = 0; i < total; i++) {
            String randomPassword = "";

            for (int j = 0; j < length; j++) {
                randomPassword += generateRandomCharacter();
            }
            randomPasswords[i] = randomPassword;
        }
        printPasswords(randomPasswords);
    }

    public static char generateRandomCharacter() {
        int rand = (int) (Math.random() * 62);

        if (rand <= 9) {
            int ascii = rand + 48; // numbers between 0-9 (ASCII: 48-57)
            return (char) ascii;
        } else if (rand <= 35) {
            int ascii = rand + 55; // uppercase letters (ASCII: 65-90)
            return (char) ascii;
        } else {
            int ascii = rand + 61; // lowercase letters (ASCII: 97-122)
            return (char) ascii;
        }
    }

    public static void printPasswords(String[] arr) {
        for (String password : arr) {
            System.out.println(password);
        }
    }
}

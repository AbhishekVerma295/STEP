public class UseCase11PalindromeCheckerApp {

    // Application entry point
    public static void main(String[] args) {
        PalindromeService service = new PalindromeService();

        String input = "Madam";

        if (service.checkPalindrome(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     * @param input Input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {

        // Normalize string (lowercase and remove spaces)
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Initialize pointers
        int start = 0;
        int end = input.length() - 1;

        // Compare characters moving inward
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

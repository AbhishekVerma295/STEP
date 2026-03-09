public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        // Hardcoded string with spaces and mixed case
        String word = "Madam In Eden Im Adam";

        // Normalize the string
        String normalized = word.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = true;

        int start = 0;
        int end = normalized.length() - 1;

        // Two pointer comparison
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("The phrase \"" + word + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The phrase \"" + word + "\" is NOT a Palindrome.");
        }
    }
}
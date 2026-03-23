import java.util.*;

/**
 * ============================================================
 * MAIN CLASS – UseCase12PalindromeCheckerApp
 * Strategy Pattern for Palindrome Algorithms
 * ============================================================
 */
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Madam";

        // Choose strategy at runtime
        PalindromeStrategy strategy;

        // You can switch between strategies
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        if (context.executeCheck(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}

/**
 * ============================================================
 * INTERFACE – PalindromeStrategy
 * ============================================================
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * ============================================================
 * CONTEXT CLASS
 * ============================================================
 */
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.check(input);
    }
}

/**
 * ============================================================
 * STACK STRATEGY
 * ============================================================
 */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * ============================================================
 * DEQUE STRATEGY
 * ============================================================
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}
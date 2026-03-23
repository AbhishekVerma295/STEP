import java.util.*;

/**
 * ============================================================
 * MAIN CLASS – UseCase13PalindromeCheckerApp
 * Performance Comparison of Palindrome Algorithms
 * ============================================================
 */
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Level";

        PalindromeStrategyUC13 stackStrategy = new StackStrategyUC13();
        PalindromeStrategyUC13 dequeStrategy = new DequeStrategyUC13();
        PalindromeStrategyUC13 twoPointerStrategy = new TwoPointerStrategyUC13();

        runTest("Stack Strategy", stackStrategy, input);
        runTest("Deque Strategy", dequeStrategy, input);
        runTest("Two Pointer Strategy", twoPointerStrategy, input);
    }

    public static void runTest(String name, PalindromeStrategyUC13 strategy, String input) {

        long startTime = System.nanoTime();

        boolean result = strategy.check(input);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Algorithm: " + name);
        System.out.println("Is Palindrome: " + result);
        System.out.println("Execution Time: " + duration + " ns");
        System.out.println("-----------------------------------");
    }
}

/**
 * ============================================================
 * INTERFACE – PalindromeStrategyUC13
 * ============================================================
 */
interface PalindromeStrategyUC13 {
    boolean check(String input);
}

/**
 * ============================================================
 * STACK STRATEGY
 * ============================================================
 */
class StackStrategyUC13 implements PalindromeStrategyUC13 {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

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
class DequeStrategyUC13 implements PalindromeStrategyUC13 {

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

/**
 * ============================================================
 * TWO POINTER STRATEGY
 * ============================================================
 */
class TwoPointerStrategyUC13 implements PalindromeStrategyUC13 {

    public boolean check(String input) {

        input = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = input.length() - 1;

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
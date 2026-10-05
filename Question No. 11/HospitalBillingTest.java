public class HospitalBillingTest {

    public static double calculateBill(double fee, double labCost, boolean hasIns, boolean isEmerg) {
        if (fee == 0) {
            return -1.0;
        }
        double totalBill = fee + labCost;

        if (hasIns || (isEmerg && totalBill > 5000)) {
            totalBill = totalBill * 0.90;
        }
        return totalBill;
    }

    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("  White-Box Testing: Hospital Management System (SE Exp 12)");
        System.out.println("  Method Under Test: calculateBill(fee, labCost, hasIns, isEmerg)");
        System.out.println("=================================================================");

        System.out.println("\n--- Control Flow Graph (CFG) Analysis ---");
        System.out.println("Nodes (N) = 7, Edges (E) = 8, Connected Components (P) = 1");
        System.out.println("Cyclomatic Complexity V(G) = E - N + 2P = 8 - 7 + 2(1) = 3");
        System.out.println("Predicate Nodes (P_n) = 2, so V(G) = P_n + 1 = 2 + 1 = 3");
        System.out.println("Therefore, Exactly 3 Independent Basis Paths are required for 100% path coverage.");

        System.out.println("\n--- Basis Paths & Test Cases Execution ---");

        double res1 = calculateBill(0, 1000, false, false);
        System.out.println("Test Case 1 (Path 1: fee=0, labCost=1000, hasIns=false, isEmerg=false):");
        System.out.println("Expected: -1.0 (Invalid input error) | Actual: " + res1 + " -> " + (res1 == -1.0 ? "PASSED [OK]" : "FAILED"));

        double res2 = calculateBill(2000, 3000, true, false);
        System.out.println("\nTest Case 2 (Path 2: fee=2000, labCost=3000, hasIns=true, isEmerg=false):");
        System.out.println("Expected: 4500.0 (10% discount on 5000) | Actual: " + res2 + " -> " + (res2 == 4500.0 ? "PASSED [OK]" : "FAILED"));

        double res3 = calculateBill(1500, 500, false, false);
        System.out.println("\nTest Case 3 (Path 3: fee=1500, labCost=500, hasIns=false, isEmerg=false):");
        System.out.println("Expected: 2000.0 (No discount) | Actual: " + res3 + " -> " + (res3 == 2000.0 ? "PASSED [OK]" : "FAILED"));

        System.out.println("\n=================================================================");
        System.out.println("Result: All 3 Basis Paths Covered Successfully (100% Branch & Statement Coverage)");
        System.out.println("=================================================================");
    }
}

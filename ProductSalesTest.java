public class ProductSalesTest {
    public static void main(String[] args) {
        ProductSales ps = new ProductSales();

        int expectedTotal = 6185;
        double expectedAverage = 6185.0 / 12.0;
        int expectedOver = 6;
        int expectedUnder = 6;
        int expectedYears = 3;

        boolean ok = true;

        if (ps.GetTotalSales() != expectedTotal) {
            System.err.println("FAIL: GetTotalSales() returned " + ps.GetTotalSales() + " expected " + expectedTotal);
            ok = false;
        }

        double avg = ps.GetAverageSales();
        double eps = 1e-6;
        if (Math.abs(avg - expectedAverage) > eps) {
            System.err.println(String.format("FAIL: GetAverageSales() returned %.8f expected %.8f", avg, expectedAverage));
            ok = false;
        }

        if (ps.GetSalesOverLimit() != expectedOver) {
            System.err.println("FAIL: GetSalesOverLimit() returned " + ps.GetSalesOverLimit() + " expected " + expectedOver);
            ok = false;
        }

        if (ps.GetSalesUnderLimit() != expectedUnder) {
            System.err.println("FAIL: GetSalesUnderLimit() returned " + ps.GetSalesUnderLimit() + " expected " + expectedUnder);
            ok = false;
        }

        if (ps.GetProductsProcessed() != expectedYears) {
            System.err.println("FAIL: GetProductsProcessed() returned " + ps.GetProductsProcessed() + " expected " + expectedYears);
            ok = false;
        }

        if (ps.GetProductSales() == null || ps.GetProductSales().length != expectedYears) {
            System.err.println("FAIL: GetProductSales() has wrong shape");
            ok = false;
        }

        if (ok) {
            System.out.println("ALL TESTS PASSED");
            System.exit(0);
        } else {
            System.err.println("ONE OR MORE TESTS FAILED");
            System.exit(1);
        }
    }
}

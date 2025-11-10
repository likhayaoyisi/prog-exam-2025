public class SalesReport {
    public static void main(String[] args) {
        
        int[][] salesData = {

            {300, 150, 700}, 
            {250, 200, 600} 
        };

        ProductSales productSales = new ProductSales();

        
        int totalSales = productSales.TotalSales(salesData);
        double averageSales = productSales.AverageSales(salesData);
        int maxSale = productSales.MaxSale(salesData);
        int minSale = productSales.MinSale(salesData);

        
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("----------------------------");
        System.out.printf("Total sales: $%,d%n", totalSales);
        System.out.printf("Average sales: $%,.2f%n", averageSales);
        System.out.printf("Maximum sale: $%,d%n", maxSale);
        System.out.printf("Minimum sale: $%,d%n", minSale);
        System.out.println("----------------------------");

    }
}
public class ProductSales implements IProductSales {
    private int[][] sales; 
    private int salesLimit = 500;

    public ProductSales() {

        this.sales = new int[][]{
            {450, 600, 700, 320},
            {520, 480, 510, 495},
            {610, 400, 300, 800}
        };
    }

    public ProductSales(int[][] sales, int salesLimit) {

        this.sales = sales;
        this.salesLimit = salesLimit;
    }

    @Override

    public int[][] GetProductSales() {
        return sales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : sales) {
            for (int v : year) total += v;
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : sales) {
            for (int v : year) 
            if (v > salesLimit) 
            count++;
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : sales) {
            for (int v : year) 
            if (v < salesLimit) 
            count++;
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {

        return sales.length;
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int[] year : sales) 
        count += year.length;
        if (count == 0) 
        return 0.0;
        return ((double) total) / count;
    }

    public int GetSalesLimit() {
        return salesLimit;
    }
}

public class ProductSales implements IProductSales {


    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;

        for (int[] yearSales : productSales) {
            for (int quarterlySale : yearSales) {
                total += quarterlySale;
            }
        }
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int numberOfQuarters = productSales.length * productSales[0].length;
        return (double) total / numberOfQuarters;
    }

    @Override

    public int MaxSale(int[][] productSales) {

        int max = Integer.MIN_VALUE;
        for (int[] yearSales : productSales) {

            for (int quarterlySale : yearSales) {
                if (quarterlySale > max) {
                    max = quarterlySale;
                }
            }
        }
        return max;
    }

    @Override

    public int MinSale(int[][] productSales) {

        int min = Integer.MAX_VALUE;
        for (int[] yearSales : productSales) {
            for (int quarterlySale : yearSales) {
                if (quarterlySale < min) {
                    min = quarterlySale;
                }
            }
        }
        return min;
    }
}
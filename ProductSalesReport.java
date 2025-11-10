/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productsalesreport;

/**
 *
 * @author petermadsen
 */
public class ProductSalesReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //2D array
        int[][] sales = {
            {300, 150, 700},
            {250, 200, 600}

        };
        
        String[] quarters = {"Quarter 1", "Quarter 2", "Quarter 3"};


        ProductSales report = new ProductSales(sales);
        
                System.out.println("Quarters used in report:");
        for (String q : quarters) {
            System.out.println(" - " + q);
        }
        System.out.println();
//

        int total = report.TotalSales(sales);
        double average = report.AverageSales(sales);
        int max = report.maxSale(sales);
        int min = report.minSale(sales);

        // output layout
        System.out.println("==============================");
        System.out.println(" PRODUCT SALES REPORT - 2025");
        System.out.println("==============================");
        System.out.printf(" Total sales:   %d%n", total);
        System.out.printf(" Average sales: %.0f%n", average);
        System.out.printf(" Maximum sale:  %d%n", max);
        System.out.printf(" Minimum sale:  %d%n", min);
        System.out.println("==============================");
    }

}

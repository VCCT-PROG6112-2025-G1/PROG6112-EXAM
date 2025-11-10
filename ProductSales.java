/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsalesreport;

/**
 *
 * @author petermadsen
 */
public class ProductSales implements IProduct {

    private int[][] salesData;

    public ProductSales(int[][] salesData) {
        this.salesData = salesData;
    }

 // method to work out total sales   
 @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                total += productSales[year][quarter];
            }
        }
        return total;
    }
    // calcuates the average sales 
    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int count = productSales.length * productSales[0].length;
        return (double) total / count;
    }

    //works out the max sales 
    @Override
    public int maxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] > max) {
                    max = productSales[year][quarter];
                }
            }
        }
        return max;
    }

    //works out min sales 
    @Override
    public int minSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] < min) {
                    min = productSales[year][quarter];
                }
            }
        }
        return min;
    }
    
}
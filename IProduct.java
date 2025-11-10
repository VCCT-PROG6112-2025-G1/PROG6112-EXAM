/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsalesreport;

/**
 *
 * @author petermadsen
 */

//Interface
public interface IProduct {

    int TotalSales(int[][] productSales);

    double AverageSales(int[][] productSales);

    int maxSale(int[][] productSales);

    int minSale(int[][] productSales);

}

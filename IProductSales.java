/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsalesgui;

/**
 *
 * @author petermadsen
 */
//Interface
public interface IProductSales {
    
    int[][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();
    double GetAverageSales();
    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoService;

/**
 *
 * @author mario
 */
public class CarCustomer {
    private String name;
    private Car[] custCars;
    
    public CarCustomer(String name, Car[] cars){
        this.name = name;
        this.custCars = cars;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void printCustCars(){
        for (Car currCar: custCars){
            System.out.print(currCar);
        }
    }
}

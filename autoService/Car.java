/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoService;
import java.security.*;
/**
 *
 * @author mario
 */
public class Car {
    private String vin= "N/A";
    private String make = "N/A";
    private String model = "N/A";
    private int carYear, carMileage;
    private double carPrice;
    protected static int globalNumOfCars;
    
    public Car(String vin, String make, String model, int carYear, int carMileage, double carPrice) {
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        if (carYear < 1970) {
            throw new IllegalArgumentException("Car Year should be greater than 1970(please input the correct info)...");
        }
        if (carMileage < 0) {
            throw new IllegalArgumentException("Car Milegale should be greater than zero(please input thee correct info)...");
        }
        if (carPrice < 1000) {
            throw new IllegalArgumentException("Car Price should be greater than $1000(please input the correct info)...");
        }
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.carYear = carYear;
        this.carMileage = carMileage;
        this.carPrice = carPrice;
        globalNumOfCars++;
    }
    
    public Car(){
        globalNumOfCars++;
        SecureRandom random = new SecureRandom();
        
        this.vin = String.format(genString()+genStringInt(8));
        if (vin.length()!= 17){
            vin= "N/A";
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        
        this.carYear = (1970 + random.nextInt(51));
        if (carYear < 1970) {
            carYear = 1970;
            throw new IllegalArgumentException("Car Year should be greater than 1970(please input the correct info)...");
        }
        this.carMileage = (1+ random.nextInt(200000));
        if (carMileage < 0) {
            carMileage = 0;
            throw new IllegalArgumentException("Car Milegale should be greater than zero(please input thee correct info)...");
        }
        this.carPrice = (1000 + random.nextInt(100000));
        if (carPrice < 1000) {
            carPrice = 1001;
            throw new IllegalArgumentException("Car Price should be greater than $1000(please input the correct info)...");
        }
    }
    //generates a string of letters of length 9
    private static String genString(){
        SecureRandom rand = new SecureRandom();
        
        String stringLengthI ="";
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWYXYZ";
        int i = 9;
        
        char[] charArr = new char[i];
        
        for (int j=0; j<i; j++){
            charArr[j] = letters.charAt(rand.nextInt(letters.length()));
            
        }
        for (int j=0; j<charArr.length; j++){
            stringLengthI += charArr[j];
        
        }
        
        return stringLengthI;
    }
    //generates a string of ints of length l
    private static String genStringInt(int l){
        SecureRandom randInt = new SecureRandom();
        
        String stringIntl = "";
        String numbers = "1234567890";

        char[] numArr = new char[l];
        
        for (int j=0; j < l; j++){
            numArr[j] += numbers.charAt(randInt.nextInt(numbers.length()));
            
        }
        for (int j=0; j<numArr.length; j++){
          stringIntl += numArr[j];

        }
        
        return  stringIntl;
    }
    
    
    public Car(String vin){
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        this.vin = vin;
        
        globalNumOfCars++;
    }
    
    public Car(String vin, String make) {
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        this.vin  = vin;
        this.make = make;
        
        globalNumOfCars++;
    }
    
    public Car(String vin, String make, String model){
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        this.vin  = vin;
        this.make = make;
        this.model = model;
        
        globalNumOfCars++;
    }
    
    public Car(String vin, String make, String model, int carYear) {
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        if (carYear < 1970) {
            throw new IllegalArgumentException("Car Year should be greater than 1970(please input the correct info)...");
        }
        
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.carYear = carYear;
        
        globalNumOfCars++;
    }
    
    public Car(String vin, String make, String model, int carYear, int carMileage) {
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        if (carYear < 1970) {
            throw new IllegalArgumentException("Car Year should be greater than 1970(please input the correct info)...");
        }
        if (carMileage < 0) {
            throw new IllegalArgumentException("Car Milegale should be greater than zero(please input thee correct info)...");
        }
        
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.carYear = carYear;
        this.carMileage = carMileage;
        globalNumOfCars++;
    }
    
    @Override
    public String toString(){
        return String.format("%s%s%s%nYear: %02d%nMileage: %d Miles%nCar Price: $%02.2f%n",getVin(),getMake(),getModel(),getCarYear(),getCarMileage(),getCarPrice());
    }
    
    public String getVin(){
        return String.format("%nVIN: %s", this.vin);
    }
    public void setVin(String v){
        if (vin.length()!= 17){
            throw new IllegalArgumentException("VIN should have 17 chars(please input the correct info)...");
        }
        this.vin = v;
    }
    
    public String getMake(){
        return String.format("%nCar Make: %s",this.make);
    }
    public void setMake(String m){
        this.make = m;
    }
    
    public String getModel(){
        return String.format("%nCar Model: %s", this.model);
    }
    public void setModel(String cM){
        this.model = cM;
    }
    
    public int getCarYear(){
        return this.carYear;
    }
    public void setCarYear(int year){
        if (carYear < 1970) {
            throw new IllegalArgumentException("Car Year should be greater than 1970(please input the correct info)...");
        }
        this.carYear = year;
    }
    
    public int getCarMileage(){
        return this.carMileage;
    }
    public void setCarMileage(int mileage){
        if (carMileage < 0) {
            throw new IllegalArgumentException("Car Milegale should be greater than zero(please input thee correct info)...");
        }
        this.carMileage = mileage;
    }
    
    public double getCarPrice(){
        return this.carPrice;    
    }
    public void setCarPrice(double priceOfCar){
        if (carPrice < 1000) {
            throw new IllegalArgumentException("Car Price should be greater than $1000(please input the correct info)...");
        }
        this.carPrice = priceOfCar; 
    }
}

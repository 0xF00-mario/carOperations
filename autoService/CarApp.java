/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoService;

import java.util.*;
import java.security.*;

/**
 *
 * @author mario
 */
public class CarApp {

    public static void main(String[] args) {
        //instance scannner and random object
        Scanner input = new Scanner(System.in);
        SecureRandom randInt = new SecureRandom();

        int intRand = (1 + randInt.nextInt(10));
        //generate random number of cars 1-10
        Car[] shopCars = new Car[intRand];
        for (int i = 0; i < intRand; i++) {

            Car currCar = new Car();
            shopCars[i] = currCar;
        }

        printMenu();

        int choice = input.nextInt();

        do {
            
            while (choice != 0) {
                try {
                    switch (choice) {
                        case 1:
                            int j = 0;

                            for (Car currCar : shopCars) {

                                System.out.println("\n Car #" + (j + 1));
                                System.out.print(currCar);

                                ++j;
                            }
                            
                            int modify;
                            System.out.println("\n Would you like to modify a car? input 1 for yes or 0 for no");
                            modify = input.nextInt();
                            if (modify == 1) {
                                System.out.println("\nWhich car would you like to modify? (input car number as determined above)");
                                int selected = input.nextInt();
                                modifyCar(shopCars,selected);
                                
                            }
                            
                            System.out.println("\n Would you like to sell a car? Input 1 for yes or 0 for no");
                            int selling = input.nextInt();
                            if (selling == 1) {
                                System.out.println("\nWhich car would you like to sell? (input car number as determined above)");
                                int selectedToSell = (input.nextInt()-1);
                                sellCar(shopCars,selectedToSell);
                                
                            }
                            
                            choice = 0;
                            break;

                        case 2:
                            String vin,make,model;
                            int carYear, carMileage;
                            double carPrice;
                            
                            System.out.println("\nInput VIN(must be 17 characters long)....");
                            vin = input.next();
                            
                            System.out.println("\nInput CAR MAKE....");
                            make = input.next();
                            
                            System.out.println("\nInput CAR MODEL....");
                            model = input.next();
                            
                            System.out.println("\n Input CAR YEAR(only year 1970 and above)....");
                            carYear = input.nextInt();
                            
                            System.out.println("\nInput CAR MILEAGE(non-negative value)....");
                            carMileage = input.nextInt();
                            
                            System.out.println("\nInput CAR PRICE(lowest price allowed is 1000)....");
                            carPrice = input.nextDouble();
                            
                            Car newCar = new Car(vin,make,model,carYear,carMileage,carPrice);
                            
                            shopCars = addCarToArray(intRand,shopCars,newCar);
                            
                            System.out.println("\n***CAR ADDED***");
                            choice = 0;
                            break;

                        case 3:
                            //calculating the average of all current cars in lot
                            calcAverageMiles(shopCars);
                            calcLowestPrice(shopCars);

                            choice = 0;
                            break;
                        default:
                            System.out.print("\nPlease Input A Valid Selection...");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.print(e);
                }

            }
            
            printMenu();
            choice = input.nextInt();
        } while (choice !=0);
    }

    public static void printMenu() {
        System.out.println("\n-----Welcome to Winston-Salem Auto-----");
        System.out.println("\nPlease select what you would like to do...");
        System.out.println("\n1.View all current available cars (select this if you would like to modify/sell a car)\n2.Add a car \n3.View stats of all available cars (input 0 to exit)");
    }
    
    private static void modifyCar(Car[] cars, int selection){
        Scanner input = new Scanner(System.in);
        
        int done;
         do {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("\n1.Modify VIN\n2.Modify Make\n3.Modify Model\n4.Modify Car Year\n5.Modify Car mileage\n6.Modify Car Price (INPUT 0 TO EXIT)");
            done = input.nextInt();
            while (done!=0) {
                try {
                    switch (done){
                        case 1:
                            System.out.println("\nPlease Input New Vin(17 chars only)");
                            String newVin = input.next();
                            
                            Car modifyCar = cars[selection-1];
                            
                            modifyCar.setVin(newVin);
                            
                            cars[selection-1] = modifyCar;
                            
                            System.out.println("***SUCCESSFULLY MODIFIED***");
                            done = 0;
                            break;
                        case 2:
                            System.out.println("\nPlease Input New Make");
                            String newMake = input.next();
                            
                            Car modifyCar2 = cars[selection-1];
                            
                            modifyCar2.setMake(newMake);
                            
                            cars[selection-1] = modifyCar2;
                            
                            System.out.println("***SUCCESSFULLY MODIFIED***");
                            done =0;
                            break;
                        case 3:
                            System.out.println("\nPlease Input New Model");
                            String newModel = input.next();
                            
                            Car modifyCar3 = cars[selection-1];
                            
                            modifyCar3.setModel(newModel);
                            
                            cars[selection-1] =  modifyCar3;
                            
                            System.out.println("***SUCCESSFULLY MODIFIED***");
                            done = 0;
                            break;
                        case 4:
                            System.out.println("\nPlease Input New Car Year(1970 or greater)");
                            int newYear = input.nextInt();
                            
                            Car modifyCar4 = cars[selection-1];
                            
                            modifyCar4.setCarYear(newYear);
                            
                            cars[selection-1] = modifyCar4;
                            
                            System.out.println("***SUCCESSFULLY MODIFIED***");
                            done=0;
                            break;
                        case 5:
                            System.out.println("\nPlease Input New Mileage(nonnegative integer)");
                            int newMileage = input.nextInt();
                            
                            Car modifyCar5 = cars[selection-1];
                            
                            modifyCar5.setCarMileage(newMileage);
                            
                            cars[selection-1] = modifyCar5;
                            
                            System.out.println("***SUCCESSFULLY MODIFIED***");
                            done=0;
                            break;
                        case 6:
                            System.out.println("\nPlease Input New Price($1000 or greater)");
                            double newPrice = input.nextDouble();
                            
                            Car modifyCar6 = cars[selection-1];
                            
                            modifyCar6.setCarPrice(newPrice);
                            
                            cars[selection-1] = modifyCar6;
                            
                            System.out.println("***SUCCESSFULLY MODIFIED***");
                            done=0;
                            break;
                        default:    
                            System.out.print("\nPlease Input A Valid Selection...");
                                    
                    }
                            
                
                }
                catch (IllegalArgumentException e) {
                    System.out.print(e);
                }
            
            }
            
            
        } while(done != 0);
    }

    private static void sellCar(Car[] cars, int selling){
        Scanner in = new Scanner(System.in);
        
        System.out.println("\nInput an Int based on the Customer Satisfaction with the car. \n1.satisfied \n2.somewhat satisfied\n3.unsatisfied");
        int satisfaction = in.nextInt();
        
        switch(satisfaction){
            case 1:
                //100
                System.out.println("List Price: $"+cars[selling].getCarPrice());
                System.out.println("Discount Price: $100");
                System.out.printf("%nAsking Price: $%.2f",(cars[selling].getCarPrice()-100));
                
                break;
            case 2:
                //200
                System.out.println("List Price: $"+cars[selling].getCarPrice());
                System.out.println("Discount Price: $200");
                System.out.printf("%nAsking Price: $%.2f",(cars[selling].getCarPrice()-200));
                        
                break;
            case 3:
                //500
                System.out.println("List Price: $"+cars[selling].getCarPrice());
                System.out.println("Discount Price: $500");
                System.out.printf("%nAsking Price: $%.2f",(cars[selling].getCarPrice()-500));
                        
                break;
            default:
                System.out.println("Invalid selection...");
        }
    
    }
    
    
    private static Car[] addCarToArray (int origSize, Car cars[], Car addCar){
        Car newArr[] = new Car[origSize+1];
        
        for (int i=0; i<origSize; i++){
            newArr[i] = cars[i];
        }
        newArr[origSize] = addCar;
        
        return newArr;
    }
    
    public static void calcAverageMiles(Car[] cars) {
        //calculating the average of all current cars in lot
        double total = 0;
        double averageMilage;

        for (Car car : cars) {
            total += car.getCarMileage();
        }
        averageMilage = (total / Car.globalNumOfCars);

        System.out.println("\nAverage Mileage: " + averageMilage + " miles");
    }

    public static void calcLowestPrice(Car[] cars) {
        //assume the lowest price is at index 0
        int indexOfLow = 0;

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getCarPrice() < cars[indexOfLow].getCarPrice()) {
                indexOfLow = i;
            }
        }

        System.out.println("\nLowest Price is for Car#" + (indexOfLow + 1));
        System.out.println("\nLowest Price: $" + cars[indexOfLow].getCarPrice());

    }

}

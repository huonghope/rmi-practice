package practice.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;


public class RMIClient {
	
	public static String getRandomString(int size) {
		String rand = "";
		String chars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  	for (int i = 0; i < size; i++) {
			rand += chars.toCharArray()[new Random().nextInt(chars.length())];
		}
		return rand;
	}
	
	public static void main(String[] args) throws SQLException {
		try {
            System.out.println("Waiting...");
            IStoreData iStoreData = (IStoreData) Naming.lookup("rmi://210.94.194.70:5555/cloudRMI");
            int selectTypeProgram = 0;
            int selectNumber = 0;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Connecting..." + iStoreData.testConnect());
            do {
            	System.out.println("==========RMI TEST===========");
            	System.out.println("0. Exit");
            	System.out.println("1. Test Program");
            	System.out.println("2. Operating Program");
            	selectTypeProgram = sc.nextInt();
            	if(selectTypeProgram == 1) {
            		// Test Program
            		System.out.println("0. Exit");
            		System.out.println("1. Write");
                	System.out.println("2. Read");
                	System.out.println("3. Modify");
                	selectNumber = sc.nextInt();
                	if(selectNumber == 1) {
                		int lengthData = 0;
                		int requestCount = 0;
                        System.out.print("Input Length Data: ");
                        lengthData = sc.nextInt();
                     
                        System.out.print("Input Request Count: ");
                        requestCount = sc.nextInt();
                        
                        String randomData = getRandomString(lengthData);
                        
                        long start = System.nanoTime();
                        for (int i = 0; i < requestCount; i++) {
                        	iStoreData.writeData(randomData);							
						}
                        long elapsedTime = System.nanoTime() - start;
                        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                        System.out.println(requestCount + " request with word length : " + lengthData +  " Write Data: Total Time : " + elapsedTimeInSecond + " seconds");
                        System.out.println(requestCount + " request with word length : " + lengthData + " Write Data: Avg Time : " + ( elapsedTimeInSecond / requestCount ) + " seconds");
                	}else if(selectNumber == 2) {
                		int key = 0;
                		int requestCount = 0;
                		System.out.print("Input Read Key: ");
                		key = sc.nextInt();
                		
                		
                		System.out.print("Input Request Count: ");
                        requestCount = sc.nextInt();
                		
                        long start = System.nanoTime();
                        for (int i = 0; i < requestCount; i++) {
                             iStoreData.readData(key).getData();							
						}
                        long elapsedTime = System.nanoTime() - start;
                        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                        System.out.println(requestCount + " request Read Data: Total Time : " + elapsedTimeInSecond + " seconds");
                        System.out.println(requestCount + " request Read Data: Avg Time : " + ( elapsedTimeInSecond / requestCount ) + " seconds");
                		
                	}else if(selectNumber == 3) {
                		int lengthData = 0;
                		int requestCount = 0;
                        System.out.print("Input Length Data: ");
                        lengthData = sc.nextInt();
                		
                		System.out.print("Input Request Count: ");
                        requestCount = sc.nextInt();
                        String randomData = getRandomString(lengthData);
                        long start = System.nanoTime();
                        for (int i = 0; i < requestCount; i++) {
                        	iStoreData.modifyData(i, randomData).getData();							
						}
                        long elapsedTime = System.nanoTime() - start;
                        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                        System.out.println(requestCount + " request Modify Data: Total Time : " + elapsedTimeInSecond + " seconds");
                        System.out.println(requestCount + " request Modify Data: Avg Time : " + ( elapsedTimeInSecond / requestCount ) + " seconds");
                	}else if(selectNumber == 0) {
                		System.out.println("Thankyou using !!!");
                		return;
                	}else {
                		System.out.println("Wrong choice !!!");
                	}
                	
            	}else if(selectTypeProgram == 2) {
            		// Operating Program
            		System.out.println("0. Exit");
            		System.out.println("1. Write");
                	System.out.println("2. Read");
                	System.out.println("3. Modify");
                	selectNumber = sc.nextInt();
                	if(selectNumber == 1) {
                        System.out.print("Input Data: ");
                        sc.nextLine();
                        String data = sc.nextLine();
                        
                        long start = System.nanoTime();  
                        iStoreData.writeData(data);
                        long elapsedTime = System.nanoTime() - start;
                		double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                		System.out.println("Time : " + elapsedTimeInSecond + " seconds");
                		
                	}else if(selectNumber == 2) {
                		System.out.println("Input Key: ");
                		sc.nextLine();
                		int key = sc.nextInt();
                		
                		long start = System.nanoTime();    
                		System.out.println("Return Data: " + iStoreData.readData(key).getData());
                		long elapsedTime = System.nanoTime() - start;
                		double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                		System.out.println("Time : " + elapsedTimeInSecond + " seconds");
                	}else if(selectNumber == 3) {
                		System.out.println("Input Key: ");
                		sc.nextLine();
                		int key = sc.nextInt();
                		
                        System.out.print("Input New Data: ");
                        sc.nextLine();
                        String newData = sc.nextLine();
                        
                        long start = System.nanoTime();    
                        System.out.println("Return Data: " + iStoreData.modifyData(key, newData).getData()); 
                        long elapsedTime = System.nanoTime() - start;
                		double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
                		System.out.println("Time : " + elapsedTimeInSecond + " seconds");
                		
                	}else if(selectNumber == 0) {
                		System.out.println("Thankyou using !!!");
                		return;
                	}else {
                		System.out.println("Wrong choice !!!");
                		return;
                	}
               
            	}else if(selectTypeProgram == 0) {
            		System.out.println("Thankyou using !!!");
            		return;
            	}else {
            		System.out.println("Wrong choice !!!");
            		return;
            	}
            }while(true);
        } catch (NotBoundException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (RemoteException e) {
            System.out.println(e);
            e.printStackTrace();
        }
	}
}

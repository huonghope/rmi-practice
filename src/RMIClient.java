import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;


public class RMIClient {
	public static void main(String[] args) {
		try {
			 
            IStoreData iStoreData = (IStoreData) Naming.lookup("rmi://210.94.194.63:5555/cloudRMI");
            int selectNumber = 0;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Connecting..." + iStoreData.testConnect());
            
            do {
            	System.out.println("0. Exit");
            	System.out.println("1. Write data");
            	System.out.println("2. Read data");
            	System.out.println("3. Modify data");
            	selectNumber = sc.nextInt();
            	if(selectNumber == 1) {
            		System.out.println("Input Key: ");
            		sc.nextLine();
            		int key = sc.nextInt();
            		
                    System.out.print("Input Data: ");
                    sc.nextLine();
                    String data = sc.nextLine();
                    iStoreData.writeData(key, data);
            	}else if(selectNumber == 2) {
            		System.out.println("Input Key: ");
            		sc.nextLine();
            		int key = sc.nextInt();
            		
            		long start = System.nanoTime();    
            		System.out.println("Return Data: " + iStoreData.readData(key).getData());
            		long elapsedTime = System.nanoTime() - start;
            	}else if(selectNumber == 3) {
            		System.out.println("Input Key: ");
            		sc.nextLine();
            		int key = sc.nextInt();
            		
                    System.out.print("Input New Data: ");
                    sc.nextLine();
                    String newData = sc.nextLine();
                    System.out.println("Return Data: " + iStoreData.modifyData(key, newData).getData()); ;
            	}else if(selectNumber == 0) {
            		return;
            	}else {
            		System.out.println("Wrong choice");
            	}
            }while(true);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	}
}

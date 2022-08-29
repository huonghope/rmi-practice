import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
	public static void main(String[] args) throws MalformedURLException {
		try {
            IStoreData rAccount = (IStoreData) new DataServiceImpl();
            Naming.bind("rmi://210.94.194.63:5555/cloudRMI", rAccount);
            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
	}
}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStoreData extends Remote{
	public Data writeData(int key, String data) throws RemoteException;
	public Data readData(int key) throws RemoteException;
	public Data modifyData(int key, String newData) throws RemoteException;
	public String testConnect() throws RemoteException;
}

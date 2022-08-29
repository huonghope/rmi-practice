package practice.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;


public interface IStoreData extends Remote{
	public Data writeData(String data) throws RemoteException, SQLException;
	public Data readData(int key) throws RemoteException, SQLException;
	public Data modifyData(int key, String newData) throws RemoteException, SQLException;
	public List<Data> readDataByCount(int count) throws RemoteException, SQLException;
	public String testConnect() throws RemoteException;
}

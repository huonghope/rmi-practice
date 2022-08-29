import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DataServiceImpl extends UnicastRemoteObject implements IStoreData {
	
	List<Data> listData = (new ListData().importList());
	public DataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Data writeData(int key, String data) throws RemoteException {
		listData.add(new Data(key, data));
		Data newData = new Data();
		for(Data d : listData) {
			if(d.getKey() == key) {
				newData = d;
			}
		}
		return newData;
	}

	@Override
	public Data readData(int key) throws RemoteException {
		Data data = new Data();
		for(Data d : listData) {
			if(d.getKey() == key) {
				data = d;
			}
		}
		return data;
	}

	@Override
	public Data modifyData(int key, String newData) throws RemoteException {
		Data modifiedData = new Data();
		for(Data d : listData) {
			 if(d!= null && d.getKey() == key) {
				d.setData(newData);
				modifiedData = d;
		        break;
		    }
		}
		return modifiedData;
	}
	@Override
	public String testConnect() throws RemoteException {
		return "Hello Client !!!";
	}

}

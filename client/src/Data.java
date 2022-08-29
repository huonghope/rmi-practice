package practice.rmi;
import java.io.Serializable;


public class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private int key;
    private String data;
    
    public Data() {}
    
	public Data(int key, String data) {
		super();
		this.key = key;
		this.data = data;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}   
}
import java.util.ArrayList;
import java.util.List;

public class ListData {
	List<Data> listData = new ArrayList<>();
	
	public List<Data> importList(){
		listData.add(new Data(1, "hello"));
		listData.add(new Data(2, "hi"));
		return listData;
	}
}

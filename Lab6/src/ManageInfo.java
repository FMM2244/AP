import java.util.Set;
import java.util.HashMap;
public class ManageInfo {
	public static void printInfo(IPrint obj)
	{
		HashMap<String,String> printData=obj.getData();
		Set<String> keySet=printData.keySet();
		for(String k:keySet)
		{
			System.out.println(k+" :\t"+printData.get(k));
		}
		
	}

}

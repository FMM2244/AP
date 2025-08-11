import java.util.ArrayList;

public class Company implements IManage {
	private ArrayList<Department> Dept_List;
	private ArrayList<Employee> Emp_List;
	private ArrayList<Project> Prj_List;
	private ArrayList<Record> RCD_List;
	
	public Company(){
		Dept_List=new ArrayList<Department>();
		Emp_List=new ArrayList<Employee>();
		Prj_List=new ArrayList<Project>();
		RCD_List=new ArrayList<Record>();	
	}
	
	public void addItem(String key,Object item)
	{
		switch(key)
		{
		case "Department":
			Dept_List.add((Department)item);
			break;
			
		case "Employee":
			Emp_List.add((Employee)item);
			break;
			
		case "Project":
			Prj_List.add((Project)item);
			break;
			
		case "Record":
			RCD_List.add((Record)item);
			break;
		default:
			System.out.println("Wrong List Name");
			
		}
	}
	
	public Object getItem(String key,Object itemKey)
	{
		switch(key)
		{
		case "Department":
			for(int i=0;i<Dept_List.size();i++)
			{
				if ((int)itemKey==Dept_List.get(i).getID())
					return Dept_List.get(i);
			}
			return null;

		case "Employee":
			for(int i=0;i<Emp_List.size();i++)
			{
				if(Emp_List.get(i).Get_Name().equals((String)itemKey))
					return Emp_List.get(i);
			}
			return null;
			
		case "Project":
			for(int i=0;i<Prj_List.size();i++)
			{
				if((int)itemKey==Prj_List.get(i).getID())
					return Prj_List.get(i);
			}
			return null;
			
		default:
			return null;
				
		}
	}
	
	public void Print(String key)
	{
		switch(key)
		{
		case "Department":
			for(Department D:Dept_List)
			{
				System.out.println(D.getID()+"\t"+D.getName());
			}
			break;
			
		case "Employee":
			for(Employee e:Emp_List)
			{
				System.out.println(e.Get_Name()+" "+e.Get_Address()+" "+e.Get_BDate());
			}
			break;
			
		case "Project":
			for(Project p:Prj_List)
			{
				System.out.println(p.getID()+"\t"+p.Get_Name());
			}
			break;
			
		case "Record":
			for(Record r:RCD_List)
			{
				System.out.println(r.Emp.Get_Name()+"\t"+r.Prj.Get_Name());
			}
			break;
		default:
			System.out.println("Wrong List Name");
			
		}
	}
	

}

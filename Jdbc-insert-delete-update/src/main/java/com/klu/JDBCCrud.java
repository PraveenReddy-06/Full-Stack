package com.klu;
import java.sql.*;
import java.util.Scanner;

public class JDBCCrud {
	static String url="jdbc:mysql://localhost:3306/";
	static String dburl="jdbc:mysql://localhost:3306/JdbcCrud";
	static String usr="root";
	static String pwd="Praveen@06";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(url,usr,pwd);
			Statement st = con.createStatement();
		
			st.executeUpdate("CREATE DATABASE if not exists JdbcCrud");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		createTables();
		
		
		 System.out.println("\n------ MENU ------");
         System.out.println("1. Insert Department");
         System.out.println("2. Insert Employee");
         System.out.println("3. View Employees");
         System.out.println("4. Update Employee Salary");
         System.out.println("5. Delete Employee");
         System.out.println("6. Exit");
         int choice;
		 do{
			 System.out.print("Enter Choice :");
			choice = sc.nextInt();
			 switch(choice) {
			 	case 1: InsertDepart(); break;
			 	case 2: InsertEmp();break;
			 	case 3: VeiwEmployees();break;
			 	case 4: UpdateEmp();break;
			 	case 5: DeleteEmp();break;
			 	case 6: choice=0;break;
			 }
		}while(choice!=0);
}
static void createTables() {
		try {
			Connection con = DriverManager.getConnection(dburl,usr,pwd);
			Statement st = con.createStatement();
			
			String departTable = "Create Table if Not exists Depart(Depart_id int Primary Key,Depart_name varchar(50))";
			String empTable = "Create Table if not exists Emp(Emp_id int primary Key,Emp_name varchar(50),Salary double,Depart_id int, Foreign key(Depart_id)  references Depart(Depart_id))";
			
			st.execute(departTable);
			st.execute(empTable);
			System.out.println("Tables created or already exist.");

        } catch (Exception e) {
            e.printStackTrace();
        }
		
}

static void InsertDepart() {
	try {
		Connection con = DriverManager.getConnection(dburl,usr,pwd);
		Statement st = con.createStatement();
		
		String Insert="Insert into Depart values(?,?)";
		PreparedStatement ps = con.prepareStatement(Insert);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Department Id: ");
		ps.setInt(1, sc.nextInt());
		
		System.out.println("Enter Department Name: ");
		ps.setString(2, sc.next());
		
		ps.executeUpdate();
		System.out.println("Department inserted in Department Table");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

static void InsertEmp() {
	try {
		Connection con = DriverManager.getConnection(dburl,usr,pwd);
		Statement st = con.createStatement();
		
		String insert="insert into Emp values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Emp Name :");
		ps.setString(2, sc.next());
		
		System.out.println("Enter Emp id: ");
		ps.setInt(1, sc.nextInt());
		
		System.out.println("Enter Emp salary: ");
		ps.setDouble(3, sc.nextDouble());
		
		System.out.println("Enter Existing Depart Id: ");
		ps.setInt(4,sc.nextInt());
		
		ps.executeUpdate();
		System.out.println("Inserted Emp into Emp Table");
	}
	catch (Exception e){
		e.printStackTrace();
	}
}

static void VeiwEmployees() {
	try {
		Connection con = DriverManager.getConnection(dburl,usr,pwd);
		
		String veiw = "Select e.Emp_id,e.Emp_Name,e.Salary,d.Depart_name,d.Depart_id from Emp e JOIN Depart d ON e.Depart_id = d.Depart_id";
		PreparedStatement ps = con.prepareStatement(veiw);
		ResultSet rs=ps.executeQuery();
		
		while (rs.next()) {
            System.out.println(
                rs.getInt("Emp_id") + " | " +
                rs.getString("Emp_Name") + " | " +
                rs.getDouble("Salary") + " | " +
                rs.getString("Depart_name") + " | " +
                rs.getInt("Depart_id")
            );
        }
	}
	catch (Exception e){
		e.printStackTrace();
	}
	
}
static void UpdateEmp() {
    try (Connection con = DriverManager.getConnection(dburl, usr, pwd)) {

        String sql = "UPDATE Emp SET Salary=? WHERE Emp_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Emp ID: ");
        ps.setInt(2, sc.nextInt());

        System.out.print("Enter New Salary: ");
        ps.setDouble(1, sc.nextDouble());

        ps.executeUpdate();
        System.out.println("Employee updated!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

static void DeleteEmp() {
	try (Connection con = DriverManager.getConnection(dburl,usr,pwd)) {
		
		String update= "Delete from Emp Where Emp_id=?";
		
		PreparedStatement ps = con.prepareStatement(update);
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Emp_id you want to delete: ");
		ps.setInt(1,sc.nextInt());
		ps.executeUpdate();
		
		System.out.print("Emp Deleted from Emp Table");
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}


}

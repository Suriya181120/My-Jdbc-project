package mycrud;
import java.sql.*;
import java.util.Scanner;

public class Mycrud {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/DBEmp";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);

		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement st;

		String qry;
		int id, age, choice;
		double salary;
		String name, gender, department, designation, contact, email, address;
		Date joinDate;

		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);

		while (true) {
			System.out.println("MySQL Java CRUD Operation - EMPLOYEE");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Select");
			System.out.println("5. Exit");
			System.out.print("Enter a choice: ");
			choice = in.nextInt();
			System.out.println("-----------------------------------------");

			switch (choice) {
			case 1:
				System.out.println("1. Insert New Employee");

				System.out.print("Enter Name: ");
				name = str.nextLine();
				System.out.print("Enter Age: ");
				age = in.nextInt();
				System.out.print("Enter Gender: ");
				gender = str.nextLine();
				System.out.print("Enter Department: ");
				department = str.nextLine();
				System.out.print("Enter Designation: ");
				designation = str.nextLine();
				System.out.print("Enter Salary: ");
				salary = in.nextDouble();
				System.out.print("Enter Join Date (YYYY-MM-DD): ");
				joinDate = Date.valueOf(str.nextLine());
				System.out.print("Enter Contact No: ");
				contact = str.nextLine();
				System.out.print("Enter Email: ");
				email = str.nextLine();
				System.out.print("Enter Address: ");
				address = str.nextLine();

				qry = "INSERT INTO employee (name, age, gender, department, designation, salary, join_date, contact, email, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				st = con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, gender);
				st.setString(4, department);
				st.setString(5, designation);
				st.setDouble(6, salary);
				st.setDate(7, joinDate);
				st.setString(8, contact);
				st.setString(9, email);
				st.setString(10, address);

				st.executeUpdate();
				System.out.println("Employee inserted successfully.");
				break;

			case 2:
				System.out.println("2. Update Employee Details");
				System.out.print("Enter Employee ID to Update: ");
				id = in.nextInt();

				System.out.print("Enter Name: ");
				name = str.nextLine();
				System.out.print("Enter Age: ");
				age = in.nextInt();
				System.out.print("Enter Gender: ");
				gender = str.nextLine();
				System.out.print("Enter Department: ");
				department = str.nextLine();
				System.out.print("Enter Designation: ");
				designation = str.nextLine();
				System.out.print("Enter Salary: ");
				salary = in.nextDouble();
				System.out.print("Enter Join Date (YYYY-MM-DD): ");
				joinDate = Date.valueOf(str.nextLine());
				System.out.print("Enter Contact No: ");
				contact = str.nextLine();
				System.out.print("Enter Email: ");
				email = str.nextLine();
				System.out.print("Enter Address: ");
				address = str.nextLine();

				qry = "UPDATE employee SET name=?, age=?, gender=?, department=?, designation=?, salary=?, join_date=?, contact=?, email=?, address=? WHERE id=?";
				st = con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, gender);
				st.setString(4, department);
				st.setString(5, designation);
				st.setDouble(6, salary);
				st.setDate(7, joinDate);
				st.setString(8, contact);
				st.setString(9, email);
				st.setString(10, address);
				st.setInt(11, id);

				st.executeUpdate();
				System.out.println("Employee updated successfully.");
				break;

			case 3:
				System.out.println("3. Delete Employee");
				System.out.print("Enter Employee ID to Delete: ");
				id = in.nextInt();

				qry = "DELETE FROM employee WHERE id=?";
				st = con.prepareStatement(qry);
				st.setInt(1, id);
				st.executeUpdate();
				System.out.println("Employee deleted successfully.");
				break;

				
			case 4:
				System.out.println("4. Employee Records");
				qry = "SELECT * FROM employee";
				rs = stmt.executeQuery(qry);

				while (rs.next()) {
					System.out.println(
						rs.getInt("id") + " | " +
						rs.getString("name") + " | " +
						rs.getInt("age") + " | " +
						rs.getString("gender") + " | " +
						rs.getString("department") + " | " +
						rs.getString("designation") + " | " +
						rs.getDouble("salary") + " | " +
						rs.getDate("join_date") + " | " +
						rs.getString("contact") + " | " +
						rs.getString("email") + " | " +
						rs.getString("address"));
				}
				break;

			case 5:
				System.out.println("Thank You!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice.");
				break;
			}
			System.out.println("-----------------------------------------");
		}
	}
}

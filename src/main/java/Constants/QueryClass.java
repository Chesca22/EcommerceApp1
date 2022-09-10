package Constants;

public class QueryClass {
    public static String Login_query = ("select * from Users where email= ? and password= ?");
    public static String RegisterUser_query = ("insert  into users(firstName,LastName,email,password)values (?,?,?,?)");
    public static String Price_query = ("select price from Product where id=?");
    public static String Product_query=("select * from Product where id=?");
    public static String AllProduct_query=("select * from Product");
    public static String Order_query = ("insert into Orders (p_id, u_id, o_quantity, o_date) values(?,?,?,?)");
    public static String AdminLogin_query = ("select * from Admin_details where username= ? and password= ?");
    public static String AdminRegister_query = ("insert  into Admin_details (firstName,LastName,username,password)values (?,?,?,?)");

}

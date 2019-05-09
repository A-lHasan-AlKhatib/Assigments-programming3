package Assigment8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Handy
 */
public class In {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM invoice");
        ArrayList<Invoice> list = new ArrayList<>();
        ResultSet set = ps.executeQuery();
        while(set.next()){
            int num = set.getInt("partNum");
            String desc = set.getString("partDesc");
            int quantity = set.getInt("quantity");
            double price = set.getDouble("price");
            Invoice temp = new Invoice(num, desc, quantity, price);
            list.add(temp);
        }
        System.out.println("Sort By Dec");
        list.stream().sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
        System.out.println("***************************************************");
        System.out.println("Sort By Price");
        list.stream().sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
        System.out.println("***************************************************");
        System.out.println("Sort By Quantity");
        list.stream().sorted(Comparator.comparing(Invoice::getQuantity))
                .forEach(System.out::println);
        System.out.println("***************************************************");
         list.stream().sorted(Comparator.comparing(Invoice::getValue))
                 .map(in -> in.getValue() + " : " + in.getPartDescription())
                .forEach(System.out::println);
         System.out.println("***************************************************");
         System.out.println("Filterd By Value");
         list.stream().sorted(Comparator.comparing(Invoice::getValue))
                 .filter(in -> in.getValue() >= 200 && in.getValue()<=500)
                 .map(in -> in.getValue() + " : " + in.getPartDescription())
                .forEach(System.out::println);
  
  
    }
}

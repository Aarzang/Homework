import com.pflb.learning.workmethods.*;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String role;
        String[] Data;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user role:");
        role = sc.nextLine();

        Data = Finder.GetData(role);
        System.out.println("\nlogin:" + Data[0] +
        "\npassword:" + Data[1]);

    }
}

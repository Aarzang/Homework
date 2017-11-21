package com.pflb.learning.workmethods;

import java.sql.*;

public class Finder {

    private Finder(){};

    public static String[] GetData(String usrrole) throws ClassNotFoundException, SQLException {
        String[] UserData = new String[2];

        if(usrrole.equals("user") || usrrole.equals("administrator")) {

            String url = "jdbc:mysql://217.24.197.81:3308/atschool101";
            String log = "*";
            String pass = "*";

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, log, pass);

            PreparedStatement st = connection.prepareStatement("SELECT login, password FROM peoples WHERE role = ? ");
            st.setString(1, usrrole);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                UserData[0] = rs.getString("login");
                UserData[1] = rs.getString("password");
            }
        }
        else{
            System.out.println("INVALID ROLE");
            UserData[0] = "None";
            UserData[1] = "None";
        }

        return UserData;
    }

}

package com.progress;


import java.sql.*;


public class JDBCUtil {

    String className, URL, user, password;
    Connection connection;

    public JDBCUtil(String className, String URL, String user, String password) {
        this.className = className;
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.connection = null;
    }

    public void getConnection() {

        //Load the driver class
        try {
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            System.out.println("Unable to load the class. Terminating the program");
            System.exit(-1);
        }

        //get the connection
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException ex) {
            System.out.println("Error getting connection: " + ex.getMessage());
            System.exit(-1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(-1);
        }

        if(connection != null)
        {
            System.out.println("Connected Successfully!");
        }

    }

    public void executeQuery(String query)
    {
        ResultSet resultSet = null;
        try
        {
            //executing query
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnsNumber = metaData.getColumnCount();


            //Printing the results
            while(resultSet.next())
            {

                for(int i = 1; i <= columnsNumber; i++)
                {
                    System.out.printf("%-25s", (resultSet.getObject(i) != null)?resultSet.getObject(i).toString(): null );
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Exception while executing statement. Terminating program... " + ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.println("General exception while executing query. Terminating the program..." + ex.getMessage());
        }




    }








}

package com.progress;


import java.util.Scanner;

public class SalesforceDB {
    JDBCUtil jdbcUtil ;
    String className ;

    public SalesforceDB()
    {
        this.className = "com.ddtek.jdbc.sforce.SForceDriver";
        this.jdbcUtil = null;
    }

    public void initiateConnection()
    {
        Scanner scanner = new Scanner(System.in);

        //Fetching server details for connection
        System.out.println("Enter the Postgres server address: ");
        String hostname = scanner.nextLine();




        System.out.println("Enter your Username: ");
        String userName = scanner.nextLine();


        System.out.println("Enter your password: ");
        String password = scanner.nextLine();


        System.out.println("Paste your secret token: ");
        String secretToken = scanner.nextLine();


        StringBuffer URL = new StringBuffer();
        URL.append("jdbc:datadirect:sforce://");
        URL.append(hostname + ";SecurityToken=" + secretToken);
        jdbcUtil = new JDBCUtil(className,URL.toString(), userName, new String(password));
        jdbcUtil.getConnection();


    }

    public void executeSimpleQuery()
    {
        System.out.println("Enter your SQL query here: ");
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();
        jdbcUtil.executeQuery(query);

    }


}

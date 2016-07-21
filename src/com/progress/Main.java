package com.progress;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        //Printing Info
        System.out.println("Choose the DataSource that you would like to connect to:");
        System.out.println("1. Postgres");
        System.out.println("2. Salesforce");
        System.out.println("3. Apache Spark SQL");

        //Reading choice from user
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        try
        {
            choice = Integer.parseInt(keyboard.nextLine());
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Invalid Input. Terminating the program");
            exit(-1);
        }
        catch (Exception ex)
        {
            System.out.println("Error:\n " + ex.getMessage());
        }


        //Calling appropriate methods based on selection
        switch(choice){
            case 1:
                PostgresDB postgresDB = new PostgresDB();
                postgresDB.initiateConnection();
                postgresDB.executeSimpleQuery();
                break;
            case 2:
                SalesforceDB salesforceDB = new SalesforceDB();
                salesforceDB.initiateConnection();
                salesforceDB.executeSimpleQuery();
                break;
        }





    }




}

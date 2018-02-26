package com;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.microsoft.*;
import com.microsoft.sqlserver.*;  
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DAO {

	// Connect to your database.  
    // Replace server name, username, and password with your credentials  
	private static final String sproc = "{call [Ten Most Expensive Products] }";
	public  List<Customer> reporteClientes() throws SQLException { 
		
		

		List<Customer> customers = new ArrayList<>();
		Customer custom=new Customer();
        String connectionString =  
            "jdbc:sqlserver://127.0.0.1:1433;"  
            + "database=Northwind;"  
            + "user=sa;"  
            + "password=holamarce25;";  

        // Declare the JDBC objects.  
        Connection connection = null;  
        Statement statement = null;   
        ResultSet resultSet = null; 
        
        
        
            connection = DriverManager.getConnection(connectionString);  
            System.out.println("Conectado");
            
            CallableStatement cs = connection.prepareCall(sproc);
            resultSet = cs.executeQuery();
            
            
            while (resultSet.next()) {
                           	
            	customers.add(new Customer(resultSet.getString("TenMostExpensiveProducts"),resultSet.getFloat("UnitPrice")));
           	}
      
        connection.close();
        
        custom.companyname="pepito";
    	custom.precio=990;
    	customers.add(custom);
        return customers;
    }  
	
	/*
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("TOdo guagua");
		List<Customer> listica=reporteClientes();		
		 Gson gson = new Gson();
		 String json = gson.toJson(listica);  
         //pintamos el json en la consola para ver el resultado
         System.out.println(json);  
		
		System.out.println("Hello Fucking \n World");
	}
	*/
}

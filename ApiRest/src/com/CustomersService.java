
package com;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


@Path("/clientes")
public class CustomersService {
       // private static final long serialVersionUID = 1L;
        @GET
        @Produces("application/json")
        public Response getUsers() throws JSONException, SQLException {
        	
        	 DAO clienteDAO = new DAO();
        	 List<Customer> lista = new ArrayList<>();
     		 Customer custom=new Customer();
     		 custom.companyname="pepito";
     		 custom.precio=990;
     		 lista.add(custom);
     		 custom=new Customer();
    		 custom.companyname="pepita";
    		 custom.precio=777;
    		 lista.add(custom);
    		 custom=new Customer();
     		 custom.companyname="guagua";
     		 custom.precio=123;
     		 lista.add(custom);
             //List<Customer> lista = clienteDAO.reporteClientes();
             //jackson convierte tu objeto en json
             Gson gson = new Gson();
    		 String json = gson.toJson(lista);  
             //pintamos el json en la consola para ver el resultado
             System.out.println(json);  
             //return Response.status(200).entity(lista.toString()).build();
             return Response.status(200).entity(json).build();
             
        }
}
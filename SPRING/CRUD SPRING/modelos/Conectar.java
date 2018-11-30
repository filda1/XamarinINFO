
package com.manosenelcodigo.modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
 
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/prueba");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
}

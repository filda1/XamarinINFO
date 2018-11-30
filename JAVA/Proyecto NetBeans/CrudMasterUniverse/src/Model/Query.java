package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query extends ConnectionDB {
    
      public boolean registrar(Person per) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO he_man (nombre,ocupacion,edad) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getOcupacion());
            ps.setInt(3, per.getEdad());                   
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        } 
      }
      
    public boolean modificar(Person per) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE he_man SET  nombre=?, ocupacion=?, edad=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getOcupacion());
            ps.setInt(3, per.getEdad());     
            ps.setInt(4, per.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean buscar(Person per) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM he_man WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               per.setId( rs.getInt("id"));
               per.setNombre(rs.getString("Nombre"));
               per.setOcupacion(rs.getString("Ocupacion"));
               per.setEdad(rs.getInt("Edad"));
               return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
        public boolean eliminar(Person per) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM he_man WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, per.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}


    
    


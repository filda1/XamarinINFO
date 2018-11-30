package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class consultaDB extends conexionDB {
    
  public boolean registrar(vehiculo ve) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO auto (Placa,Propietario,tipo,entrada,salida,estado) VALUES(?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ve.getPlaca());
            ps.setString(2, ve.getPropietario());
            ps.setString(3, ve.getTipo());  
            ps.setString(3, ve.getEntrada());  
            ps.setString(3, ve.getSalida());  
            ps.setString(3, ve.getEstado());  
            
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

   public boolean buscar(vehiculo ve) {
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM auto WHERE Placa=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ve.getPlaca());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
               ve.setId (rs.getInt("Id"));
               ve.setPlaca( rs.getString("Placa"));
               ve.setPropietario(rs.getString("Propietario"));
               ve.setTipo(rs.getString("tipo"));
               ve.setEntrada(rs.getString("entrada"));
               ve.setSalida(rs.getString ("salida"));
               ve.setEstado(rs.getString("estado"));
              
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
       public List<vehiculo> read() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM auto ";
        
        List<vehiculo> newList = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);       
            rs = ps.executeQuery();

            while (rs.next()) {

                vehiculo ve = new vehiculo();

               ve.setId (rs.getInt("Id"));
               ve.setPlaca( rs.getString("Placa"));
               ve.setPropietario(rs.getString("Propietario"));
               ve.setTipo(rs.getString("tipo"));
               ve.setEntrada(String.valueOf(rs.getDate("entrada")));
               ve.setSalida(String.valueOf(rs.getString ("salida")));
               ve.setPago(rs.getFloat("pago"));
               ve.setEstado(rs.getString("estado"));
               
                newList.add(ve);
            }

             } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return newList;

    }
}

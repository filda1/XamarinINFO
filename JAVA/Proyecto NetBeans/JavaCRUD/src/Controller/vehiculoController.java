
package Controller;

import Model.consultaDB;
import Model.vehiculo;
import View.frm_Ingresar;
import View.frm_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class vehiculoController implements ActionListener {
    
    private vehiculo modelo;
    private consultaDB consulta;
    private frm_Ingresar vista;

    
    public vehiculoController(vehiculo ve, consultaDB co, frm_Ingresar view){
        
        this.modelo = ve;
        this.consulta = co;
        this.vista = view;
        
        this.vista.btn_Guardar.addActionListener(this);
        this.vista.ra_Masculino.addActionListener(this);
        this.vista.ra_Femenino.addActionListener(this);
        
        
    }
    
         public void iniciar() {
          // vista.setTitle("Registro de vehiculos");
          //vista.setLocationRelativeTo(null);
           }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         String tipo ;
      
         
         if (e.getSource () == vista.ra_Masculino){
            tipo = "Automovil";
            
         }else {
             
            tipo = "Motocicleta";
         }
             
                   
         if (e.getSource() == vista.btn_Guardar) 
            modelo.setPlaca(vista.tf_IngresarPlaca.getText());
            modelo.setPropietario(vista.tf_IngresarPropietario.getText());
            modelo.setTipo(tipo);
            modelo.setEntrada("2008-08-12 09:12:00");
            modelo.setEntrada("2008-08-13 19:12:00");
            modelo.setEntrada("Disponible");
            
            if(consulta.registrar(modelo))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
    }
    
         public void limpiar()
         {
           vista.tf_IngresarPlaca.setText (null);
           vista.tf_IngresarPropietario.setText (null);
         }    
         
    
}

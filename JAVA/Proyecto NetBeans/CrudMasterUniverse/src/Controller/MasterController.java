package Controller;
import Model.Person;
import Model.Query;
import View.DisplayView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class MasterController implements ActionListener {
 
    private Person per;
    private Query que;
    private DisplayView dis;
    
    public MasterController(Person per, Query que, DisplayView dis){
        
        this.per = per;
        this.que = que;
        this.dis = dis;
        
        this.dis.btn_Save.addActionListener(this);
        this.dis.btn_Buscar.addActionListener(this);
        this.dis.btn_Modificar.addActionListener(this);
        this.dis.btn_Eliminar.addActionListener(this);
           
    }
    
       public void iniciar() {
        dis.setTitle("Master of Universe");
        dis.setLocationRelativeTo(null);
        dis.tf_Id.setVisible(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == dis.btn_Save) 
            per.setNombre(dis.tf_Nombre.getText());
            per.setOcupacion(dis.tf_Ocupacion.getText());
            per.setEdad(Integer.parseInt(dis.tf_Edad.getText()));
            
            
            if(que.registrar(per))
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }

            if (e.getSource() == dis.btn_Modificar) {
            per.setId(Integer.parseInt(dis.tf_Id.getText()));
            per.setNombre(dis.tf_Nombre.getText());
            per.setOcupacion(dis.tf_Ocupacion.getText());
        
            if(que.modificar(per))
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

         if (e.getSource() == dis.btn_Eliminar) {
            per.setId(Integer.parseInt(dis.tf_Id.getText()));
            
            if(que.eliminar(per))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
         }
         
           if (e.getSource() == dis.btn_Buscar) {
            per.setId(Integer.parseInt(dis.tf_Id.getText()));
            
            if(que.buscar(per))
            {
                dis.tf_Id.setText(String.valueOf(per.getId()));
                dis.tf_Nombre.setText(per.getNombre());
                dis.tf_Ocupacion.setText(per.getOcupacion());
                dis.tf_Edad.setText(String.valueOf(per.getEdad()));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
           }
   }
    
    

       public void limpiar()
    {
        dis.tf_Id.setText(null);
        dis.tf_Nombre.setText(null);
        dis.tf_Ocupacion.setText(null);
        dis.tf_Edad.setText(null);
    }      
       
}
    



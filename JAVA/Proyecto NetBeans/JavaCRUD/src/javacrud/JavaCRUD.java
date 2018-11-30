package javacrud;

import Controller.TablaController;
import Controller.vehiculoController;
import Model.consultaDB;
import Model.vehiculo;
import View.TablaView;
import View.frm_Ingresar;
import View.frm_Principal;

public class JavaCRUD {

    public static void main(String[] args) {
        
        vehiculo modelo = new vehiculo();
        consultaDB consulta = new consultaDB();
        frm_Ingresar vistaIngresar = new frm_Ingresar();
        frm_Principal pr = new frm_Principal();
        TablaView vistaTabla = new TablaView();
        
        
        vehiculoController ve = new vehiculoController (modelo, consulta, vistaIngresar);
        TablaController tabla = new TablaController(modelo,consulta,vistaTabla,pr);
        ve.iniciar();
       // vistaTabla.setVisible(true);   
       pr.setVisible(true);   
      
    }    
}

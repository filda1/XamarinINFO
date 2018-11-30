package Controller;
import Model.consultaDB;
import Model.vehiculo;
import View.TablaView;
import View.frm_Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import javax.swing.table.DefaultTableModel;


public class TablaController implements ActionListener {

    private vehiculo modelo;
    private consultaDB consulta;
    private TablaView vista;
    private frm_Principal vistaPrincipal;
    private DefaultTableModel tabla;
    
       public TablaController(vehiculo ve, consultaDB cons, TablaView view, frm_Principal view2) throws ParseException{
                    
          this.modelo = ve;
          this.consulta = cons;
          this.vista = view;
          this.vistaPrincipal = view2;
              
          this.vista.btn_Buscar.addActionListener(this);
          this.vista.btn_Cerrar.addActionListener(this);

          this.vistaPrincipal.btn_Lista.addActionListener(this);
          
          DefaultTableModel table = (DefaultTableModel) vista.ta_Lista.getModel();
          table.setRowCount(0);
          this.tabla = table;
                  
         // readJTable();
         readNonRepeated();
       }
    
       public void iniciar (){
           this.vista.setTitle("Registro");
           this.vista.setLocationRelativeTo(null);
       }
       
            
       @Override
       public void actionPerformed(ActionEvent e) {
             
        //  if (e.getSource()== vistaPrincipal.btn_Lista){
             

           // }
       
       }

        public void readJTable() {
            
             System.out.println ("Ola");
            tabla.setNumRows(0);
            
            for (vehiculo p : consulta.read()) {

            tabla.addRow(new Object[]{
                p.getId(),
                p.getPlaca(),
                p.getPropietario(),
                p.getTipo(),
                p.getEntrada(),
                p.getSalida(),
                p.getEstado()
            });

          }
       }  
        
       public void readNonRepeated() throws ParseException{

           List<vehiculo> full = consulta.read();           
             List<String> listUnique = ListOnlyRow(full);
 
               List<vehiculo> emptyList = new ArrayList<vehiculo>();
               
              int n= (full.size())-1;
                    float total = 0;
             // System.out.println(n);
             
              for(int i = 0; i < listUnique.size(); i++){
                  
                  for(int j = 0; j < full.size(); j++){
                      
                     
                     if (  listUnique.get(i) == null ? (full.get(j).getPlaca()) == null : listUnique.get(i).equals(full.get(j).getPlaca())){
                         
                   String date1 = "21-9-2017 13:00:00";
                   String date2 = "21-9-2017 19:00:00";
              //  DateFormat formatter = new SimpleDateFormat("MM/dd/yy H:m:s");
              //  Date dad = (Date)formatter.parse("01/29/02 19:38:09");
                    
                Time time = new Time(22, 30, 0);
               /* SimpleDateFormat smp = new SimpleDateFormat("HH:ii:ss");
                Date data2 = smp.parse("16:16:24");
                Date data3 = new Date(data2.getTime());*/
               
              
               System.out.println(time);
            
               // System.out.println("Hora:"+""+ dad);
                
                         String begin = full.get(j).getEntrada();
                         //Date beginDate = begin.p;
                         
                        total += full.get(j).getPago();                             
                     }                  
                   }
                                         
                    emptyList.add(new vehiculo(full.get(i).getId(),full.get(i).getPlaca(),
                                "Ola",full.get(i).getTipo(),full.get(i).getEntrada(),
                                 full.get(i).getSalida(),String.valueOf(total)));
                         
                 // System.out.println(total);
                    

                  for (vehiculo p : emptyList) {

                    tabla.addRow(new Object[]{
                       p.getId(),
                       p.getPlaca(),
                       p.getPropietario(),
                       p.getTipo(),
                       p.getEntrada(),
                       p.getSalida(),
                       p.getEstado()
                    });
                 }                    
              }       
       }
        public List<String> ListOnlyRow(List<vehiculo> uni) {
            
             List<vehiculo> full = consulta.read();
   
            List<String> listString= new ArrayList<String>();
           // list.add("A");
            
             
              for(int i = 0; i < full.size(); i++){
                  
                  listString.add(full.get(i).getPlaca());
              }
            
              //******* Busca valores unicos: (HashSet(unicos y desordenedas)
              //                              TreeSet (unicos y ordenados Ascendente)
              //                              LinkedHashSet (unicos ordenados y ordena como carga)
                           
             TreeSet<String> noRepeted = new TreeSet<String>(listString) ;
             List<String> newUnique = new ArrayList<>(noRepeted);
              
              return newUnique;
           
       }  
        
   
    
}

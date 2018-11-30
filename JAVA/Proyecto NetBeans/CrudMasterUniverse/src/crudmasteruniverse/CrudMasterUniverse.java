
package crudmasteruniverse;

import Controller.MasterController;
import Model.Person;
import Model.Query;
import View.DisplayView;


public class CrudMasterUniverse {

    public static void main(String[] args) {

        Person per = new Person();
        Query que = new Query();
        DisplayView  dis = new DisplayView();
        
        MasterController mas = new MasterController(per,que,dis);
        mas.iniciar();
        dis.setVisible(true);            
    }
    
}

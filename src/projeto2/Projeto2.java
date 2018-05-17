
package projeto2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Projeto2 {

    public static void main(String[] args){
        Cliente cli = new Cliente();
        cli.setNome("Campinho");
        cli.setMorada("Barcelos");
        cli.setcPostal("4200-000");
        /*try{
            cli.retrieve(5);
        } catch (SQLException ex) {
            Logger.getLogger(Projeto2.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            cli.createGOOD();
        } catch (SQLException ex) {
            Logger.getLogger(Projeto2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            cli.delete();
        }
        catch(SQLException ex){
            
        }
    }    
}

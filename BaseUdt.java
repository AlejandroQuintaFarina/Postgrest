package baseudt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseUdt {
    
    public static Connection Conexion() throws SQLException{
        String driver = "jdbc:postgresql:";
        String host = "//localhost:"; 
        String porto = "5432";
        String sid = "postgres";
        String usuario = "dam1a";
        String password = "castelao";
        String url = driver + host+ porto + "/" + sid;
        Connection conn = DriverManager.getConnection(url,usuario,password);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        conn = Conexion();
        Statement stmt = conn.createStatement();
        
        //insertar fila
        
        String codigo = "p7";
        String descricion = "probando";
        int prezo = 5;
        String cidade = "Vigo";
        int codpost = 4444;
        
        
        
        String cadeai = "insert into produtos values ('"+ codigo +"','"+ descricion +"'," + prezo +", ('"+ cidade +"', " + codpost +"))";//ojo
        
        //stmt.executeUpdate(cadeai);
        
        
        //actualizar una fila
       // codigo = "p6";
        descricion = "dato";
        prezo = 50;
        cidade = "Barno";
         codpost = 4444;
        
        //String cadeau = "update produtos set descricion ='" +descricion + "' , prezo = " + prezo + ", ci.cidade = '" + cidade + "' where codigo = '" + codigo + "'";
        
        //stmt.executeUpdate(cadeau);
        
        //
        cidade = "Vigo";
        String cadeau2 = "update produtos set ci.cp = (ci).cp+1 where (ci).cidade= '" +cidade+"'";        
        stmt.executeUpdate(cadeau2);
       
        //consulta unica
       String consultaunica = "select produtos.*, (ci).cidade, (ci).cp from produtos where codigo= '" +codigo+"'";//ojo
       ResultSet r = stmt.executeQuery(consultaunica);
       r.next();
      codigo = r.getString("codigo");//ojo 
      descricion = r.getString("descricion");
      prezo = r.getInt("prezo");
      cidade = r.getString("cidade");
      codpost= r.getInt("cp");
            
       System.out.println( codigo +","+ descricion +"," + prezo +", "+ cidade +", " + codpost );
        //listado
//      
//        String consultalistado = "select produtos.*, (ci).cidade, (ci).cp from produtos where (ci).cidade= '" +cidade+"'";//ojo
//        ResultSet resulton = stmt.executeQuery(consultalistado);
//        while(resulton.next()){
//            codigo = resulton.getString("codigo");//ojo con las comillas en los nombres de los campos, SE PONEN SIEMPRE
//            descricion = resulton.getString("descricion");
//            prezo = resulton.getInt("prezo");
//            cidade = resulton.getString("cidade");
//            codpost= resulton.getInt("cp");
//            
//            
//            System.out.println( codigo +","+ descricion +"," + prezo +", "+ cidade +", " + codpost );
//        }
//        
        stmt.close();
        
        
        
        
        
        
        conn.close();
        
    }
    
}

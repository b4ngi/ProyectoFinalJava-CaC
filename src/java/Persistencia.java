
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Persistencia {
    
    private Connection conexion;
    private ResultSet rs;
    private PreparedStatement ps;
    private ResultSetMetaData rsm;
    
    public String servidor, basededatos, usuario, clave, ejecutar;
    
    public Connection conectarse(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            servidor = "localhost:3306/";
            basededatos = "cacproyecto";
            usuario = "root";
            clave = "";

            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + servidor + basededatos + "?autoReconnect=true&useSSL=false",usuario,clave);
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    public ResultSet consultaSQL(String busqueda){
        try {
            ps = conectarse().prepareStatement(busqueda);
            rs = (ResultSet) ps.executeQuery();
            rsm = rs.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void insertarUsuarioSQL(String usuario, String clave, String nombreYApellido){
        try {
            ps = conectarse().prepareStatement("INSERT INTO `usuarios` (`usuario`, `clave`, `nombreyapellido`) VALUES (?, ?, ?)");
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ps.setString(3, nombreYApellido);
            //Logger.getLogger(ps.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

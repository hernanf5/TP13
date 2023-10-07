       
package tp13;

import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author Hernán Funes
 */
public class TP13 {

    
    public static void main(String[] args) {
        
        try{
            //cargo driver
            Class.forName("org.mariadb.jdbc.Driver");
            
            //establezco conexion
            String URL = "jdbc:mariadb://localhost:3306/registro";
            String usuario="root";
            String password="";
            Connection con = DriverManager.getConnection(URL, usuario, password);
            
                        //Dar de alta los alumnos
//            String sql="INSERT INTO alumno (dni,apellido, nombre, fechaNacimiento, estado)"
//                    + "VALUES (33333333,'Lopez', 'Jose', '2005-05-31', true),"
//                    + "(22222222,'Funes','Hernan','1995-08-09',true),"
//                    + " (11111111,'Fuentes','Franco','1995-08-09',true)";
//            
//            PreparedStatement ps=con.prepareStatement(sql);
//           int filas= ps.executeUpdate();
//            if(filas>0){
//            
//                JOptionPane.showMessageDialog(null, "Alumnos Agregados");
//            }
                        //Dar de alta las materias
//            String sql="INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Matematica', 1, true),"
//                    + "('Laboratorio', 2, true),"
//                    + "('EDA', 2, true),"
//                    + " ('web 1', 3, true)";
//            
//            PreparedStatement ps=con.prepareStatement(sql);
//           int filas= ps.executeUpdate();
//            if(filas>0){
//            
//                JOptionPane.showMessageDialog(null, "Materias Agregadas");
//            }
            

            //Inscribir a los 3 alumnos en 2 materias cada uno.
//            String sql="INSERT INTO inscripcion (nota,idAlumno, idMateria)"
//                    + "VALUES (9, 5, 1),"
//                    +"(5, 5, 4),"
//                    +"(7, 6, 2),"
//                    +"(8, 6, 3),"
//                    +"(10, 7, 4),"
//                    +"(9, 7, 1)";
//            PreparedStatement ps =con.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//            if(filas>0){
//                JOptionPane.showMessageDialog(null, "Alumnos inscriptos");
//            }



            
             //Obtener los datos de los alumnos activos.
//             String sql="SELECT * FROM alumno WHERE estado=true";
//             PreparedStatement ps=con.prepareStatement(sql);
//             ResultSet rs=ps.executeQuery();
//             while(rs.next()){
//             
//                 int id=rs.getInt("idAlumno");
//                 int dni=rs.getInt("dni");
//                 String apellido=rs.getString("apellido");
//                 String nombre=rs.getString("nombre");
//                 LocalDate fechN=rs.getDate("fechaDeNacimiento").toLocalDate();
//                 boolean estado=rs.getBoolean("estado");
//                 
//                 System.out.println("-----------------------------");
//                 System.out.println("Dni "+dni);
//                 System.out.println("Apellido "+apellido);
//                 System.out.println("Fecha "+fechN.toString());
//             }
//             
////             con.close();

                        //Buscar alumnos donde la nota sea mayor a 8
//            String sql="SELECT DISTINCT a.* from alumno a JOIN inscripcion i ON (a.idAlumno=i.idAlumno) WHERE i.nota > 8";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                int id=rs.getInt("idAlumno");
//                int dni=rs.getInt("dni");
//                String apellido=rs.getString("apellido");
//                String nombre=rs.getString("nombre");
//                LocalDate fechN=rs.getDate("fechaNacimiento").toLocalDate();
//                boolean estado=rs.getBoolean("estado");
//                
//                
//                 System.out.println("-----------------------------");
//                 System.out.println("Dni "+dni);
//                 System.out.println("Apellido "+apellido);
//                 System.out.println("Fecha "+fechN.toString());
//            }
//            con.close();

                    //dar de baja un alumno
//             String sql = "UPDATE alumno SET estado = false WHERE dni = 33333333";
//             PreparedStatement ps = con.prepareStatement(sql);
//             int fila = ps.executeUpdate();
//             if(fila>0){
//                 System.out.println("Alumno dado de baja exitosamente!!!");
//             }
//             con.close();

                //Desinscribir un alumno de una de la materias.
//                String sql = "DELETE FROM inscripcion WHERE idAlumno = 5 AND idMateria =1";
//                PreparedStatement ps = con.prepareStatement(sql);
//                int fila = ps.executeUpdate();
//                if(fila>0){
//                    JOptionPane.showMessageDialog(null, "Inscripcion anulada con exito");
//                }else{
//                    JOptionPane.showMessageDialog(null, "No se encontro la inscripcion");
//                }
//                con.close();
             
            
        }catch(ClassNotFoundException cnf){
            JOptionPane.showMessageDialog(null,"Error al cargar Driver");
        }catch(SQLException ex){
            int error=ex.getErrorCode();
            if(error==1146){
                JOptionPane.showMessageDialog(null,"Tabla inexistente");
            }else if(error==1062){
            
                JOptionPane.showMessageDialog(null,"Dni duplicado");
            }else if(error==1049){
            
                JOptionPane.showMessageDialog(null,"BD inexistente");
            }else {
            
                JOptionPane.showMessageDialog(null,"Error SQL");
                
            }
        }
    }
    
}

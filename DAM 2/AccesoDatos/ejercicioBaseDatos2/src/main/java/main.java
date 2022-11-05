import java.sql.*;

public class main {

    public static void main(String[] args) {
        System.out.println("Ejercicio 1:");
        // modificaRegistro();
        System.out.println("Ejercicio 2:");
        //muestraEquipoSouthWest();
        System.out.println("Ejercicio 3:");
        //insertarJugador52();
        System.out.println("Ejercicio 4:");
        //muestraEquipoYPartidosContra();
        System.out.println("Ejercicio 5:");
        //muestraEquipoMedia();
    }

    public static void modificaRegistro(){
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_NBA", "root", "");

            PreparedStatement s = connexion.prepareStatement("UPDATE partidos SET EquipoLocal= ?" + " WHERE CODIGO <= 8");
            s.setString(1,"Pistons");
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void muestraEquipoSouthWest(){
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_NBA", "root", "");

            PreparedStatement s = connexion.prepareStatement("SELECT * FROM equipos WHERE Division= ?");
            s.setString(1,"SouthWest");
            ResultSet rs = s.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
                    System.out.println(rsmd.getColumnName(i) + ": " + rs.getObject(i));
                }
                System.out.println("----------------------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void insertarJugador52() {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_NBA", "root", "");

            PreparedStatement s = connexion.prepareStatement("UPDATE estadisticas SET PuntosPorPartido= ?, AsistenciasPorPartido= ?, TaponesPorPartido= ?, RebotesPorPartido= ?" + " WHERE CodigoJugador= ? AND Temporada= ?");
            s.setString(1,"8");
            s.setString(2,"0");
            s.setString(3,"0");
            s.setString(4,"7");
            s.setString(5,"52");
            s.setString(6,"01/02");
            PreparedStatement s2 = connexion.prepareStatement("UPDATE estadisticas SET PuntosPorPartido= ?, AsistenciasPorPartido= ?, TaponesPorPartido= ?, RebotesPorPartido= ?" + " WHERE CodigoJugador= ? AND Temporada= ?");
            s2.setString(1,"12");
            s2.setString(2,"0");
            s2.setString(3,"5");
            s2.setString(4,"0");
            s2.setString(5,"52");
            s2.setString(6,"02/03");
            PreparedStatement s3 = connexion.prepareStatement("UPDATE estadisticas SET PuntosPorPartido= ?, AsistenciasPorPartido= ?, TaponesPorPartido= ?, RebotesPorPartido= ?" + " WHERE CodigoJugador= ? AND Temporada= ?");
            s3.setString(1,"6");
            s3.setString(2,"0");
            s3.setString(3,"0");
            s3.setString(4,"10");
            s3.setString(5,"52");
            s3.setString(6,"04/05");

            s.executeUpdate();
            s2.executeUpdate();
            s3.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void muestraEquipoYPartidosContra(){
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_NBA", "root", "");

            PreparedStatement s = connexion.prepareStatement("SELECT * FROM equipos WHERE NOMBRE= ?");
            s.setString(1,"Timberwolves");
            ResultSet rs = s.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
                    System.out.println(rsmd.getColumnName(i) + ": " + rs.getObject(i));
                }
                System.out.println("----------------------------------------------------");
            }

            PreparedStatement s2 = connexion.prepareStatement("SELECT * FROM partidos WHERE EquipoLocal= ? OR EquipoVisitante= ?");
            s2.setString(1,"Timberwolves");
            s2.setString(2,"Timberwolves");

            ResultSet rs2 = s2.executeQuery();
            ResultSetMetaData rsmd2 = rs2.getMetaData();
            while(rs2.next()){
                for (int i = 1; i < rsmd2.getColumnCount()+1; i++) {
                    System.out.println(rsmd2.getColumnName(i) + ": " + rs2.getObject(i));
                }
                System.out.println("----------------------------------------------------");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void muestraEquipoMedia(){
        try {
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_NBA", "root", "");

            PreparedStatement s = connexion.prepareStatement("SELECT j.Nombre, es.PuntosPorPartido, eq.Nombre FROM jugadores j, equipos eq, estadisticas es WHERE j.NombreEquipo = eq.Nombre AND j.codigo = es.CodigoJugador ORDER BY eq.Nombre");

            ResultSet rs = s.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()){
                for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
                    System.out.println(rsmd.getColumnName(i) + ": " + rs.getObject(i));
                }
                System.out.println("----------------------------------------------------");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

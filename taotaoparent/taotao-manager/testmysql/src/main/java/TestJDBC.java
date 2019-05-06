import java.sql.*;

public class TestJDBC {
    static String driver="com.mysql.cj.jdbc.Driver";
    static  String url="jdbc:mysql://localhost:3306/taotao?characterEncoding=utf-8&serverTimezone=UTC";
    static  String username="root";
    static  String password="xmh123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        String sql="select now()";
        Connection connection= DriverManager.getConnection(url,username,password);
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
        connection.close();

    }
}

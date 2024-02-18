package p14;

import java.sql.*;

public class ProductDB {
    //private MySQL1 connectionManager = new DBConnectionManager();

    public  static Connection getConnection() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/MySQL1";
        Connection connection= DriverManager.getConnection(url,"root","root");

        return connection;
    }
    public int insert(Product product) {
        int p=0;
        try {

            String sql = "INSERT INTO 'products.pro1'('name', 'price') VALUES (?,?)";
            Connection connection = ProductDB.getConnection();
            PreparedStatement dStatement = connection.prepareStatement(sql);

            dStatement.setString(1,product.getName());
            dStatement.setDouble(2,product.getPrice());

            p=dStatement.executeUpdate();
            dStatement.close();

            connection.close();


    }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public int update(Product product){
        int p=0;
        try {

            String sql = "UPDATE 'products.pro1' SET 'name'=?, 'price'=? WHERE id=?";
            Connection connection = ProductDB.getConnection();
            PreparedStatement dStatement = connection.prepareStatement(sql);

            dStatement.setString(1,product.getName());
            dStatement.setDouble(2,product.getPrice());
            dStatement.executeUpdate();
            connection.close();


        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public int delete(int id){
        int p =0;
        try {
                String sql = "DELETE FROM 'products.pro1' WHERE id=?";
                Connection connection = ProductDB.getConnection();
                PreparedStatement dStatement = connection.prepareStatement(sql);
                dStatement.setInt(1,id);
                p= dStatement.executeUpdate();
                connection.close();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return p;
    }
}


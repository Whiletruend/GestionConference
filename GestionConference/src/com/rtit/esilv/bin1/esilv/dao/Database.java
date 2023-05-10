/* Import(s) & Package(s) */
package com.rtit.esilv.bin1.esilv.dao;
import java.sql.*;

/**
 *
 * @author User RTIT
 *
 * Classe Database
**/
public class Database {
    /* Variable(s) */
    private static Connection conn_db = null;

    private static final String host_db = "localhost";
    private static final String name_db = "bdconferences";
    private static final String user_db = "root";
    private static final String pass_db = "";

    private static final String link_db = "jdbc:mysql://" + host_db + "/" + name_db;


    /* Method(s) */
    /* Method: getConnection */
    /* Purpose: Get the connection static variable (conn_db) to avoid any recreation of new connections */
    /**
     * @return the current connection
    **/
    public static Connection getConnection() {
        // If the connection is not already created (null) then create it
        // In any case, it'll return the connection
        if(conn_db == null) {
            try {
                // Create the connection
                conn_db = DriverManager.getConnection(link_db, user_db, pass_db);
            } catch (SQLException ex) { // If an error occurs, print the error
                // If an error occurs, print the error
                System.out.println("Error: " + ex.getMessage());
            }
        }

        // Return the connection
        return conn_db;
    }

    /* Method: query */
    /* Purpose: Execute a query thay return value (used in SELECT, etc.) */
    /**
     * @param request - format: "SELECT * FROM table"
     * @return the ResultSet
    */
    protected static ResultSet query(String request) throws SQLException {
        // Variable(s)
        Connection conn_db = getConnection();
        ResultSet queryOutput;
        Statement statement = conn_db.createStatement();
        queryOutput = statement.executeQuery(request);

        // Return
        return queryOutput;
    }

    /* Method: execute */
    /* Purpose: Execute a query thay doesn't return value (used in INSERT, UPDATE, etc.) */
    /**
     * @param request - format: "INSERT INTO table VALUES (value1, value2, ...)"
     */
    protected static void execute(String request) throws SQLException {
        // Variable(s)
        Connection conn_db = getConnection();
        Statement statement = conn_db.createStatement();

        // Execute the query
        statement.execute(request);
    }
}

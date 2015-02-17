

package Hotel.Model.Entity;


import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author neilkenney
 */
public class DB_MySql implements DBAccessor {
    
    private Connection conn;
    

    @Override
    public void openConnection(String driverClass, String url, String user, String password) throws SQLException{
        
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void closeConnection() throws SQLException{
        conn.close();
    }
    
    @Override
    public List readRecords(String sqlString) throws SQLException{
            
            Statement stmt = null;
            ResultSet rs;
            ResultSetMetaData metaData;
            final List list = new ArrayList();
            Map record;
        
        try {
            
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlString);
            metaData = rs.getMetaData();
            final int fields = metaData.getColumnCount();
            
            while(rs.next()){
                record =  new HashMap();
                for (int x = 0; x < fields; x++){
                    record.put(metaData.getColumnName(x+1), rs.getObject(x+1));
                }
                list.add(record);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_MySql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw ex;
            }
            
        }
       
        return list;
    }
    
    @Override
    public void createRecord(String tableName, List colNames, List colValues){
      
        try {
           
            Statement stmt = conn.createStatement();
            
            StringBuilder insert = new StringBuilder("INSERT INTO ");
            insert.append(tableName);
            insert.append(" (");
            final Iterator i=colNames.iterator();
            
            while( i.hasNext() ) {
                (insert.append((String)i.next() )).append(", ");
            }
            insert = new StringBuilder( (insert.toString()).substring( 0,(insert.toString()).lastIndexOf(", ") ) + ") VALUES (" );
            
            final Iterator t=colValues.iterator();
            
            while( t.hasNext() ) {
                final Object value = t.next();
                
                if(value instanceof String){
                    insert.append("\"");
                    (insert.append((String)value )).append("\", ");
                }
                else if(value instanceof Integer){
                    (insert.append((Integer)value )).append(", ");
                }
                else if(value instanceof Double){
                    (insert.append((Double)value )).append(", ");
                }
                else if(value instanceof Long){
                    (insert.append((Long)value )).append(", ");
                }
                
            }
            
            insert = new StringBuilder( (insert.toString()).substring( 0,(insert.toString()).lastIndexOf(", ") ) + ")" );
            
            
            try {
                stmt.executeUpdate(insert.toString());
            } catch (SQLException ex) {
                Logger.getLogger(DB_MySql.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
   
    
    @Override
    public void deleteRecord(String tableName, String colName, Object colValue){
    
        try {
            
            Statement stmt = conn.createStatement();
            String str = "DELETE FROM " + tableName + " WHERE " + colName + "=\"" + colValue + "\"";
            //System.out.println(str);
            stmt.executeUpdate(str);
        
        } catch (SQLException ex) {
            Logger.getLogger(DB_MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    };
    
    @Override
    public void updateRecord(String tablename, List colName, List colValue, String colEqualName, String colEqualValue){
    
        
        for (int i = 0; i < colName.size(); i++) {
            try {

                Statement stmt = conn.createStatement();
                String str = "UPDATE " + tablename + " SET " + colName.get(i) + "=\"" + colValue.get(i) + "\" WHERE " + colEqualName + "=" + colEqualValue + ";";
                System.out.println(str);
                stmt.executeUpdate(str);

            } catch (SQLException ex) {
                Logger.getLogger(DB_MySql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    };
    
    

    @Override
    public Connection getConn() {
        return conn;
    }

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

  
//    public static void main(String[] args) throws SQLException {
//        
//        DB_MySql db = new DB_MySql();
//        List<String> colNames = Arrays.asList("hotel_name, street_address,city,state,postal_code,notes");
//        List<Object> colValues = Arrays.asList("Queen inn","Rural Street","Quentin","TX","87741","Near Alamo");
//        db.openConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/hotel","root", "");
//        db.createRecord("hotel",colNames,colValues);
//        List records = db.readRecords("select hotel_id from hotel");
//        System.out.println(records);
//        db.closeConnection();
//    }
    
    
}

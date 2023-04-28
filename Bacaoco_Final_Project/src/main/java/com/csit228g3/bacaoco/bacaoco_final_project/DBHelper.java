    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.csit228g3.bacaoco.bacaoco_final_project;

    import com.csit228g3.bacaoco.bacaoco_final_project.MySQLConnection.Query;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    /**
     *
     * @author USER
     */
    public class DBHelper {
        public Query query;

        public DBHelper(){
            try {
                query = new MySQLConnection.Query();
            } catch (SQLException ex) {
                Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void addUser(int meal_number, String type, String title, String description) throws SQLException {
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //LocalDate parsedDate = LocalDate.parse(date, formatter);

        String values = String.format("%d, '%s', '%s', '%s'", meal_number, type, title, description);
        query.update("INSERT INTO tblmealinfo (meal_number, type, title, description) values (" + values + ")");
    }

        public ResultSet getUser() throws SQLException{
            return query.execute("SELECT * FROM tblmealinfo");
        }

        public void close() throws SQLException{
            query.close();
        }

        public static void main(String[] args){
            DBHelper dbHelper = new DBHelper();
            // dbHelper.addUser(1,"Jolly","Hotdog",12,"Male",12,23);
        }
    }


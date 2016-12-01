package bankFront.data;

import bankFront.bankService.UserService;

import java.sql.*;

public class UserDataAccess extends DataAccess
{
    public UserDataAccess() { super(); }

    public Boolean checkPassword(String kontonummer, String password) {
        Integer user = 0;
        try {
            Connection conn = this.getConnection();

            String sql = "SELECT k.ID, k.Passwort " +
                    "FROM kunden AS k " +
                    "LEFT JOIN konto AS kon ON kon.Kunden_ID = k.ID " +
                    "WHERE kon.Kontonummer = ? AND kon.Hauptkonto = 1";

            PreparedStatement s = conn.prepareStatement(sql);
            Integer konto_int = Integer.parseInt(kontonummer);
            s.setInt(1, konto_int);
            s.execute();
            ResultSet r = s.getResultSet();

            while(r.next()){

                if(r.getString("Passwort").equals(password)) {
                    user = r.getInt("ID");
                }

                System.out.println("user out: " + Integer.toString(user));
            }
        } catch (SQLException e) {

            e.printStackTrace();

        }finally {
            this.closeConnection();
        }

        return ( user > 0 );
    }

}

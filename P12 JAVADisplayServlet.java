import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String connectionURL = "jdbc:mysql://localhost:3306/reg";

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    connectionURL, "root", "root");

            Statement stmt = connection.createStatement();

            String sql = "SELECT * FROM register";

            ResultSet rs = stmt.executeQuery(sql);

            out.println("<h2>All Registration Records</h2>");

            out.println("<table border='1' cellpadding='10'>");

            out.println("<tr>");
            out.println("<th>UID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("<th>Password</th>");
            out.println("<th>Confirm Password</th>");
            out.println("<th>Town</th>");
            out.println("<th>Country</th>");
            out.println("<th>ZIP</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" + rs.getString("uid") + "</td>");
                out.println("<td>" + rs.getString("fname") + "</td>");
                out.println("<td>" + rs.getString("sname") + "</td>");
                out.println("<td>" + rs.getString("pwd") + "</td>");
                out.println("<td>" + rs.getString("pwd1") + "</td>");
                out.println("<td>" + rs.getString("town") + "</td>");
                out.println("<td>" + rs.getString("country") + "</td>");
                out.println("<td>" + rs.getString("zip") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {

            out.println("<h3>SQL Exception caught : "
                    + e.getMessage() + "</h3>");
        }
    }
}

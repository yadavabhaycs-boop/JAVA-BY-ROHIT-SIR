import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String age = request.getParameter("age");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Connection con = ServletPractical.getConnection();

            String sql = "INSERT INTO register(name,email,course,age) "
                    + "VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, Integer.parseInt(age));

            ps.executeUpdate();

            // Session variable
            HttpSession session = request.getSession();
            session.setAttribute("username", name);

            out.println("<h2>Registration Successful!</h2>");
            out.println("<p>Name: " + name + "</p>");
            out.println("<p>Email: " + email + "</p>");
            out.println("<br>");
            out.println("<a href='welcome.jsp'>Go to Welcome Page</a>");

            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<h3>SQL Exception caught : "
                    + e.getMessage() + "</h3>");
        }
    }
}

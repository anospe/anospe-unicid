package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.StudentDAO;

@WebServlet("/estudantes")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Instancia o DAO para ir buscar os dados ao MySQL
        StudentDAO dao = new StudentDAO();
        List<Student> lista = dao.listar();
        
        // Guarda a lista no atributo do pedido (request)
        request.setAttribute("listaEstudantes", lista);
        
        // Redireciona o fluxo para a página JSP de listagem
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }
}
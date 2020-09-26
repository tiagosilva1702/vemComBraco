package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author TIAGO
 */
@WebServlet(name = "Usuario", urlPatterns = "/usuario")
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/criarUsuario.jsp";
    private static String LIST_USER = "/listarUsuario.jsp";

    public UsuarioServlet() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        UsuarioDAO dao = new UsuarioDAO(); //Crian uma instancia do DAO usuario

        if(action != null)
        {
            if (action.equalsIgnoreCase("deletar")) {
                //int userId = Integer.parseInt(request.getParameter("usuarioId"));
                //dao.get(userId);
                forward = LIST_USER;
                //request.setAttribute("users", dao.getAllUsers());    
            } else if (action.equalsIgnoreCase("editar")) {
                forward = INSERT_OR_EDIT;
                //int userId = Integer.parseInt(request.getParameter("userId"));
                //User user = dao.getUserById(userId);
                //request.setAttribute("user", user);
            } else {
                forward = LIST_USER;
                request.setAttribute("users", dao.ListarUsuario());
            }
        }
        else 
        {
             forward = LIST_USER;
            request.setAttribute("users", dao.ListarUsuario());
        }
        
        /*if (action.equalsIgnoreCase("deletar")) {
            //int userId = Integer.parseInt(request.getParameter("usuarioId"));
            //dao.get(userId);
            forward = LIST_USER;
            //request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("editar")) {
            forward = INSERT_OR_EDIT;
            //int userId = Integer.parseInt(request.getParameter("userId"));
            //User user = dao.getUserById(userId);
            //request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listarUsuario")) {
            forward = LIST_USER;
            request.setAttribute("users", dao.ListarUsuario());
        } else {
            forward = INSERT_OR_EDIT;
        }
        */

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO(); //Crian uma instancia do DAO usuario
        usuario.setNome(request.getParameter("nome"));
        usuario.setSenha(request.getParameter("pass"));


        /*try {
            Date dataNascimento = null;
            if (request.getParameter("dataNascimento") != null) {
                dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
            } else {
                dataNascimento = null;
            }
            usuario.setDataNascimento(dataNascimento);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        usuario.setEmail(request.getParameter("email"));
        String userid = request.getParameter("usuarioId");

        if (userid == null || userid.isEmpty()) {
            dao.Inserir(usuario);
        } else {
            //user.setUserid(Integer.parseInt(userid));
            //dao.updateUser(user);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.ListarUsuario());
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

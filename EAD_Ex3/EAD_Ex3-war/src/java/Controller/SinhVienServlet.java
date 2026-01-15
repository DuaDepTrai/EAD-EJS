/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Lop;
import model.SinhVien;
import service.SinhVienServiceBean;

/**
 *
 * @author DUADEPTRAI
 */
@WebServlet(name = "SinhVienServlet", urlPatterns = {"/SinhVienServlet"})
public class SinhVienServlet extends HttpServlet {
    
    @EJB
    private SinhVienServiceBean svService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SinhVienServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SinhVienServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            List<SinhVien> list = svService.findAllSV();
            request.setAttribute("listSVs", list);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (path.startsWith("/add")) {
            List<Lop> listLops = svService.findAllLop();
            request.setAttribute("listLops", listLops);
            request.getRequestDispatcher("/addForm.jsp").forward(request, response);
        } else if (path.startsWith("/edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            SinhVien sv = svService.findSinhVienById(id);
            List<Lop> listLops = svService.findAllLop();
            request.setAttribute("sv", sv);
            request.setAttribute("listLops", listLops);
            request.getRequestDispatcher("/editForm.jsp").forward(request, response);
        } else if (path.startsWith("/delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            svService.deleteSinhVien(id);
            response.sendRedirect(request.getContextPath() + "/students");
        } else if (path.startsWith("/chuyenLop")) {
            int id = Integer.parseInt(request.getParameter("id"));
            SinhVien sv = svService.findSinhVienById(id);
            List<Lop> listLops = svService.findAllLop();
            request.setAttribute("sv", sv);
            request.setAttribute("listLops", listLops);
            request.getRequestDispatcher("/chuyenLopForm.jsp").forward(request, response);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path.startsWith("/add")) {
            String name = request.getParameter("name");
            int idLop = Integer.parseInt(request.getParameter("idLop"));
            svService.addSinhVien(name, idLop);
            response.sendRedirect(request.getContextPath() + "/students");
        } else if (path.startsWith("/edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int idLop = Integer.parseInt(request.getParameter("idLop"));
            svService.updateSinhVien(id, name, idLop);
            response.sendRedirect(request.getContextPath() + "/students");
        } else if (path.startsWith("/chuyenLop")) {
            int idSV = Integer.parseInt(request.getParameter("idSV"));
            int idLop = Integer.parseInt(request.getParameter("idLop"));
            svService.chuyenLop(idSV, idLop);
            response.sendRedirect(request.getContextPath() + "/students");
        }
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

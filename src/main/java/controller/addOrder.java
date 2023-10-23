/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.orderDAO;
import DAO.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Order;
import model.Product;

/**
 *
 * @author thinh
 */
@WebServlet(name = "addOrder", urlPatterns = {"/addOrder"})
public class addOrder extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addOrder at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        int maxQuan = 0;
        String proName = "";
        String id = request.getParameter("oid");
        productDAO dao = new productDAO();
        List<Product> list = dao.getAll();
        for (Product product : list) {
            if (product.getPro_id().equals(id)) {
                maxQuan = product.getPro_quan();
                proName = product.getPro_name();
                break;
            }
        }
        request.setAttribute("maxQuan", maxQuan);
        request.setAttribute("proName", proName);

        request.getRequestDispatcher("order.jsp").forward(request, response);

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
//        processRequest(request, response);
        String id = request.getParameter("id");
        String user = request.getParameter("user");
        String total = request.getParameter("total");
        String date = request.getParameter("date");
        String des = request.getParameter("des");
        String proName = request.getParameter("proName");

        int temp = Integer.parseInt(total);
        int tmp = 0;
        orderDAO dao = new orderDAO();
        dao.addOrder(id, user, total, date, des);

        productDAO pdao = new productDAO();
        List<Product> listP = pdao.getAll();
        for (Product product : listP) {
            if (product.getPro_name().equals(proName)) {
                tmp = product.getPro_quan() - temp;
            }
        }
        String quan = Integer.toString(tmp);
        pdao.updateQuan(quan, proName);
//        request.setAttribute("listProduct", listP);

        response.sendRedirect("listBack");

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.accountDAO;
import DAO.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import model.Account;
import model.Product;

/**
 *
 * @author thinh
 */
public class login_servlet extends HttpServlet {

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
            out.println("<title>Servlet login_servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login_servlet at " + request.getContextPath() + "</h1>");
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

//        
//        
//        
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String ms = "";
        String name = "";

        accountDAO account = new accountDAO();
        List<Account> listAccount = account.getAll();
        request.setAttribute("listAccount", listAccount);

        productDAO product = new productDAO();
        List<Product> listProduct = product.getAll();
        request.setAttribute("listProduct", listProduct);

        String md5 = getMd5(pass).toUpperCase();

        for (Account account1 : listAccount) {
            if (user.equals(account1.getUsername()) && md5.equals(account1.getPassword())) {
                name = account1.getFullname();
                HttpSession session = request.getSession();

                session.setAttribute("name", name);
                session.setAttribute("user", user);
                
                //luu acc tren cookie
                Cookie u = new Cookie("userC", user);
                Cookie p = new Cookie("passC", pass);
                u.setMaxAge(24 * 3 * 60 * 60);
                p.setMaxAge(24 * 3 * 60 * 60);
                //luu user va pass len trinh duyet  
                response.addCookie(p);
                response.addCookie(u);

                response.sendRedirect("listBack");

//                request.getRequestDispatcher("list.jsp").forward(request, response);
            } else {
                ms = "<div style=\"color: red;\">Invalid email or password.</div>";
                request.setAttribute("ms", ms);

            }
        }

//        request.getRequestDispatcher("index.jsp").forward(request, response);
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

        //get user, pass from cookie
        Cookie arr[] = request.getCookies();

        for (Cookie o : arr) {
            if (o.getName().equals("userC")) {
                o.setMaxAge(0);
                response.addCookie(o);
//                request.setAttribute("username", o.getValue());

            }
            if (o.getName().equals("passC")) {
                o.setMaxAge(0);
                response.addCookie(o);

//                request.setAttribute("password", o.getValue());
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

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

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}

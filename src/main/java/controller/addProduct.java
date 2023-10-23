/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author thinh
 */
@WebServlet(name = "addProduct", urlPatterns = {"/addProduct"})
public class addProduct extends HttpServlet {

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
            out.println("<title>Servlet addProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProduct at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String name = request.getParameter("name");
        String quan = request.getParameter("quan");
        String price = request.getParameter("price");
        String pic = request.getParameter("pic");
        String des = request.getParameter("des");

        Random a = new Random();
        
        
       String downloadPath = "E:\\Thinh\\FPT\\SE\\SEMESTER 4\\PRJ301\\lab02_LamDucThinh\\src\\main\\java\\img\\"; // Change this to your desired path
        String fileName = downloadPath+a.nextInt()+ ".jpg";

        try {
            URL url = new URL(pic);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set User-Agent and Referer headers to mimic a web browser
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Referer", "https://example.com"); // Replace with the appropriate referer URL

            // Get response code to check for HTTP 403 (Forbidden)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // If the response code is OK, proceed to download
                InputStream is = connection.getInputStream();

                // Create the directory path if it doesn't exist
                File directory = new File(downloadPath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                FileOutputStream os = new FileOutputStream(fileName);
                byte[] buffer = new byte[2048];
                int length;
                System.out.println("Downloading from URL: " + url);
                while ((length = is.read(buffer)) != -1) {
                    os.write(buffer, 0, length);
                }
                System.out.println("Download finished: " + fileName);

                is.close();
                os.close();
            } else {
                // Handle other response codes as needed
                System.out.println("HTTP Error: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        

        productDAO dao = new productDAO();
        dao.insertProduct(id, name, quan, price, pic, des);
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

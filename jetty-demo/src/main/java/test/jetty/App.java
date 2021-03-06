package test.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8888);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(HelloServlet.class, "/hello");
        server.start();
        server.join();
    }

    @SuppressWarnings("serial")
    public static class HelloServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello from HelloServlet zz</h1>");
        }
    }
}
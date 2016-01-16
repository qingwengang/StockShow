package Stock.Servlet;

import Stock.Start.GetFiveDangStart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wgqing on 2015/11/4.
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        System.out.println("==============================================started!===================================");
        GetFiveDangStart.GetFiveDang();
    }
}
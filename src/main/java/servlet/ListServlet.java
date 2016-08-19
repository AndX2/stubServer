package servlet;

import service.ListNoFoundException;
import service.ListStorageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by savos on 11.08.2016.
 */
public class ListServlet extends HttpServlet {

    private ListStorageService listStorageService;
    public ListServlet(ListStorageService service){
        this.listStorageService = service;
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bodyList = req.getParameter("body");
        if (bodyList != null){
            String key = listStorageService.addList(bodyList);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().print(key);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        try {
            resp.getWriter().print(listStorageService.getList(key));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (ListNoFoundException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }


}

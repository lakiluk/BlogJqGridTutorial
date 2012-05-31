package org.dworski.servlet;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.dworski.datasource.DatasourceMock;
import org.dworski.grid.JqGridTransferObject;
import org.dworski.model.serializer.OrderSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderProvider extends HttpServlet {

    private ObjectMapper objectMapper;
    private DatasourceMock datasource;

    @Override
    public void init() throws ServletException {
        initObjectMapper();
        initDatasource();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        JqGridTransferObject transferObject = datasource.query(page, rows);
        objectMapper.writeValue(resp.getWriter(),transferObject);
        resp.getWriter().close();
    }

    private void initDatasource() {
        datasource = new DatasourceMock(40);
    }

    private void initObjectMapper() {
        objectMapper = new ObjectMapper();
        SimpleModule orderSerializerModule = new SimpleModule("OrderSerializerModule",new Version(1,0,0,null));
        orderSerializerModule.addSerializer(new OrderSerializer());
        objectMapper.registerModule(orderSerializerModule);
    }


}

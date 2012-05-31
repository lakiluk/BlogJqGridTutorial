package org.dworski.datasource;

import org.dworski.grid.JqGridTransferObject;
import org.dworski.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DatasourceMock {

    private List<Order> orders;

    public DatasourceMock(int datasourceSize) {
        init(datasourceSize);
    }

    public synchronized JqGridTransferObject query(int page, int rows) {
        int datasourceSize = orders.size();
        JqGridTransferObject transferObject = new JqGridTransferObject();
        transferObject.setPage(String.valueOf(page));
        transferObject.setRecords(String.valueOf(datasourceSize));
        if (page * rows >= orders.size()) {
            transferObject.setRows(orders.subList((page - 1) * rows, orders.size()));
        } else {
            transferObject.setRows(orders.subList((page - 1) * rows, page * rows));
        }
        transferObject.setTotal((int) Math.ceil((double) datasourceSize / rows));
        return transferObject;
    }

    private void init(int datasourceSize) {
        orders = new ArrayList<Order>(datasourceSize);
        for (int i = 1; i <= datasourceSize; i++) {
            Order order = createOrder(i);
            orders.add(order);
        }
    }

    private Order createOrder(int i) {
        Order order = new Order();
        order.setId(i);
        order.setInvoiceNumber(UUID.randomUUID().toString());
        order.setPrice(new Random().nextInt(1000));
        order.setUserId(Integer.toString(new Random().nextInt(1000)));
        return order;
    }

}

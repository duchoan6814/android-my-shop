package com.example.myshop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private String orderId;
    private Date orderDate;

    private List<OrderDetail> listOrderDetail;

    public Order(String orderId, Date orderDate, List<OrderDetail> listOrderDetail) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.listOrderDetail = listOrderDetail;
    }

    public Order() {
        this.setOrderDate(new Date());
        this.listOrderDetail = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", listOrderDetail=" + listOrderDetail +
                '}';
    }

    public void addNewOrderDetail(OrderDetail orderDetail){
        this.listOrderDetail.add(orderDetail);
    }

    public void removeOrderDetail(int position){
        this.listOrderDetail.remove(position);
    }

    public double tinhTongTien(){
        double sum = 0;
        for (OrderDetail orderDetail: this.listOrderDetail) {
            sum+=orderDetail.tinhTotalGia();
        }
        return sum;
    }
}

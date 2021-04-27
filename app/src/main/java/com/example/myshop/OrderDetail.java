package com.example.myshop;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    private Shirt shirt;
    private String size;
    private int soLuong;

    public OrderDetail() {
    }

    public OrderDetail(Shirt shirt, String size, int soLuong) {
        this.shirt = shirt;
        this.size = size;
        this.soLuong = soLuong;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "shirt=" + shirt +
                ", size='" + size + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }

    public double tinhTotalGia() {
        return this.soLuong * this.shirt.getPrice();
    }
}

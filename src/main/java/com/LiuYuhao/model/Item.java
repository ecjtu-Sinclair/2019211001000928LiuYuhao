package com.LiuYuhao.model;

public class Item {
    private Product product;
    private int qunatity;

    public Item(){

    }
    public Item(Product product, int qunatity) {
        this.product = product;
        this.qunatity = qunatity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", qunatity=" + qunatity +
                '}';
    }
}

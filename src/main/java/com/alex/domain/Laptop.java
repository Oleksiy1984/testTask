package com.alex.domain;

public class Laptop {

    private Long id;
    private Integer ram;
    private String cpu;
    private String screen;
    private Integer price;

    public Laptop(Long id, Integer ram, String cpu, String screen, Integer price) {
        this.id = id;
        this.ram = ram;
        this.cpu = cpu;
        this.screen = screen;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Laptop{id=%d, ram=%d, cpu='%s', screen='%s', price=%d}",
                id, ram, cpu, screen, price);
    }
}

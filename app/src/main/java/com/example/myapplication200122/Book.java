package com.example.myapplication200122;


import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;

/**
 * @author LiuSaiSai
 * @description: 添加数据后，对应的 litepal.xml 版本号要改；
 * @date :2020/03/06 17:02
 */
public class Book extends LitePalSupport {

    private String name;

    private String author;

    private int id;

    private int pages;

    private double price;

    private String press;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", pages=" + pages +
                ", price=" + price +
                ", press='" + press + '\'' +
                '}';
    }
}

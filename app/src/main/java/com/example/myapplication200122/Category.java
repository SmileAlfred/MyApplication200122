package com.example.myapplication200122;

import org.litepal.crud.LitePalSupport;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/03/06 17:44
 */
public class Category extends LitePalSupport {

    private String categoryName;

    private int categoryCode;

    private int id;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryCode=" + categoryCode +
                ", id=" + id +
                '}';
    }
}

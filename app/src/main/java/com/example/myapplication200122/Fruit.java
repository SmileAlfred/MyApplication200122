package com.example.myapplication200122;

/**
 * @author LiuSaiSai
 * @description:
 * @date :2020/02/25 10:19
 */
public class Fruit {
    String fruitName;
    int imageId;

    public Fruit(String fruitName, int imageId) {
        this.fruitName = fruitName;
        this.imageId = imageId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

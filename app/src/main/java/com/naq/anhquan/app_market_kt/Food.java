package com.naq.anhquan.app_market_kt;

public class Food {

    public static final int TYPE_FOOD = 1;
    public static final int TYPE_DRINK = 2;

    private int image;
    private String name;
    private int style;

    public Food(int image, String name, int style) {
        this.image = image;
        this.name = name;
        this.style = style;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}

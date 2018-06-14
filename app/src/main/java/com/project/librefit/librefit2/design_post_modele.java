package com.project.librefit.librefit2;

public class design_post_modele  {
    String price;
    String Rate;
    int image;
    public design_post_modele(String price, String rate, int image) {
        this.price = price;
        Rate = rate;
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

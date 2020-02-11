package entities;

import enums.CouponType;

import java.time.LocalDate;

public class Coupon {
    private long id;
    private LocalDate expired;
    private CouponType couponType;
    private double price;
    private int amount;
    private String message;
    private String image;
    private long companyID;

    public Coupon(long id, LocalDate expired, CouponType couponType, double price, int amount, String message, String image, long companyID) {
        this.id = id;
        this.expired = expired;
        this.couponType = couponType;
        this.price = price;
        this.amount = amount;
        this.message = message;
        this.image = image;
        this.companyID = companyID;
    }

    public Coupon(LocalDate expired, CouponType couponType, double price, int amount, String message, String image, long companyID) {
        this.expired = expired;
        this.couponType = couponType;
        this.price = price;
        this.amount = amount;
        this.message = message;
        this.image = image;
        this.companyID = companyID;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public long getCompanyID() {
        return companyID;
    }
}

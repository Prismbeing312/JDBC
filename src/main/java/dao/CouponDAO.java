package dao;


import entities.Coupon;
import exceptions.AlreadyExistException;
import exceptions.NotExistException;

import java.util.List;

public interface CouponDAO {
    Coupon getCouponByID(long CouponID) throws NotExistException;

    List<Coupon> getAllCoupons();

    boolean login (String name, String password);

    Coupon getByCompanyID(long CompanyID) throws NotExistException;

    Coupon createCoupon(Coupon coupon) throws AlreadyExistException;

    void deleteCoupon(long CouponID) throws NotExistException;
}

package com.spring.apitest.service.iservice;

import com.spring.apitest.model.ProductDetails;
import com.spring.apitest.model.reponseobject.ProductDetailRespons;

import java.util.List;

public interface IProductDetailsService {
    public ProductDetailRespons<ProductDetails> muaSanPham(int soLuong, String spMua);
    public ProductDetailRespons<ProductDetails> capNhatSoLuong(int soLuongThem, String spThem);
    public List<ProductDetails> hienThi();
}

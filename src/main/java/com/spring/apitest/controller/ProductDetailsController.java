package com.spring.apitest.controller;

import com.spring.apitest.model.ProductDetails;
import com.spring.apitest.model.reponseobject.ProductDetailRespons;
import com.spring.apitest.service.cservice.ProductDetailsService;
import com.spring.apitest.service.dbservice.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductDetailsController {
    @Autowired
    private ProductDetailsService productDetailsService;

    @PostMapping(value = "muasanpham", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDetailRespons<ProductDetails> muaSP(@RequestParam int quantity, @RequestParam String tenSP) {
        return productDetailsService.muaSanPham(quantity, tenSP);
    }

    @GetMapping(value = "hienthidanhsachdoicuoi", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDetails> hienThiDanhSach() {
        return productDetailsService.hienThi();
    }

    @PutMapping(value = "capnhatsoluong", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDetailRespons<ProductDetails> themSoLuong(@RequestParam int soLuongThem, @RequestParam String spThem) {
        return productDetailsService.capNhatSoLuong(soLuongThem, spThem);

    }

}

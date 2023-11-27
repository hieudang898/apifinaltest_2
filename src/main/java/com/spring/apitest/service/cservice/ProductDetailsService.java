package com.spring.apitest.service.cservice;

import com.spring.apitest.model.ProductDetails;
import com.spring.apitest.model.reponseobject.ProductDetailRespons;
import com.spring.apitest.repository.dbcontext.DbContext;
import com.spring.apitest.service.iservice.IProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailsService implements IProductDetailsService {
    @Autowired
    private DbContext dbContext;

    //1.mua sản phẩm đời cuối cùng và update số lượng của các đời trước
    @Override
    public ProductDetailRespons<ProductDetails> muaSanPham(int soLuong, String spMua) {
        ProductDetails productDetails = dbContext.productDetailsRepo.findAllByProductDetailNameIgnoreCase(spMua);
        ProductDetailRespons<ProductDetails> respons = new ProductDetailRespons<>();

        if (productDetails != null) {
            if (productDetails.getQuantity() >= soLuong && soLuong >= 1) {
                productDetails.setQuantity(productDetails.getQuantity() - soLuong);

                ProductDetails currentProductDetails = productDetails;

                while (currentProductDetails.getParentId() != null) {
                    Integer parentId = currentProductDetails.getParentId();
                    ProductDetails parentProductDetails = dbContext.productDetailsRepo.findById(parentId).orElse(null);

                    if (parentProductDetails != null) {
                        parentProductDetails.setQuantity(parentProductDetails.getQuantity() - soLuong);
                        dbContext.productDetailsRepo.save(parentProductDetails);
                        currentProductDetails = parentProductDetails;
                    } else {
                        break;
                    }
                }
                dbContext.productDetailsRepo.save(productDetails);
                respons.setStatus("mua thành công");
            } else {
                respons.setError("số lượng hàng không đủ, hãy kiểm tra lại số lượng mua");
            }

        } else {
            respons.setError("không có sản phẩm với các thuộc tính như yêu cầu");
        }
        return respons;
    }
    //2.thêm sản phẩm và update số lượng

    @Override
    public ProductDetailRespons<ProductDetails> capNhatSoLuong(int soLuongThem, String spThem) {
        ProductDetails productDetails = dbContext.productDetailsRepo.findAllByProductDetailNameIgnoreCase(spThem);
        ProductDetailRespons<ProductDetails> respons = new ProductDetailRespons<>();
        if (productDetails != null) {
            if (soLuongThem > 0) {
                productDetails.setQuantity(productDetails.getQuantity() + soLuongThem);

                ProductDetails currentProductDetails = productDetails;

                while (currentProductDetails.getParentId() != null) {
                    Integer parentId = currentProductDetails.getParentId();
                    ProductDetails parentProductDetails = dbContext.productDetailsRepo.findById(parentId).orElse(null);

                    if (parentProductDetails != null) {
                        parentProductDetails.setQuantity(parentProductDetails.getQuantity() + soLuongThem);
                        dbContext.productDetailsRepo.save(parentProductDetails);
                        currentProductDetails = parentProductDetails;
                    } else {
                        break;
                    }
                }
                dbContext.productDetailsRepo.save(productDetails);
                respons.setStatus("cập nhật thành công");
            } else {
                respons.setError("số lượng thêm phải lớn hơn 0");
            }

        } else {
            respons.setError("không có sản phẩm với các thuộc tính như yêu cầu");
        }
        return respons;
    }

    //3.hiển thị danh sách sản phẩm đời cuối

    @Override
    public List<ProductDetails> hienThi() {
        return dbContext.productDetailsRepo.hienThiDanhSachSanPhamDoiCuoi();
    }
}

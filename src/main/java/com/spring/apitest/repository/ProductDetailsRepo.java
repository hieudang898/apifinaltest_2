package com.spring.apitest.repository;


import com.spring.apitest.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails, Integer> {
    public ProductDetails findAllByProductDetailNameIgnoreCase(String spMua);

    @Query(value = "SELECT pd.*\n" +
            "FROM ProductDetails pd\n" +
            "LEFT JOIN ProductDetails pd2 ON pd.productdetailid = pd2.parentId\n" +
            "WHERE pd2.parentId IS NULL", nativeQuery = true)
    public List<ProductDetails> hienThiDanhSachSanPhamDoiCuoi();
}

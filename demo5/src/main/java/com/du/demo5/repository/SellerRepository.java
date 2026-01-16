package com.du.demo5.repository;

import com.du.demo5.entity.SellerSignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerSignUp, Long> {

    // 로그인용
    SellerSignUp findBySellComId(String sellComId);

    // ✅ 아이디 중복 체크용
    boolean existsBySellComId(String sellComId);
}

package com.du.demo5.repository;

import com.du.demo5.entity.SellerSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SellerSignUp, Long> {

    /**
     * 로그인용 조회
     * sell_com_id 기준으로 사용자 조회
     */
    Optional<SellerSignUp> findBySellComId(String sellComId);

    /**
     * 아이디 중복 체크 (회원가입 시)
     */
    boolean existsBySellComId(String sellComId);

}

package com.du.demo5.service;

import com.du.demo5.entity.SellerSignUp;
import com.du.demo5.repository.SellerRepository;
import com.du.demo5.util.Sha512Util;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    private final SellerRepository sellerRepository;
    private static final String SALT = "DU_SALT_2026";

    public SignupService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void signup(
            String sellComName,
            String sellRegNum,
            String sellRepName,
            String sellComAdr,
            String sellComId,
            String sellComPw,
            String sellComNum,
            String sellComEmail,
            String sellBmName,
            String sellBmNum,
            String sellBmDep
    ) {

        // 1️⃣ 아이디 중복 체크
        if (sellerRepository.existsBySellComId(sellComId)) {
            throw new IllegalStateException("이미 사용 중인 아이디입니다.");
        }

        // 2️⃣ 비밀번호 SHA-512 해싱
        String hashPw = Sha512Util.hash(SALT + sellComPw);

        // 3️⃣ 엔티티 생성
        SellerSignUp seller = new SellerSignUp(
                sellComName,
                sellRegNum,
                sellRepName,
                sellComAdr,
                sellComId,
                hashPw,
                sellComNum,
                sellComEmail,
                sellBmName,
                sellBmNum,
                sellBmDep
        );

        // 4️⃣ DB 저장
        sellerRepository.save(seller);
    }
}

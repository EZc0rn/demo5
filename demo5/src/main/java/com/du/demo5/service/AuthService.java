package com.du.demo5.service;

import com.du.demo5.entity.SellerSignUp;
import com.du.demo5.repository.SellerRepository;
import com.du.demo5.util.Sha512Util;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final SellerRepository sellerRepository;
    private static final String SALT = "DU_SALT_2026";

    public AuthService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public boolean login(String sellComId, String sellComPw) {

        Optional<SellerSignUp> sellerOpt =
                sellerRepository.findBySellComId(sellComId);

        if (sellerOpt.isEmpty()) {
            return false; // 아이디 없음
        }

        SellerSignUp seller = sellerOpt.get();

        String inputHash = Sha512Util.hash(SALT + sellComPw);

        return inputHash.equals(seller.getSellComPw());
    }
}

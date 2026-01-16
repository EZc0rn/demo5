package com.du.demo5.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class SellerSignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sell_serial_num")
    private Long sellSerialNum;


    @Column(name = "sell_com_name", nullable = false, length = 100)
    private String sellComName;

    @Column(name = "sell_reg_num",nullable = false, length = 50)
    private String sellRegNum;

    @Column(name = "sell_rep_name",nullable = false, length = 20)
    private String sellRepName;

    @Column(name = "sell_com_adr",nullable = false, length = 200)
    private String sellComAdr;

    @Column(name = "sell_com_id",nullable = false, length = 50, unique = true)
    private String sellComId;

    @Column(name = "sell_com_pw",nullable = false, length = 128)
    private String sellComPw;

    @Column(name = "sell_com_num",nullable = false, length = 20)
    private String sellComNum;

    @Column(name = "sell_com_email",nullable = false, length = 50)
    private String sellComEmail;

    @Column(name = "sell_bm_name",nullable = false, length = 50)
    private String sellBmName;

    @Column(name = "sell_bm_num",nullable = false, length = 20)
    private String sellBmNum;

    @Column(name = "sell_bm_dep",nullable = false, length = 20)
    private String sellBmDep;

    @Column(name = "sell_created_at", updatable = false)
    private LocalDateTime sellCreatedAt;

    /* JPA 기본 생성자 (필수) */
    protected SellerSignUp() {}

    /* 로그인/생성용 생성자 */
    public SellerSignUp(String sellComName, String sellRegNum, String sellRepName, String sellComAdr,
                        String sellComId, String sellComPw, String sellComNum, String sellComEmail,
                        String sellBmName, String sellBmNum, String sellBmDep
    ) {
        this.sellComName = sellComName;
        this.sellRegNum = sellRegNum;
        this.sellRepName = sellRepName;
        this.sellComAdr = sellComAdr;
        this.sellComId = sellComId;
        this.sellComPw = sellComPw;
        this.sellComNum = sellComNum;
        this.sellComEmail = sellComEmail;
        this.sellBmName = sellBmName;
        this.sellBmNum = sellBmNum;
        this.sellBmDep = sellBmDep;
    }

    /* 저장 시 자동 시간 세팅 */
    @PrePersist
    protected void onCreate() {
        this.sellCreatedAt = LocalDateTime.now();
    }

    /* Getter */

    public Long getSellSerialNum() {
        return sellSerialNum;
    }

    public String getSellComName() {
        return sellComName;
    }

    public String getSellRegNum() {
        return sellRegNum;
    }

    public String getSellRepName() {
        return sellRepName;
    }

    public String getSellComAdr() {
        return sellComAdr;
    }

    public String getSellComId() {
        return sellComId;
    }

    public String getSellComPw() {
        return sellComPw;
    }

    public String getSellComNum() {
        return sellComNum;
    }

    public String getSellComEmail() {
        return sellComEmail;
    }

    public String getSellBmName() {
        return sellBmName;
    }

    public String getSellBmNum() {
        return sellBmNum;
    }

    public String getSellBmDep() {
        return sellBmDep;
    }

    public LocalDateTime getSellCreatedAt() {
        return sellCreatedAt;
    }

}
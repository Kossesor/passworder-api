package com.myself.passworder.models;//package me.remember.passworder.models;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Builder
//@Table(name = "vault")
//@NoArgsConstructor
//@AllArgsConstructor
//public class Vault {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long user_id;
//
//    private String title;
//    private String description;
//
//    @Column(columnDefinition = "tinyint")
//    private int type;
//
//    private String username;
//    private String mail;
//    private String password;
//
//    private String secretQuestion; // ????
//    private String secretQAnswer;  // ????
//
//    private String customInputs;   // HashMap<String, String> in JSON
//}
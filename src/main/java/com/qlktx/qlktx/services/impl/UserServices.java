package com.qlktx.qlktx.services.impl;

import com.qlktx.qlktx.Custom.CustomUserDetails;
import com.qlktx.qlktx.entities.Nguoidung;
import com.qlktx.qlktx.repositories.NguoiDungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {
    @Autowired
    private NguoiDungRepo nguoiDungRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nguoidung nguoidung = nguoiDungRepo.findTopByTenDangNhap(username);
        if (nguoidung == null) {
            throw  new UsernameNotFoundException(username);
        }
//        CustomUserDetails customUserDetails = new CustomUserDetails(nguoidung);
//        customUserDetails.setAuthorities(authorities);

        return  new CustomUserDetails(nguoidung);
    }
}

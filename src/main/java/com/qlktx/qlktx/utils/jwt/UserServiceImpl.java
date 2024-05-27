package com.qlktx.qlktx.utils.jwt;

import com.qlktx.qlktx.repositories.NguoiDungRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final NguoiDungRepo nguoiDungRepo;
    @Override
    public UserDetailsService userDetailsService() {
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserDetails userDetails = nguoiDungRepo.findTopByTenDangNhap(username);
                if (userDetails == null) {
                    throw  new UsernameNotFoundException("User not found");
                }
                return nguoiDungRepo.findTopByTenDangNhap(username);
            }
        };
    }
}

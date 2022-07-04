package com.example.demo.model;

import com.example.demo.controller.body.AdminBody;
import com.example.demo.model.entities.Admin;
import com.example.demo.model.entities.OTP;
import com.example.demo.repository.AdminRepsitory;
import com.example.demo.repository.OtpRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminModel {
    @Autowired
    private AdminRepsitory dao;
    @Autowired
    private OtpRepsitory otpRepsitory;

    public String changePass(AdminBody body){
        OTP otp = otpRepsitory.findFirstByStatusOrderByIdDesc(-1);
        if(otp!=null && otp.getCode()==body.getOtp()){
            Admin admin = dao.findFirstByName("dung");
            if(admin!= null){
                if(body.getPass().equals(body.getRepass())){
                    admin.setPassword(body.getPass());
                    otp.setStatus(1);
                    dao.save(admin);
                    otpRepsitory.save(otp);
                    return "Change passwork successfully";
                }
                return "Nhập lại mật khẩu phải trùng với mật khẩu";
            }
            return "Tài khoản không tồn tại";
        }
        return "OTP không đúng, vui lòng thử lại";
    }

    public Page<Admin> getAllAdmin(Pageable pageable){
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        List<Admin> list = dao.findAllByName("dung");
        Page<Admin> bookPage
                = new PageImpl<Admin>(list, PageRequest.of(currentPage, pageSize), list.size());

        return bookPage;
    }


}

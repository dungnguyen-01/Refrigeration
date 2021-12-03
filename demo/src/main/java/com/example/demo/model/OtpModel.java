package com.example.demo.model;

import com.example.demo.controller.AdminController;
import com.example.demo.model.entities.Admin;
import com.example.demo.model.entities.OTP;
import com.example.demo.repository.AdminRepsitory;
import com.example.demo.repository.OtpRepsitory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OtpModel {
    @Autowired
    private OtpRepsitory otpRepsitory;
    @Autowired
    private MailModel mailModel;
    @Autowired
    private AdminRepsitory adminRepsitory;

    public String sendOtp(){
        OTP lastRequest = otpRepsitory.findFirstByStatusOrderByIdDesc(-1);
        if(lastRequest == null || (System.currentTimeMillis() - lastRequest.getCreated().getTime()) >=30*1000){
            OTP otp = new OTP();
            Random random = new Random();
            int code = 100000 + random.nextInt(899999);
            otp.setCode(code);
            otp.setStatus(-1);
            otp.setCreated(new Date(System.currentTimeMillis()));
            List<OTP> otps = otpRepsitory.findAll();
            for (OTP o: otps){
                o.setStatus(2);
            }
            otps.add(otp);
            otpRepsitory.saveAll(otps);
            try {
                Admin admin= adminRepsitory.findFirstByName("dung");
                mailModel.sendEmail(admin.getEmail(), "Forget password", "Your Code is: " + code);
                return "OTP is sent to "+admin.getEmail();
            } catch (MailException e) {
                System.out.println(e);
                return ""+e;
            }
        }
        return "Waiting 30s before sending otp";
    }
}

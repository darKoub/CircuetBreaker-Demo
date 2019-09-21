package com.gl.orderManagementApp.service;

import com.gl.orderManagementApp.dto.SellerDto;
import com.gl.orderManagementApp.service.resilience4j.UserRegistrationResilience4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    private UserRegistrationResilience4j userRegistrationResilience4j;


    public UserRegistrationServiceImpl(UserRegistrationResilience4j userRegistrationResilience4j) {
        this.userRegistrationResilience4j = userRegistrationResilience4j;
    }

    @Override
    public String registerSeller(SellerDto sellerDto) {
        long start = System.currentTimeMillis();
        String registerSeller = null;

        for (int i = 0; i < 1000; i++) {

            //Thread t = new Thread(() -> {userRegistrationResilience4j.registerSeller(sellerDto);});
            //t.start();

            registerSeller = userRegistrationResilience4j.registerSeller(sellerDto);

            logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);
        }
        //registerSeller = userRegistrationResilience4j.registerSeller(sellerDto);
        return registerSeller;

    }

    @Override
    public List<SellerDto> getSellersList() {
        return userRegistrationResilience4j.getSellersList();
    }
}

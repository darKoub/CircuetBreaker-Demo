package com.gl.registrationService.service;

import com.gl.registrationService.dto.SellerDto;

import java.util.List;

public interface RegistrationService {


    String addSeller(SellerDto sellerDto);

    List<SellerDto> getSellersList();
}

package com.telran.phonebookapi.controller;

import com.telran.phonebookapi.dto.AddressDto;
import com.telran.phonebookapi.dto.EmailDto;
import com.telran.phonebookapi.mapper.AddressMapper;
import com.telran.phonebookapi.model.Address;
import com.telran.phonebookapi.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    AddressService addressService;
    AddressMapper addressMapper;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("")
    public void addAddress(@RequestBody @Valid AddressDto addressDto) {
        addressService.add(
                addressDto.zip,
                addressDto.country,
                addressDto.city,
                addressDto.street,
                addressDto.contactId);
    }

    @PutMapping("")
    public void editAddress(@RequestBody @Valid AddressDto addressDto) {
        addressService.editAllFields(
                addressDto.zip,
                addressDto.country,
                addressDto.city,
                addressDto.street,
                addressDto.id);
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        addressService.removeById(id);
    }

}

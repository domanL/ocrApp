package com.devglan.controller;

import com.devglan.model.ApiResponse;
import com.devglan.model.Receipt;
import com.devglan.model.ReceiptDto;
import com.devglan.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping
    public ApiResponse<Receipt> saveReceipt(@RequestBody ReceiptDto receipt){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",receiptService.save(receipt));
    }

    @GetMapping
    public ApiResponse<List<Receipt>> listReceipt(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",receiptService.findAll());
    }

    /*

    @GetMapping
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.", null);
    }
     */
}

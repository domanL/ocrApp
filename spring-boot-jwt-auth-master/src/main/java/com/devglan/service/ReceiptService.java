package com.devglan.service;

import com.devglan.model.Receipt;
import com.devglan.model.ReceiptDto;

import java.util.List;

public interface ReceiptService {

    Receipt save(ReceiptDto receipt);
    List<Receipt> findAll();
    void delete(int id);

    Receipt findOne(int id);
    Receipt update (ReceiptDto receiptDto);
}

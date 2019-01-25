package com.devglan.service.impl;

import com.devglan.dao.ReceiptDao;
import com.devglan.model.Receipt;
import com.devglan.model.ReceiptDto;
import com.devglan.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "receiptService")
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptDao receiptDao;

    @Override
    public Receipt save(ReceiptDto receipt) {
        Receipt newReceipt = new Receipt();

        newReceipt.setId(receipt.getId());
        newReceipt.setShop(receipt.getShop());
        newReceipt.setProduct(receipt.getProduct());
        newReceipt.setQuantity(receipt.getQuantity());
        newReceipt.setUsername(receipt.getUsername());
        newReceipt.setPrice(receipt.getPrice());

        return receiptDao.save(newReceipt);
    }

    @Override
    public List<Receipt> findAll() {
        List<Receipt> list = new ArrayList<>();
        receiptDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Receipt findOne(int id) {
        return null;
    }

    @Override
    public Receipt update(ReceiptDto receiptDto) {
        return null;
    }
}

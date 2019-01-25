package com.devglan.dao;

import com.devglan.model.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDao extends CrudRepository<Receipt, Integer> {

    Receipt findByUsername(String username);
}

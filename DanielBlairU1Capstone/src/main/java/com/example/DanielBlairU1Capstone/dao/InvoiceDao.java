package com.example.DanielBlairU1Capstone.dao;

import com.example.DanielBlairU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice add(Invoice invoice);

    Invoice get(int invoice_id);

    List<Invoice> getAll();

    void delete(int id);
}
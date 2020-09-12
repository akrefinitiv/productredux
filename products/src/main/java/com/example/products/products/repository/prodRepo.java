package com.example.products.products.repository;

import com.example.products.products.model.prodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface prodRepo extends JpaRepository<prodModel,String> {
}
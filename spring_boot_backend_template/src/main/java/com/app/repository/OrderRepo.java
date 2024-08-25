package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Orderr;

public interface OrderRepo extends JpaRepository<Orderr, Long> {

}

package com.kitchen.Sonal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.kitchen.Sonal.model.Customer;
import com.kitchen.Sonal.model.Menu;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
public List<Customer>  findByMenuId(long id);
@Transactional
@Modifying
@Query(value="insert into customer_menu values(?1,?2)" , nativeQuery = true)
public void buysProduct(long cid,long pid);
}

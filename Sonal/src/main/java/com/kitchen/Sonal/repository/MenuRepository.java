package com.kitchen.Sonal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kitchen.Sonal.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{
public List<Menu> findByCategoryId(long cid);


@Query(value="select * from menu where name LIKE %?1%",nativeQuery = true)
public List<Menu> searchByProductTitle(String name);

  
}

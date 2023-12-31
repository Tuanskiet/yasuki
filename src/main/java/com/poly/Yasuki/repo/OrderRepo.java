package com.poly.Yasuki.repo;

import com.poly.Yasuki.entity.Order;
import com.poly.Yasuki.entity.RoleApp;
import com.poly.Yasuki.entity.UserApp;
import com.poly.Yasuki.enums.RoleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT * FROM `order` WHERE CONCAT(name, ' ', email, ' ', phone_number) LIKE %?1%", nativeQuery = true)
    Page<Order> findByKeyword(String keyword, Pageable pageable);

    @Query(value = "SELECT o FROM Order o ORDER BY o.createAt DESC")
    Page<Order> findAllWithSortByDateCreate(Pageable pageable);

    List<Order> findAllByUserApp(UserApp userApp);

    @Query(value = "SELECT o FROM Order o WHERE o.status LIKE :status AND o.userApp = :userApp")
    List<Order> findByUserAndStatus(UserApp userApp, String status);
}

package com.poly.Yasuki.repo;

import com.poly.Yasuki.entity.MyCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCategoryRepo extends JpaRepository<MyCategory, Integer> {
    MyCategory findMyCategoryBySlug(String slug);
    @Query(value = "SELECT * FROM Categories  WHERE name LIKE %:keyword%", nativeQuery = true)
    Page<MyCategory> findByKeyword(String keyword, Pageable pageable);
}

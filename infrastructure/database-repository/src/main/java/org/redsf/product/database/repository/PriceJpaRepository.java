package org.redsf.product.database.repository;

import org.redsf.product.database.repository.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {
    @Query("SELECT p FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND :startDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findByProductIdAndBrandIdAndDate(int productId, int brandId, String startDate);
}

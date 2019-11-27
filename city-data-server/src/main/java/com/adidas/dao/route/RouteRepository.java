package com.adidas.dao.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adidas.model.route.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

}

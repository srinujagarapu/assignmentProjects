package assignment.StoreRestApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import assignment.StoreRestApp.jpaEntity.StoreDetailsEntity;

public interface StoreDetailsRepo  extends JpaRepository<StoreDetailsEntity,Long>{

}

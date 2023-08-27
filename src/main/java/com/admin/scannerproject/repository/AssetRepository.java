package com.admin.scannerproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.scannerproject.user.AssetEntity;

public interface AssetRepository extends JpaRepository<AssetEntity, Long>{


@Query(value ="select * from dem2.addassets where isactive=?", nativeQuery =true)
List<AssetEntity> findAllByIsActive(byte isactive);

AssetEntity findBySeatIdBookId(Long seatId);

}




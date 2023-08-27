package com.admin.scannerproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.scannerproject.repository.AssetRepository;
import com.admin.scannerproject.user.AssetEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetEntity> getAllAssets() {
        return assetRepository.findAll();
    }

    public AssetEntity getAssetById(Long id) {
        Optional<AssetEntity> optionalAsset = assetRepository.findById(id);
        return optionalAsset.orElse(null);
    }

    public AssetEntity createOrUpdateAsset(AssetEntity asset) {
        return assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
    
    
    public List<AssetEntity> createSeatsForCubical(AssetDto assetDto) {
        Integer cubicalNumber = assetDto.getCubicalno();

        if (cubicalNumber == null) {
            // Handle the case where cubicalno is null
            return Collections.emptyList(); // or return an error
        }

        List<AssetEntity> createdSeats = new ArrayList<>();

        for (int i = 1; i <= cubicalNumber; i++) {
            AssetEntity seat = new AssetEntity();
            seat.setBuildingno(assetDto.getBuildingno());
            seat.setFloor(assetDto.getFloor());
            seat.setCubicalno(i);
            seat.setStatus("Empty");
            seat.setIsActive((byte) 1);
            // Set other properties as needed
            createdSeats.add(assetRepository.save(seat));
        }

        return createdSeats;
    }
    
}








 








 

package com.admin.scannerproject.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.admin.scannerproject.service.AssetDto;
import com.admin.scannerproject.service.AssetService;
import com.admin.scannerproject.user.AssetEntity;
//import com.admin.scannerproject.user.GenerateRequest;

import java.util.List;

@RestController
@RequestMapping("/assets")
@CrossOrigin("*")
public class AssetController {

    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<List<AssetEntity>> getAllAssets() {
        List<AssetEntity> assets = assetService.getAllAssets();
        return new ResponseEntity<>(assets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetEntity> getAssetById(@PathVariable Long id) {
        AssetEntity asset = assetService.getAssetById(id);
        if (asset != null) {
            return new ResponseEntity<>(asset, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping
//    public ResponseEntity<AssetEntity> createAsset(@RequestBody AssetEntity asset) {
//        AssetEntity newAsset = assetService.createOrUpdateAsset(asset);
//        return new ResponseEntity<>(newAsset, HttpStatus.CREATED);
//    }
    
//    @PostMapping("/generate")
//    public ResponseEntity<List<AssetEntity>> generateSeats(@RequestBody AssetEntity entity) {
//        List<AssetEntity> createdSeats = assetService.createSeatsForCubical(entity);
//        return new ResponseEntity<>(createdSeats, HttpStatus.OK);
//    }
    
    @PostMapping("/generate")
    public ResponseEntity<String> generateAsset(@RequestBody AssetDto assetDto) {
        try {
            // Call the service method to create the assets
            List<AssetEntity> createdAssets = assetService.createSeatsForCubical(assetDto);

            if (!createdAssets.isEmpty()) {
                return ResponseEntity.ok("Asset(s) generated successfully.");
            } else {
                return ResponseEntity.badRequest().body("Failed to generate assets.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssetEntity> updateAsset(@PathVariable Long id, @RequestBody AssetEntity asset) {
        AssetEntity updatedAsset = assetService.createOrUpdateAsset(asset);
        return new ResponseEntity<>(updatedAsset, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



  








 



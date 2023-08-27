package com.admin.scannerproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.scannerproject.user.AssetEntity;
import com.admin.scannerproject.user.BookSeatEntity;

public interface BookSeatRepo extends JpaRepository<BookSeatEntity, Long> {
	
	
	
	@Query(value ="select * from dem2.bookseat where isactive=?", nativeQuery =true)
	List<BookSeatEntity> findAllByIsActive(byte isactive);


}

package com.demo.algo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.algo.model.DemoTable;

public interface DemoRepository extends JpaRepository<DemoTable, Long>{
	
	@Query("select e from DemoTable e order by Id desc")
	public List<DemoTable> getData();
	
	@Query("select max(e.Id) from DemoTable e")
	public Long getMaxId();
}
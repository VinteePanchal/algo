package com.demo.algo.service;

import java.util.List;

import com.demo.algo.model.DemoTable;

public interface DemoService {
    
	public List<DemoTable> getData();
	
	public DemoTable saveData(List<Integer> unsortedList);
}

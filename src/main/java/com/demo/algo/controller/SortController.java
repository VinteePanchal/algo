package com.demo.algo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.algo.model.DemoTable;
import com.demo.algo.service.DemoService;

@Controller
public class SortController {

	@Autowired
	private DemoService demoService;

	@RequestMapping("/sort")
	String home(ModelMap modal) {
		modal.addAttribute("title", "Bubble Sort");
		return "index";
	}

	@RequestMapping(value = "/sort/list", method = RequestMethod.GET)
	public ResponseEntity<List<DemoTable>> listData() {
		List<DemoTable> listDetails = demoService.getData();
		if (listDetails.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DemoTable>>(listDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/sort/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveData(@RequestBody List<Integer> unsortedList) {
		DemoTable demoTable = demoService.saveData(unsortedList);
		if (null == demoTable) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
package com.demo.algo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.algo.model.DemoTable;
import com.demo.algo.repository.DemoRepository;

@Component("demoService")
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoRepository demoRepository;

	public DemoServiceImpl(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	@Override
	public List<DemoTable> getData() {
		List<DemoTable> demoList = null;
		try {
			demoList = demoRepository.getData();
		} catch (Exception ex) {
			System.out.println("Exception while fetching the data : " + ex.getMessage());
		}
		return demoList;
	}

	@Override
	public DemoTable saveData(List<Integer> unsortedList) {
		DemoTable demoTab = null;
		try {
			DemoTable demoTable = new DemoTable();
			Long Id = demoRepository.getMaxId();
			if (null == Id) {
				Id = 0L;
			}
			demoTable.setId(Id + 1);
			demoTable.setUnsorted(unsortedList.toString());
			Long counter = 0L;
			int n = unsortedList.size();
			Long beforeMillisec = System.currentTimeMillis();
			for (int i = 0; i < n - 1; i++)
				for (int j = 0; j < n - i - 1; j++)
					if (unsortedList.get(j + 1).compareTo(unsortedList.get(j)) < 0) {
						unsortedList.add(j, unsortedList.remove(j + 1));
						counter = counter + 1;
					}
			Long afterMillisec = System.currentTimeMillis();
			Long timeDiff = afterMillisec - beforeMillisec;
			demoTable.setSorted(unsortedList.toString());
			demoTable.setDuration(timeDiff);
			demoTable.setSwaps(counter);
			demoTab = demoRepository.save(demoTable);
		} catch (Exception ex) {
			System.out.println("Exception while saving data : " + ex.getMessage());
		}

		return demoTab;
	}

}

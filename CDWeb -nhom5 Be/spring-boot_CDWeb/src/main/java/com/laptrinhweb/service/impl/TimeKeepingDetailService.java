package com.laptrinhweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.dto.TimeKeepingDetailDTO;
import com.laptrinhweb.entity.TimeKeepingDetailEntity;
import com.laptrinhweb.repository.TimeKeepingDetailRepository;
import com.laptrinhweb.service.ITimeKeepingDetailService;

@Service
public class TimeKeepingDetailService implements ITimeKeepingDetailService{

	@Autowired
	private TimeKeepingDetailRepository timeKeepingDetailRepostory;
	
	

	@Override
	public List<TimeKeepingDetailDTO> findAllHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeKeepingDetailDTO endTimeKeepingforOneDay(TimeKeepingDetailDTO model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeKeepingDetailDTO removeTimeKeeping(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeKeepingDetailDTO> findAllShift(String shift) {
		List<TimeKeepingDetailEntity> listTKD = timeKeepingDetailRepostory.findByShift(shift);
		for (TimeKeepingDetailEntity item : listTKD) {
		//	TimeKeepingDetailDTO dto = 
		}
		return null;
	}
	
}

package com.laptrinhweb.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.TimeKeepingConveter;
import com.laptrinhweb.dto.DateTime;
import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.entity.TimeKeepingEntity;
import com.laptrinhweb.repository.EmployeeRepository;
import com.laptrinhweb.repository.TimeKeepingRepository;
import com.laptrinhweb.service.ITimeKeepingService;



@Service 
public class TimeKeepingService implements ITimeKeepingService{

	@Autowired
	private EmployeeRepository employeeReposiotry;
	
	@Autowired
	private TimeKeepingRepository timeKeepingRepository;
	
	@Autowired
	private TimeKeepingConveter timeKeepingConveter;
	
	// tạo bảng lương với tất cả danh sách nhân viên
		// nếu thời gian hiện tại(nowDate) < startDate -20; + chấm công
		// nếu thời gian hiện tại(nowDate) > startDate -20; + tạo ra bảng lương mới
		/* 
		 * Status 1:Chấm công
		 * Status 2:Chốt bảng công
		 * Status 3: đã trả lương
		 * */
	@Override
	public List<TimeKeepingDTO> saveAll() {
		List<TimeKeepingEntity> oldList = timeKeepingRepository.findAll();
		TimeKeepingDTO lastTimeKeepingDto = timeKeepingConveter.toDTO(oldList.get(oldList.size()));
		List<EmployeeEntity> listEmployeeEntity = employeeReposiotry.findAll();
			// lấy ngày hiện tại ra kiểm tra
		   Calendar c = Calendar.getInstance();
		   DateTime nowDate = new DateTime();
		   DateTime lastDate = new DateTime();
		   nowDate.setDate(c.get(Calendar.YEAR), c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH));
		   
		   for (EmployeeEntity item : listEmployeeEntity) {
			   TimeKeepingEntity t = new TimeKeepingEntity();
			   t.setDateStart(nowDate+"");
			   t.setEmployee(item);
			   t.setMinimumTime(6);
			   t.setStatus(1);
		}
		   
		 
		
		return null;
	}

	private void get(int year) {
		// TODO Auto-generated method stub
		
	}

}

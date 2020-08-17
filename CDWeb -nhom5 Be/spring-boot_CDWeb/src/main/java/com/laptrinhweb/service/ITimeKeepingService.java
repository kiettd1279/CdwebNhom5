package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.TimeKeepingDTO;

public interface ITimeKeepingService {
	// tạo bảng lương với tất cả danh sách nhân viên
	// nếu thời gian hiện tại(nowDate) < startDate -20; + chấm công
	// nếu thời gian hiện tại(nowDate) > startDate -20; + tạo ra bảng lương mới
	/* 
	 * Status 1:Chấm công
	 * Status 2:Chốt bảng công
	 * Status 3: đã trả lương
	 * */
	
	List<TimeKeepingDTO> saveAll();
	
	// chức năng chấm công cho 1 nhân viên trong 1 cột lương
	
}

package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.TimeKeepingDetailDTO;
import com.laptrinhweb.entity.TimeKeepingDetailEntity;

@Component
public class TimeKeepingKeepingDetailConveter {
	public TimeKeepingDetailDTO toDTO(TimeKeepingDetailEntity entity) {
		TimeKeepingDetailDTO dto = new TimeKeepingDetailDTO();
		dto.setId(entity.getId());
		dto.setShift(entity.getShift());
		dto.setStatus(entity.getStatus());
		//dto.setTimeStart();
		
		return dto;
	}
}

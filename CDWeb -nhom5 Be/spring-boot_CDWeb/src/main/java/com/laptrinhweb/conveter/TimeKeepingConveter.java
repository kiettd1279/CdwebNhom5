package com.laptrinhweb.conveter;

import org.springframework.stereotype.Component;

import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.entity.TimeKeepingEntity;

@Component
public class TimeKeepingConveter {
	public TimeKeepingEntity toEntity(TimeKeepingDTO dto) {
		TimeKeepingEntity entity = new TimeKeepingEntity();
		entity.setDateEnd(dto.getDateEnd());
		entity.setDateStart(dto.getDateStart());
		entity.setMinimumTime(dto.getMinimumTime());
		entity.setNote(dto.getNote());
		entity.setOverTime(dto.getOverTime());
		entity.setTimeLate(dto.getTimeLate());
		entity.setWorkTime(dto.getWorkTime());
		entity.setStatus(dto.getSatus());
		return entity;
	}
	public TimeKeepingDTO toDTO(TimeKeepingEntity entity) {
		TimeKeepingDTO dto=  new TimeKeepingDTO();
		dto.setDateEnd(entity.getDateEnd());
		dto.setDateStart(entity.getDateStart());
		dto.setMinimumTime(entity.getMinimumTime());
		dto.setNote(entity.getNote());
		dto.setOverTime(entity.getOverTime());
		dto.setTimeLate(entity.getTimeLate());
		dto.setWorkTime(entity.getWorkTime());
		dto.setSatus(entity.getStatus());
		return dto;
		
	}
}

package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.rmi.CORBA.Tie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhweb.conveter.TimeKeepingConveter;
import com.laptrinhweb.dto.DateTime;
import com.laptrinhweb.dto.TimeKeepingDTO;
import com.laptrinhweb.dto.TimeKeepingInforDTO;
import com.laptrinhweb.entity.EmployeeEntity;
import com.laptrinhweb.entity.TimeKeepingDetailEntity;
import com.laptrinhweb.entity.TimeKeepingEntity;
import com.laptrinhweb.repository.EmployeeRepository;
import com.laptrinhweb.repository.TimeKeepingDetailRepository;
import com.laptrinhweb.repository.TimeKeepingRepository;
import com.laptrinhweb.service.ITimeKeepingService;

@Service
public class TimeKeepingService implements ITimeKeepingService {

	@Autowired
	private EmployeeRepository employeeReposiotry;

	@Autowired
	private TimeKeepingRepository timeKeepingRepository;

	@Autowired
	private TimeKeepingConveter timeKeepingConveter;

	@Autowired
	private TimeKeepingDetailRepository timeKeepingDetailRepository;

	// tạo bảng lương với tất cả danh sách nhân viên
	// nếu thời gian hiện tại(nowDate) < startDate -20; + chấm công
	// nếu thời gian hiện tại(nowDate) > startDate -20; + tạo ra bảng lương mới
	/*
	 * Status 1:Chấm công Status 2:Chốt bảng công Status 3: đã trả lương
	 */
	@Override
	public List<TimeKeepingDTO> saveAll() {
//		List<TimeKeepingEntity> oldList = timeKeepingRepository.findAll();
//		TimeKeepingDTO lastTimeKeepingDto = timeKeepingConveter.toDTO(oldList.get(oldList.size()));
		List<TimeKeepingEntity> newListTimKeeping = new ArrayList<TimeKeepingEntity>();
		List<EmployeeEntity> listEmployeeEntity = employeeReposiotry.findAll();
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();
		// lấy ngày hiện tại ra kiểm tra
		Calendar c = Calendar.getInstance();
		DateTime nowDate = new DateTime();
		DateTime lastDate = new DateTime();
		nowDate.setDate(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
		System.out.println(nowDate.getDate());
		for (EmployeeEntity item : listEmployeeEntity) {
			TimeKeepingEntity t = new TimeKeepingEntity();

			t.setDateStart(nowDate.getDate() + "");
			t.setEmployee(item);
			t.setMinimumTime(6);
			t.setStatus(1);

			newListTimKeeping.add(t);
			listDTO.add(timeKeepingConveter.toDTO(t));
		}
		timeKeepingRepository.save(newListTimKeeping);
		return listDTO;
	}

	private void get(int year) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TimeKeepingInforDTO> findAll() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findAll();
		List<TimeKeepingInforDTO> listDTO = new ArrayList<TimeKeepingInforDTO>();

		for (TimeKeepingEntity item : listEntity) {

			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			TimeKeepingInforDTO dtoInfor = new TimeKeepingInforDTO();
			dtoInfor.setData(dto);
			dtoInfor.setOperation(true);
			listDTO.add(dtoInfor);
		}

		return listDTO;
	}

	@Override
	public TimeKeepingDTO edit(TimeKeepingDTO model) {

		return null;
	}

	@Override
	public TimeKeepingDTO update(TimeKeepingDTO model) {

		// TimeKeepingEntity oldEntity = timeKeepingRepository.findOne(model.getId());

//		TimeKeepingEntity entity = timeKeepingConveter.toEntity(oldEntity, model);
//		System.out.println(entity.getWorkTime() +"new");
//		System.out.println(oldEntity.getWorkTime() +"old");
//
//		entity.plusWorkTime();
//		entity = timeKeepingRepository.save(entity);

		return null;
	}

	@Override
	public TimeKeepingDTO findByOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeKeepingDTO> FindAll() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findAll();
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();

		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			listDTO.add(dto);
		}
		return listDTO;

	}

	@Override
	public List<TimeKeepingDTO> findMorning() {

		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByMorning(1);
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();

		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public List<TimeKeepingDTO> findAfternoon() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByAfternoon(1);
		List<TimeKeepingDTO> listDTO = new ArrayList<TimeKeepingDTO>();

		for (TimeKeepingEntity item : listEntity) {
			TimeKeepingDTO dto = timeKeepingConveter.toDTO(item);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public TimeKeepingDTO stardUp(TimeKeepingDTO model, String shift) {
		TimeKeepingEntity oldentity = timeKeepingRepository.findOne(model.getId());

		TimeKeepingDetailEntity tkd = new TimeKeepingDetailEntity("", shift, oldentity);
		tkd = timeKeepingDetailRepository.save(tkd);
		if (shift.equals("morning")) {
			oldentity.setMorning(0);
		}
		if (shift.equals("afternoon")) {
			oldentity.setAfternoon(0);
		}
		oldentity = timeKeepingRepository.save(oldentity);
		return timeKeepingConveter.toDTO(oldentity);
	}

	@Override
	public List<TimeKeepingDTO> RefetTimeKeeping() {
		List<TimeKeepingEntity> listEntity = timeKeepingRepository.findByStatus(1);
		List<TimeKeepingDTO> dtos = new ArrayList<TimeKeepingDTO>();
		for (TimeKeepingEntity item : listEntity) {
			item.setMorning(1);
			item.setAfternoon(1);
			dtos.add(timeKeepingConveter.toDTO(item));
		}
		timeKeepingRepository.save(listEntity);
		return dtos;
	}

	@Override
	public List<TimeKeepingDTO> CloseTimeKeeping() {
		return null;
	}
}
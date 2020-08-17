package com.laptrinhweb.dto;

public class DateTime {
	private int date;

	public DateTime() {

	}

	public void setDate(String t, String keywordCut) {
		String[] list = t.split(keywordCut);

		int day = Integer.parseInt(list[0]);

		int month = Integer.parseInt(list[1]);

		int yearth = Integer.parseInt(list[2]);

		date += yearth;

		date = date * 100 + month;
		System.out.println(date);
		date = date * 100 + day;
	}
	public void setDate(int day,int month,int yearth) {
		date += yearth;

		date = date * 100 + month;
		date = date * 100 + day;
	}
		
	public void setDate(int date) {
		this.date = date;
	}

	public int getDate() {
		return this.date;
	}
	
}

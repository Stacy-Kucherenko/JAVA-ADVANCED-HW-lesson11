package ua.lviv.lgs.magazineShop.dto;

import java.time.LocalDate;

public class SubscribesDTO {
	public int id;
	public String title;
	public String description;
	public LocalDate publishDate;
	public int subscribePrice;
	public boolean subscribeStatus;
	public LocalDate subscribeDate;
	public int subscribePeriod;
}
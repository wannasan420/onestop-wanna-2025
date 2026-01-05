package com.jdc.spring.jpa.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Section {

	@EmbeddedId
	private SectionPk id;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;

	@ElementCollection
	@CollectionTable(name = "SECTION_DAYS")
	private List<DayOfWeek> days;
	
	private String daysCol;
	
	@Column(nullable = false)
	private String startTime;

	@Column(nullable = false)
	private String endTime;
	
	private LocalDate endAt;
	private int fees;
	
}

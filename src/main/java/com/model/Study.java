package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Study {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "patient_id")
	private String patient_id;

	@Column(name = "description")
	private String description;

	@Column(name = "study_status")
	private String study_status;

	@Column(name = "planned_start_time")
	private int planned_start_time;

	@Column(name = "estimated_end_time")
	private int estimated_end_time;

	@Column(name = "room_id")
	private int room_id;

	@Column(name = "doctor_id")
	private int doctor_id;

	public Study(String id, String patient_id, String description, String study_status, int planned_start_time,
			int estimated_end_time, int room_id, int doctor_id) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.description = description;
		this.study_status = study_status;
		this.planned_start_time = planned_start_time;
		this.estimated_end_time = estimated_end_time;
		this.room_id = room_id;
		this.doctor_id = doctor_id;
	}

	public Study(String patient_id, String description, String study_status, int planned_start_time,
			int estimated_end_time, int room_id, int doctor_id) {
		this.patient_id = patient_id;
		this.description = description;
		this.study_status = study_status;
		this.planned_start_time = planned_start_time;
		this.estimated_end_time = estimated_end_time;
		this.room_id = room_id;
		this.doctor_id = doctor_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStudy_status() {
		return study_status;
	}

	public void setStudy_status(String study_status) {
		this.study_status = study_status;
	}

	public int getPlanned_start_time() {
		return planned_start_time;
	}

	public void setPlanned_start_time(int planned_start_time) {
		this.planned_start_time = planned_start_time;
	}

	public int getEstimated_end_time() {
		return estimated_end_time;
	}

	public void setEstimated_end_time(int estimated_end_time) {
		this.estimated_end_time = estimated_end_time;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

}

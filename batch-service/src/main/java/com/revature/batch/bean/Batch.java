package com.revature.batch.bean;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name = "batches")
public class Batch {

	@Id
	@Column(name = "Batch_ID")
	@SequenceGenerator(name = "BATCH_ID_SEQ", sequenceName = "BATCH_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_ID_SEQ")
	private Integer id;

	@Column(name = "Batch_Name")
	@NotNull(message = "Batch name cannot be empty")
	private String name;

	@Column(name = "Start_Date")
	@NotNull(message = "Start date cannot be empty")
	private Timestamp startDate;

	@Column(name = "End_Date")
	@NotNull(message = "End date cannot be empty")
	private Timestamp endDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Trainer_ID", referencedColumnName = "User_Id")
	private List<Integer> userIDs;
	
	@Column(name = "TRAINER")
	@NotNull(message = "Trainer cannt be null")
	private Integer trainerID;

	@Column(name = "Batch_Type")
	private String type;
	
	@Column(name = "Batch_Length")
	private Integer length;

	public Batch() {
		super();
	}
	
	

	public Batch(@NotNull(message = "Batch name cannot be empty") String name,
			@NotNull(message = "Start date cannot be empty") Timestamp startDate,
			@NotNull(message = "End date cannot be empty") Timestamp endDate, List<Integer> userIDs,
			@NotNull(message = "Trainer cannt be null") int trainerID, String type, Integer length) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userIDs = userIDs;
		this.trainerID = trainerID;
		this.type = type;
		this.length = length;
	}



	public Batch(Integer id, String name, Timestamp startDate, Timestamp endDate, int trainer, String type,
			Integer length) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerID = trainer;
		this.type = type;
		this.length = length;
	}

	public Batch(String name, Timestamp startDate, Timestamp endDate, int trainer, String type, Integer length) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerID = trainer;
		this.type = type;
		this.length = length;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getTrainer() {
		// if needed we will get the trainer from the user micro service
		return trainerID;
	}

	public void setTrainer(int trainer) {
		// if needed we can change this to take in a trainer
		// and then grab the trainers id
		this.trainerID = trainer;
	}
	
	

	public List<Integer> getUserIDs() {
		return userIDs;
	}



	public void setUserIDs(List<Integer> userIDs) {
		this.userIDs = userIDs;
	}



	public int getTrainerID() {
		return trainerID;
	}



	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Integer getLength() {
		return length;
	}



	public void setLength(Integer length) {
		this.length = length;
	}

	

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", userIDs="
				+ userIDs + ", trainerID=" + trainerID + ", type=" + type + ", length=" + length + "]";
	}

}

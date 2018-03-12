package com.revature.batch.bean;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BATCH")
public class Batch {

	@Id
	@Column(name = "BATCH_ID")
	@SequenceGenerator(name = "BATCH_ID_SEQ", sequenceName = "BATCH_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_ID_SEQ")
	private Integer id;

	@Column(name = "BATCH_NAME")
	@NotNull(message = "Batch name cannot be empty")
	private String name;

	@Column(name = "START_DATE")
	@NotNull(message = "Start date cannot be empty")
	private Timestamp startDate;

	@Column(name = "END_DATE")
	@NotNull(message = "End date cannot be empty")
	private Timestamp endDate;
	
	@Column(name = "TRAINER")
	@NotNull(message = "Trainer cannt be null")
	private Integer trainerID;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BATCH_TYPE", referencedColumnName = "Batch_Type_ID")
	private BatchType type;

	public Batch() {
		super();
	}
	
	
	public Batch(@NotNull(message = "Batch name cannot be empty") String name,
			@NotNull(message = "Start date cannot be empty") Timestamp startDate,
			@NotNull(message = "End date cannot be empty") Timestamp endDate,
			@NotNull(message = "Trainer cannt be null") int trainerID, BatchType type) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerID = trainerID;
		this.type = type;
	}



	public Batch(Integer id, String name, Timestamp startDate, Timestamp endDate, int trainer, BatchType type) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerID = trainer;
		this.type = type;
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


	public int getTrainerID() {
		return trainerID;
	}



	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}



	public BatchType getType() {
		return type;
	}



	public void setType(BatchType type) {
		this.type = type;
	}

	

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", trainerID=" + trainerID + ", type=" + type + "]";
	}

}

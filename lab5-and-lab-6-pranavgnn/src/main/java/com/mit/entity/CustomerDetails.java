package com.mit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerName customerName;

	private LocalDate dateOfBirth;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerContactInformation> customerContactInformations;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerIdentification> customerIdentifications;

	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerProofOfId> customerProofOfIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerName getCustomerName() {
		return customerName;
	}

	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<CustomerContactInformation> getCustomerContactInformations() {
		return customerContactInformations;
	}

	public void setCustomerContactInformations(List<CustomerContactInformation> customerContactInformations) {
		this.customerContactInformations = customerContactInformations;
	}

	public List<CustomerIdentification> getCustomerIdentifications() {
		return customerIdentifications;
	}

	public void setCustomerIdentifications(List<CustomerIdentification> customerIdentifications) {
		this.customerIdentifications = customerIdentifications;
	}

	public List<CustomerProofOfId> getCustomerProofOfIds() {
		return customerProofOfIds;
	}

	public void setCustomerProofOfIds(List<CustomerProofOfId> customerProofOfIds) {
		this.customerProofOfIds = customerProofOfIds;
	}
}
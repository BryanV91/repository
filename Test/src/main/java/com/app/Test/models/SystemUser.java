package com.app.Test.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "system_user")
public class SystemUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(columnDefinition = "text")
	private String code;
	@Column(columnDefinition = "text")
	@JsonIgnore
	private String password;
	@Column(columnDefinition = "text")
	private String fullName;
	@Column(columnDefinition = "text")
	private String mail;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "system_user_role", joinColumns = @JoinColumn(name = "system_user.id"), inverseJoinColumns = @JoinColumn(name = "role.id"))
	private Set<Role> roles = new HashSet<>();
	private Boolean status;

	public SystemUser() {

	}

	public SystemUser(String username, String mail, String encode) {
		this.code = username;
		this.mail = mail;
		this.password = encode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}

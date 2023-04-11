package com.example.polahidupsehat.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {

	@SerializedName("nama")
	private String nama;

	@SerializedName("id_pasien")
	private String idPasien;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setIdPasien(String idPasien){
		this.idPasien = idPasien;
	}

	public String getIdPasien(){
		return idPasien;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
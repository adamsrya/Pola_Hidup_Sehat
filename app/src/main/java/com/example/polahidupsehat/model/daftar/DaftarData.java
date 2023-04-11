package com.example.polahidupsehat.model.daftar;

import com.google.gson.annotations.SerializedName;

public class DaftarData {

	@SerializedName("tmptlahir")
	private String tmptlahir;

	@SerializedName("jk")
	private String jk;

	@SerializedName("password")
	private String password;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tgllahir")
	private String tgllahir;

	@SerializedName("email")
	private String email;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("username")
	private String username;

	public void setTmptlahir(String tmptlahir){
		this.tmptlahir = tmptlahir;
	}

	public String getTmptlahir(){
		return tmptlahir;
	}

	public void setJk(String jk){
		this.jk = jk;
	}

	public String getJk(){
		return jk;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTgllahir(String tgllahir){
		this.tgllahir = tgllahir;
	}

	public String getTgllahir(){
		return tgllahir;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
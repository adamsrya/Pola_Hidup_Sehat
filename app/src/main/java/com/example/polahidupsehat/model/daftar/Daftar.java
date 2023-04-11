package com.example.polahidupsehat.model.daftar;

import com.google.gson.annotations.SerializedName;

public class Daftar{

	@SerializedName("data")
	private DaftarData daftarData;

	@SerializedName("error")
	private int error;

	@SerializedName("status")
	private boolean status;

	public void setData(DaftarData daftarData){
		this.daftarData = daftarData;
	}

	public DaftarData getData(){
		return daftarData;
	}

	public void setError(int error){
		this.error = error;
	}

	public int getError(){
		return error;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}
}
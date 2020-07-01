package com.edu.model;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadModel {
	private CommonsMultipartFile[] fileDatas;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommonsMultipartFile[] getFileDatas() {
		return fileDatas;
	}

	public void setFileDatas(CommonsMultipartFile[] fileDatas) {
		this.fileDatas = fileDatas;
	}

	@Override
	public String toString() {
		return "UploadModel [fileDatas=" + Arrays.toString(fileDatas) + ", description=" + description + "]";
	}

}

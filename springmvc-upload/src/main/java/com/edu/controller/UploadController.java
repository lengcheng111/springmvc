package com.edu.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.edu.model.UploadModel;

@Controller
public class UploadController {

	@RequestMapping(value = "showUpload")
	public String showUpload(Model model) {
		model.addAttribute("uploadModel", new UploadModel());
		return "uploadSingleFile";
	}

	@RequestMapping(value = "showUploadMultiple")
	public String showUploadMutiple(Model model) {
		model.addAttribute("uploadModel", new UploadModel());
		return "uploadMultipleFile";
	}

	@RequestMapping(value = "Upload", method = RequestMethod.POST)
	public String doUpload(HttpServletRequest request, @ModelAttribute("uploadModel") UploadModel uploadModel,
			Model model) {
		try {
			this.upload(request, model, uploadModel);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return "uploadSingleFile";
	}

	@RequestMapping(value = "UploadMultiple", method = RequestMethod.POST)
	public String uploadMultiple(HttpServletRequest request, @ModelAttribute("uploadModel") UploadModel uploadModel,
			Model model) {
		try {
			this.upload(request, model, uploadModel);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return "uploadMultipleFile";
	}

	private String upload(HttpServletRequest request, Model model, UploadModel uploadModel) throws IOException {
		final CommonsMultipartFile[] fileDatas = uploadModel.getFileDatas();
		final String path = "/Users/truonglv/Desktop/"; // đường dẫn cố định trên máy của
		// java.io: thư viện để hỗ trợ thao tác file (read, write, ...)
		// java.nio, nó như java.io, từ java8, hỗ trợ, dùng tốt hơn, java.io.
		for (final CommonsMultipartFile fileData : fileDatas) {
			FileUtils.forceMkdir(new File(path));
			final File upload = new File(path + fileData.getOriginalFilename());
			fileData.transferTo(upload);
		}
		model.addAttribute("uploadModel", uploadModel);
		return "uploadSingleFile";
	}
}

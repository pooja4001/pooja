package com.capgemini.backgroundverification.contoller;


import java.io.IOException;

import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.backgroundverification.entity.FileModel;
import com.capgemini.backgroundverification.service.FileService;
@RestController
@CrossOrigin("http://localhost:4200")
public class FileController {
	
	@Autowired
	//FileRepository fileRepository;
	FileService fileService;

	@PostMapping("/upload")
	public  org.springframework.http.ResponseEntity.BodyBuilder uplaodFiles(@RequestParam("File") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		FileModel files = new FileModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		fileService.uploadFiles(files);
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	
	@GetMapping(path = { "/get/{fileId}" })
	public FileModel GetById(@PathVariable("fileId") Long fileId) throws IOException {
		final Optional<FileModel> retrievedImage = fileService.GetById(fileId);
		FileModel img = new FileModel(retrievedImage.get().getName(), retrievedImage.get().getMimetype(),
				decompressBytes(retrievedImage.get().getPic()));
		return img;
	}
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}
  
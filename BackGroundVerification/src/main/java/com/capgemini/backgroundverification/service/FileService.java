package com.capgemini.backgroundverification.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.backgroundverification.dao.FileRepository;
import com.capgemini.backgroundverification.entity.FileModel;

@Service
@Transactional
public class FileService {

	@Autowired
	FileRepository fileRepository;
	public void uploadFiles(FileModel files) {
		// TODO Auto-generated method stub
		fileRepository.save(files);
	}
	public Optional<FileModel> GetById(Long fileId) {
		// TODO Auto-generated method stub
		Optional<FileModel> retrievedImage=fileRepository.findById(fileId);
		return retrievedImage;
	}
	
}

package com.capgemini.backgroundverification.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.backgroundverification.entity.*;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface FilesRepository extends JpaRepository<FileModel, Long>{	
	public Optional<FileModel> findByName(String name);
	}
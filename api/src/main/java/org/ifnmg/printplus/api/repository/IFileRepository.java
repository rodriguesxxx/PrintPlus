package org.ifnmg.printplus.api.repository;

import org.ifnmg.printplus.api.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFileRepository extends JpaRepository<FileEntity, String> {}

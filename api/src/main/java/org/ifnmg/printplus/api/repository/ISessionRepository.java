package org.ifnmg.printplus.api.repository;

import org.ifnmg.printplus.api.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessionRepository extends JpaRepository<Session, String> {}

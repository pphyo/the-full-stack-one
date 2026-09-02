package com.codoverse.asy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codoverse.asy.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}

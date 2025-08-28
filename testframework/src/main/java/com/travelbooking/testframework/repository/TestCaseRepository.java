package com.travelbooking.testframework.repository;

import com.travelbooking.testframework.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase,Long> {

}

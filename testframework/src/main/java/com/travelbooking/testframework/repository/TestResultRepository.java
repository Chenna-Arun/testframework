package com.travelbooking.testframework.repository;

import com.travelbooking.testframework.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {

    // Correct way to find by TestCase's ID
    List<TestResult> findByTestCase_Id(Long testCaseId);
}

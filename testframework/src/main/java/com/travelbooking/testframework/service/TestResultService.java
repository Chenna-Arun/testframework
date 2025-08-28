package com.travelbooking.testframework.service;

import com.travelbooking.testframework.model.TestCase;
import com.travelbooking.testframework.model.TestResult;
import com.travelbooking.testframework.repository.TestCaseRepository;
import com.travelbooking.testframework.repository.TestResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestResultService {

    private final TestResultRepository testResultRepository;
    private final TestCaseRepository testCaseRepository;

    public TestResultService(TestResultRepository testResultRepository, TestCaseRepository testCaseRepository) {
        this.testResultRepository = testResultRepository;
        this.testCaseRepository = testCaseRepository;
    }

    // ✅ Get all test results
    public List<TestResult> getAllTestResults() {
        return testResultRepository.findAll();
    }

    // ✅ Get a single test result by ID
    public Optional<TestResult> getTestResultById(Long id) {
        return testResultRepository.findById(id);
    }

    // ✅ Get all results belonging to a test case
    public List<TestResult> getResultsByTestCase(Long testCaseId) {
        return testResultRepository.findByTestCase_Id(testCaseId);
    }

    // ✅ Create a new test result (fix: fetch full TestCase)
    public TestResult createTestResult(TestResult testResult) {
        Long testCaseId = testResult.getTestCase().getId();
        TestCase testCase = testCaseRepository.findById(testCaseId)
                .orElseThrow(() -> new RuntimeException("TestCase not found with id " + testCaseId));

        testResult.setTestCase(testCase);
        return testResultRepository.save(testResult);
    }

    // ✅ Update a test result (fix: fetch full TestCase if needed)
    public TestResult updateTestResult(Long id, TestResult updatedResult) {
        return testResultRepository.findById(id).map(existing -> {
            existing.setStatus(updatedResult.getStatus());
            existing.setExecutedAt(updatedResult.getExecutedAt());

            if (updatedResult.getTestCase() != null) {
                Long testCaseId = updatedResult.getTestCase().getId();
                TestCase testCase = testCaseRepository.findById(testCaseId)
                        .orElseThrow(() -> new RuntimeException("TestCase not found with id " + testCaseId));
                existing.setTestCase(testCase);
            }

            return testResultRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("TestResult not found with id " + id));
    }

    // ✅ Delete a test result
    public void deleteTestResult(Long id) {
        testResultRepository.deleteById(id);
    }
}

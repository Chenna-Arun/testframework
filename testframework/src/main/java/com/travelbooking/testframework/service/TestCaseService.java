package com.travelbooking.testframework.service;

import com.travelbooking.testframework.model.TestCase;
import com.travelbooking.testframework.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {

    private final TestCaseRepository testCaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    public Optional<TestCase> getTestCaseById(Long id) {
        return testCaseRepository.findById(id);
    }

    public TestCase createTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public TestCase updateTestCase(Long id, TestCase updatedTestCase) {
        return testCaseRepository.findById(id).map(existing -> {
            existing.setName(updatedTestCase.getName());
            existing.setTestType(updatedTestCase.getTestType());
            existing.setDescription(updatedTestCase.getDescription());
            existing.setStatus(updatedTestCase.getStatus());
            return testCaseRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("TestCase not found with id " + id));
    }

    public void deleteTestCase(Long id) {
        if (testCaseRepository.existsById(id)) {
            testCaseRepository.deleteById(id);
        } else {
            throw new RuntimeException("TestCase not found with id " + id);
        }
    }
}

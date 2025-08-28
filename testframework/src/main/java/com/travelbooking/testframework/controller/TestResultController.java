package com.travelbooking.testframework.controller;

import com.travelbooking.testframework.model.TestResult;
import com.travelbooking.testframework.service.TestResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testresults")
public class TestResultController {

    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping
    public List<TestResult> getAllTestResults() {
        return testResultService.getAllTestResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestResult> getTestResultById(@PathVariable Long id) {
        return testResultService.getTestResultById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/testcase/{testCaseId}")
    public List<TestResult> getResultsByTestCase(@PathVariable Long testCaseId) {
        return testResultService.getResultsByTestCase(testCaseId);
    }

    @PostMapping
    public TestResult createTestResult(@RequestBody TestResult testResult) {
        return testResultService.createTestResult(testResult);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestResult> updateTestResult(@PathVariable Long id, @RequestBody TestResult testResult) {
        return ResponseEntity.ok(testResultService.updateTestResult(id, testResult));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestResult(@PathVariable Long id) {
        testResultService.deleteTestResult(id);
        return ResponseEntity.noContent().build();
    }
}

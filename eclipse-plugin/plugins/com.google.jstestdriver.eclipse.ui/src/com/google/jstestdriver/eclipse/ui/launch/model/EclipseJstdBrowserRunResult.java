/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.jstestdriver.eclipse.ui.launch.model;

import com.google.jstestdriver.TestResult;

/**
 * Represents the results for a particular browser.
 * 
 * @author shyamseshadri@google.com (Shyam Seshadri)
 */
public class EclipseJstdBrowserRunResult extends ResultModel {

  public EclipseJstdBrowserRunResult(EclipseJstdTestRunResult parent,
      String browser) {
    super(parent, browser);
    passImagePath = TEST_SUITE_PASS_ICON;
    failImagePath = TEST_SUITE_FAIL_ICON;
  }

  @Override
  public void addTestResult(TestResult result) {
    EclipseJstdTestCaseResult testCaseResult = (EclipseJstdTestCaseResult) results
        .get(result.getTestCaseName());
    if (testCaseResult == null) {
      testCaseResult = new EclipseJstdTestCaseResult(this, result
          .getTestCaseName());
    }
    testCaseResult.addTestResult(result);
    results.put(result.getTestCaseName(), testCaseResult);
  }
}
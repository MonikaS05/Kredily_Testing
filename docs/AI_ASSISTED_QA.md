# Kredily HRMS — AI-Assisted QA Documentation

**Tester Name:** Monika Shankar  
**AI Tool Used:** ChatGPT (OpenAI)  
**Activity:** AI-Assisted QA Review & Test Coverage Enhancement  
**Application:** Kredily HRMS Android Mobile APK  

---

## 1. Objective & Purpose of AI Assistance

The objective was to leverage Generative AI as an intelligent **QA Review Assistant** to perform static analysis and review of manually engineered test scenarios. The primary goal was to verify whether any critical edge cases, negative workflows, boundary validations, or authentication/session states were overlooked during the initial manual test design.

---

## 2. Prompt Used

The following structured prompt was provided to the AI:

```text
Act as a senior QA engineer and review the test cases I prepared for the Kredily HRMS Android application. 
Check whether my test cases adequately cover the application's major workflows, positive scenarios, 
negative scenarios, and edge cases. Identify any important scenarios or application features that I may 
have missed and suggest additional test cases where appropriate. 

Do not completely generate or rewrite my test cases. Your role is only to review, guide, and suggest areas 
that I should validate manually. Do not assume that suggested scenarios are actual application behavior.
```

---

## 3. AI-Generated Output & Suggestions

The AI acted strictly within the assigned role of a QA consultant and proposed the following review areas:
1. **Workflow Completeness:** Evaluated whether all key HRMS pillars (Authentication, Attendance, Leaves, Approvals, Payroll, Expense) had baseline end-to-end scenarios.
2. **Negative Scenarios:**
   - Suggested verifying mandatory field validations across forms (e.g., submitting leave without reason, expense without category).
   - Suggested testing invalid credential boundaries and password attempt lockouts.
3. **Edge Cases & Business Rule Boundaries:**
   - Suggested validating date constraints on leave applications (e.g., policy constraints on advance leave application, exceeding accrued leave balance).
   - Suggested checking multiple punch cycles (e.g., Clock In → Clock Out → Clock In again on the same shift).
4. **Data Synchronization & State Verification:**
   - Suggested cross-verifying attendance records across personal (`Me`) views and organizational/team (`Team`) views.
   - Suggested checking regularizations and approval states.
5. **Session & Security:**
   - Suggested checking behavior during OTP login with unverified/inactive accounts.

---

## 4. What Was Changed / Validated by the QA Engineer

As a QA Engineer, AI recommendations were evaluated with human discernment and empirical validation against the live Kredily Android APK:

1. **Empirical Validation of Suggested Scenarios:**
   - Explored and confirmed the **15-day advance notice rule** for future-dated leaves (`KRD-FUN-014`).
   - Validated that applying for leave exceeding balance correctly triggers balance validation (`KRD-FUN-015`).
   - Validated clocking in again after clocking out in the same session (`KRD-FUN-008`).
   - Validated unregistered mobile OTP behavior, identifying the explicit activation link notice (`KRD-FUN-004`).
2. **Identification of Defects from AI-Guided Exploration:**
   - While reviewing attendance data consistency between views (prompted by AI review), discovered **BUG-002** (Discrepancy between Team view and Me view).
   - While testing attendance approvals, discovered **BUG-003** (Wrong date mapped) and **BUG-004** (Approval transaction failure).
3. **Filtering & Scope Pruning:**
   - Irrelevant suggestions (such as scenarios requiring multi-tenant configurations or webhooks not present in this mobile release) were deliberately pruned.
   - No hallucinated or unverified test results were admitted into the final test suite.

---

## 5. QA Engineer's Assessment & Ethical AI Boundaries

- **Human-in-the-Loop Principle:** AI served purely as a brainstorming and advisory partner. All test execution, observations, evidence capture, bug logging, severity/priority triage, and defect reproductions were conducted 100% manually on the mobile device.
- **Verification Integrity:** Every test result recorded in the test suite and bug database represents genuine, observed software behavior.

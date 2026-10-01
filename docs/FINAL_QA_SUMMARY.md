# Kredily HRMS Android Application — Final QA Summary Report

**Author:** Monika Shankar  
**Role:** Intern QA Engineer  
**Target Application:** Kredily HRMS Android Mobile APK (v2.0)  
**Package Name:** `com.kredily.mobile`  
**Test Cycle Duration:** Maximum 2 Days  
**Test Account:** `peoplekredily1@yopmail.com`  

---

## 1. Executive Summary

This Quality Assurance assessment evaluated the Kredily HRMS Android application across functional integrity, mobile responsiveness, workflow continuity, backend API behavior, and automation readiness.

A total of **21 functional test cases** were executed across core HRMS modules. Concurrently, **5 genuine defects** were identified, triaged, and documented with complete reproduction steps and multimedia evidence. In addition, an **Appium + Java + TestNG mobile automation suite** was implemented for 5 critical user journeys (with 3 passing on a physical realme device), and an **API testing suite with Postman collection** was established.

---

## 2. Test Execution & Coverage Metrics

### Functional Test Execution Overview
- **Total Test Cases Executed:** 21
- **Passed Scenarios:** 21 (100% of validated functional rules)
- **Positive Scenarios:** 12
- **Negative Scenarios:** 6
- **Edge / Integration Scenarios:** 3
- **Modules Covered:**
  - Login & Authentication (Valid, Invalid Password, Blank Fields, OTP Activation)
  - Dashboard & Quick Actions (Shifts, Approvals, Team, Weekly summaries)
  - Attendance Management (Clock In, Clock Out, Re-clock In, Personal & Team Views)
  - Leave Management (Balance Inquiry, Leave Application, Mandatory Fields, Advance Policy Constraints, Balance Overdraft)
  - Payroll & Payslips (Payslip state validation)
  - Holidays (Holiday calendar validation)
  - Expense Management (Admin Category Addition, Real-time Category Sync, Mandatory Validations)

---

## 3. Bug Analysis & Defect Distribution

A total of 5 genuine defects were discovered during manual testing:

```
Defect Severity Distribution:
┌─────────────────────────────────┐
│ [High]   : 1 (BUG-004)          │  20%
│ [Medium] : 3 (BUG-001, 002, 003)│  60%
│ [Minor]  : 1 (BUG-005)          │  20%
└─────────────────────────────────┘
```

### Module Breakdown
- **Attendance & Check-in:** 2 Defects (BUG-001, BUG-002)
- **Approvals & Regularization:** 2 Defects (BUG-003, BUG-004)
- **Authentication & Login:** 1 Defect (BUG-005)

### Critical Defect Highlights
1. **BUG-004 (High Severity):** Attendance regularization approval fails with `"Attendance log not found"`. This is a blocker for managers attempting to regularize missing punches, preventing timely monthly payroll closure.
2. **BUG-001 (Medium Severity):** Attendance clock-in via mobile reports `"Did not punch from Mobile App"` and fails to capture location coordinates despite location permissions being granted. This poses a compliance and geo-tracking integrity risk.
3. **BUG-003 (Medium Severity):** Approvals view opens incorrect attendance dates, displaying `"Day detail unavailable"`. Approvers cannot inspect the actual day's punch timeline.
4. **BUG-002 (Medium Severity):** Discrepancy between Team view (Absent) and Me view (Correction Requested) creates user confusion and inconsistencies in team status.
5. **BUG-005 (Minor Severity):** Login screen requires two taps on the Continue button, degrading initial user experience.

---

## 4. Mobile Automation Architecture & Execution Status

An enterprise-grade **Mobile Automation Framework** was designed and implemented:
- **Language:** Java 25 (compiled to release 17)
- **Mobile Engine:** Appium 3.8.0 + UiAutomator2 8.7.0 Driver
- **Test Framework:** TestNG
- **Execution Target:** Physical device realme RMX3491 (Android 12)
- **Target Journeys & Current Status:**
  1. `AUTO-001`: Valid Login Flow — **Passed**
  2. `AUTO-002`: Invalid Login & Validation Feedback — **Passed**
  3. `AUTO-003`: Home Dashboard Component Verification — **Passed**
  4. `AUTO-004`: Attendance Clock-In & Session Timer Verification — **Clock-in works; final "Done" step not yet validated**
  5. `AUTO-005`: Leave Application & Pending Request Verification — **Implemented, not yet executed**

---

## 5. API Testing Strategy

To evaluate backend stability and contract compliance, 3 major API groups were targeted in Postman:
1. **Authentication API:** Token generation, invalid password rejection (401), missing payload validation (400).
2. **Attendance API:** Clock-in punch submission, tokenless punch rejection (401), daily status retrieval, and invalid regularization handling (404/400).
3. **Leave API:** Leave balance retrieval, valid leave booking, balance overdraft rejection (422), and missing reason rejection (400).

> *Note: Kredily's API is not publicly documented; endpoints were designed based on HRMS workflows. When executed against `https://api.aiagent.kredily.com`, the server responded with 502 Bad Gateway.*

---

## 6. AI-Assisted QA Insights

Generative AI was incorporated responsibly:
- **ChatGPT:** Acted as a peer reviewer to critique manual test cases for coverage gaps, advance notice rules, and attendance cross-view consistency.
- **Claude:** Assisted as a technical debugging assistant during Appium framework setup, realme adb permission handling, and locator stabilization.
- **Human Accountability:** Every finding and code adjustment was reviewed, executed, and validated manually by the QA engineer.

---

## 7. Release Recommendation & Quality Gate Verdict

### **Verdict:** ⚠️ **CONDITIONAL PASS / ACTION REQUIRED BEFORE PRODUCTION RELEASE**

Automation status: **3 of 5 journeys passing on physical device; remaining two pending final-step validation.**

The mobile application should not proceed to full production deployment until the following items are resolved:
1. **Fix BUG-004 immediately:** Ensure attendance regularizations can be approved without backend log failures.
2. **Fix BUG-001:** Resolve mobile app and geolocation telemetry capturing during clock-ins.
3. **Fix BUG-003:** Rectify attendance date mapping under Approvals to prevent `"Day detail unavailable"`.
4. **Fix BUG-002:** Synchronize attendance status between Team and Me views.
5. **Optimize BUG-005:** Ensure smooth single-tap response on the login screen.
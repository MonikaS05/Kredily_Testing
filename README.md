# Kredily HRMS — QA Engineer Assignment

> **Assessment Submission:** Intern QA Engineer  
> **Candidate Name:** Monika Shankar  
> **Target Application:** Kredily HRMS Android APK (v2.0)  
> **APK Link:** [Download Kredily Mobile APK](https://download.aiagent.kredily.com/static/kredily-mobile-v2.apk)  
> **Test Account:** `peoplekredily1@yopmail.com` | `Pass@9865`  
> **Repository:** [https://github.com/MonikaS05/Kredily_Testing](https://github.com/MonikaS05/Kredily_Testing)  

---

## 📌 Table of Contents
1. [Executive Summary](#-executive-summary)
2. [Repository Structure](#-repository-structure)
3. [Functional Testing (21 Test Cases)](#-functional-testing-21-test-cases)
4. [Bug Reports & Evidence (5 Genuine Bugs)](#-bug-reports--evidence-5-genuine-bugs)
5. [Mobile Automation Framework (Appium + TestNG)](#-mobile-automation-framework-appium--testng)
6. [API Testing (Postman Collection)](#-api-testing-postman-collection)
7. [AI-Assisted QA](#-ai-assisted-qa)
8. [Setup & Execution Instructions](#-setup--execution-instructions)
9. [Final QA Recommendation](#-final-qa-recommendation)

---

## 🚀 Executive Summary

This repository contains the end-to-end Quality Assurance deliverables for the **Kredily HRMS Android Application**. The evaluation spans manual exploratory testing, structured functional test cases, defect reporting with multimedia evidence, Appium mobile test automation design, backend API testing collections, and AI-assisted QA analysis.

### Evaluation Criteria Breakdown
| Evaluation Area | Weight | Coverage in this Repository |
| :--- | :---: | :--- |
| **Manual & Functional Testing** | 25% | **21 Test Cases** executed across Login, OTP, Dashboard, Attendance, Leave, Payroll, Holidays, and Expense |
| **Bug Finding & Reporting** | 20% | **5 Genuine Defects** documented with reproduction steps, severity, and screenshots/videos |
| **Mobile Automation** | 30% | **5 Critical User Journeys** automated in Java + Appium 2.x + TestNG using Page Object Model |
| **API Testing** | 10% | **Postman Collection v2.1** covering 3 APIs (Auth, Attendance, Leave) with positive & negative tests |
| **AI Usage** | 10% | AI peer-review documented with prompt, generated review, validated findings, and ethical boundaries |
| **Documentation & Code Quality** | 5% | Comprehensive Markdown documentation, Excel workbooks, and modular codebase |
| **Total** | **100%** | **Full Deliverables Package** |

---

## 📂 Repository Structure

```
Kredily_Testing/
├── README.md                                          <- Main project documentation and setup guide
├── .gitignore                                         <- Git ignore rules
│
├── Kredily_Functional_Test.xlsx                       <- Original 21 Functional Test Cases workbook
├── Kredily_Bugs.xlsx                                  <- Original Bug Reports workbook (BUG-001 to BUG-005)
├── Kredily_Mobile_Automation.xlsx                     <- Original Mobile Automation Design & Execution report
├── Kredily_AI_Assisted.xlsx                           <- Original AI-Assisted QA documentation workbook
│
├── evidence/                                          <- Evidence files for reported bugs
│   ├── Bug1.jpg                                       <- BUG-001 screenshot (Missing mobile app/GPS data)
│   ├── Bug2(1).jpg                                    <- BUG-002 screenshot (Team view discrepancy)
│   ├── Bug2(2).jpg                                    <- BUG-002 screenshot (Me view discrepancy)
│   ├── Bug2(3).jpg                                    <- BUG-002 screenshot (Me summary discrepancy)
│   ├── Bug3(1).jpg                                    <- BUG-003 screenshot (Regularization request list)
│   ├── Bug3(2).jpg                                    <- BUG-003 screenshot (Wrong date opened)
│   ├── Bug3(3).jpg                                    <- BUG-003 screenshot (Day detail unavailable)
│   ├── Bug4(1).jpeg                                   <- BUG-004 screenshot (Pending regularization)
│   ├── Bug4(2).jpg                                    <- BUG-004 screenshot (Attendance log not found error)
│   ├── Bug4(3).jpg                                    <- BUG-004 screenshot (Approval blocked)
│   └── Bug5.mp4                                       <- BUG-005 video (Two taps required on Continue)
│
├── docs/                                              <- Formatted Markdown reports
│   ├── FUNCTIONAL_TEST_CASES.md                       <- Markdown version of all 21 functional test cases
│   ├── BUG_REPORTS.md                                 <- Detailed defect documentation and impact analysis
│   ├── AI_ASSISTED_QA.md                              <- AI prompt, output analysis, and human QA validation
│   └── FINAL_QA_SUMMARY.md                            <- QA executive summary and quality gate assessment
│
├── mobile-automation/                                 <- Mobile Automation Framework (Java + Appium + TestNG)
│   ├── pom.xml                                        <- Maven project build configuration
│   ├── testng.xml                                     <- TestNG test suite runner
│   ├── README.md                                      <- Automation framework guide
│   └── src/
│       ├── main/
│       │   ├── java/com/kredily/automation/
│       │   │   ├── base/BaseTest.java                 <- Driver lifecycle, capabilities, explicit waits
│       │   │   ├── pages/LoginPage.java               <- Login page object (includes BUG-005 workaround)
│       │   │   ├── pages/DashboardPage.java           <- Home dashboard page object
│       │   │   ├── pages/AttendancePage.java          <- Clock In / Clock Out page object
│       │   │   ├── pages/LeavePage.java               <- Leave application page object
│       │   │   └── utils/ConfigReader.java            <- Properties reader utility
│       │   └── resources/
│       │       └── config.properties                  <- Appium device & test configuration
│       └── test/
│           └── java/com/kredily/automation/tests/
│               ├── LoginTest.java                     <- AUTO-001 (Valid Login) & AUTO-002 (Invalid Login)
│               ├── DashboardTest.java                 <- AUTO-003 (Dashboard validation)
│               ├── AttendanceTest.java                <- AUTO-004 (Clock In journey)
│               └── LeaveTest.java                     <- AUTO-005 (Leave application journey)
│
└── api-testing/                                       <- Backend API Testing
    ├── Kredily_API_Collection.postman_collection.json <- Postman Collection v2.1 (Auth, Attendance, Leave)
    └── Kredily_Environment.postman_environment.json   <- Postman Environment configuration
```

---

## 🧪 Functional Testing (21 Test Cases)

A comprehensive test suite of **21 test cases** was designed and executed manually on the Kredily HRMS Android application, covering happy paths, negative inputs, boundary validations, and module integrations:

| Module | Test Cases | Positive | Negative | Edge / Integration | Execution Status |
| :--- | :---: | :---: | :---: | :---: | :---: |
| **Login & Authentication** | 4 | 1 | 3 | 0 | 100% Pass |
| **Dashboard** | 1 | 1 | 0 | 0 | 100% Pass |
| **Attendance & Clock In/Out** | 5 | 4 | 0 | 1 | 100% Pass |
| **Leave Management** | 6 | 2 | 2 | 2 | 100% Pass |
| **Payroll & Payslips** | 1 | 1 | 0 | 0 | 100% Pass |
| **Holidays** | 1 | 1 | 0 | 0 | 100% Pass |
| **Expense & Admin Synchronization** | 3 | 2 | 1 | 1 | 100% Pass |
| **Total** | **21** | **12** | **6** | **3** | **100% Pass** |

👉 **Read the full test specifications:** [docs/FUNCTIONAL_TEST_CASES.md](docs/FUNCTIONAL_TEST_CASES.md) or open `Kredily_Functional_Test.xlsx`.

---

## 🐛 Bug Reports & Evidence (5 Genuine Bugs)

During test execution, **5 genuine bugs** were discovered, documented, and classified:

| Bug ID | Module | Title | Severity | Priority | Evidence File |
| :--- | :--- | :--- | :---: | :---: | :--- |
| **BUG-001** | Attendance | Mobile clock-in recorded without mobile-app/location data | `Medium` | `High` | [`evidence/Bug1.jpg`](evidence/Bug1.jpg) |
| **BUG-002** | Attendance | Attendance status is inconsistent between Team and Me views | `Medium` | `High` | [`evidence/Bug2(1).jpg`](evidence/Bug2(1).jpg), [`Bug2(2).jpg`](evidence/Bug2(2).jpg), [`Bug2(3).jpg`](evidence/Bug2(3).jpg) |
| **BUG-003** | Approvals | Correction request View opens the wrong attendance date | `Medium` | `High` | [`evidence/Bug3(1).jpg`](evidence/Bug3(1).jpg), [`Bug3(2).jpg`](evidence/Bug3(2).jpg), [`Bug3(3).jpg`](evidence/Bug3(3).jpg) |
| **BUG-004** | Approvals | Approving attendance correction fails and request remains Pending | `High` | `High` | [`evidence/Bug4(1).jpeg`](evidence/Bug4(1).jpeg), [`Bug4(2).jpg`](evidence/Bug4(2).jpg), [`Bug4(3).jpg`](evidence/Bug4(3).jpg) |
| **BUG-005** | Login | Continue button requires two taps after entering email/mobile | `Minor` | `Medium` | [`evidence/Bug5.mp4`](evidence/Bug5.mp4) |

👉 **Read the detailed bug reports:** [docs/BUG_REPORTS.md](docs/BUG_REPORTS.md) or open `Kredily_Bugs.xlsx`.

---

## 📱 Mobile Automation Framework (Appium + TestNG)

An enterprise **Page Object Model (POM)** mobile automation suite was built using Java 17/25, Appium 2.x, and TestNG to automate the 5 required user journeys:

| Test ID | User Journey | Target Flow & Assertions |
| :--- | :--- | :--- |
| **AUTO-001** | Valid Login | Validates employee authentication and verifies Home dashboard lands successfully. |
| **AUTO-002** | Invalid Login | Validates rejection of incorrect password and verifies validation error banner. |
| **AUTO-003** | Dashboard Validation | Validates critical dashboard widgets (Shift, Approvals, Team Today, This Week, Quick Actions). |
| **AUTO-004** | Attendance Check-in | Automates Clock In action, confirms prompt, and validates working session timer. |
| **AUTO-005** | Leave Application | Automates Casual Leave application (15+ days notice) and verifies Pending state under My Requests. |

👉 **Detailed automation setup & code:** See [mobile-automation/README.md](mobile-automation/README.md).

---

## 🌐 API Testing (Postman Collection)

A structured API test collection covering **3 core backend modules** was created for Postman:
1. **Authentication API:**
   - `POST /api/v1/auth/login` (Positive: Valid Login, extracts Bearer token)
   - `POST /api/v1/auth/login` (Negative: Invalid password returns 401 Unauthorized)
   - `POST /api/v1/auth/login` (Negative: Missing email returns 400 Bad Request)
2. **Attendance API:**
   - `POST /api/v1/attendance/punch` (Positive: Mobile Clock-In with GPS data)
   - `POST /api/v1/attendance/punch` (Negative: Missing Auth Token returns 401)
   - `GET /api/v1/attendance/daily-status` (Positive: Fetch daily attendance summary)
   - `POST /api/v1/attendance/regularize/approve` (Negative: Invalid log ID returns 400/404, matching BUG-004)
3. **Leave Management API:**
   - `GET /api/v1/leaves/balances` (Positive: Fetch Casual, Sick, Comp-off balances)
   - `POST /api/v1/leaves/apply` (Positive: Valid leave application)
   - `POST /api/v1/leaves/apply` (Negative: Advance notice violation < 15 days returns 422)
   - `POST /api/v1/leaves/apply` (Negative: Missing mandatory reason returns 400)

### How to Import & Run Postman Collection:
1. Open **Postman**.
2. Click **Import** → select `api-testing/Kredily_API_Collection.postman_collection.json`.
3. Import `api-testing/Kredily_Environment.postman_environment.json`.
4. Select **Kredily HRMS Environment** in the top-right environment selector.
5. Click **Run Collection** to execute all tests automatically.

---

## 🤖 AI-Assisted QA

Generative AI (ChatGPT) was utilized as an advisory **QA Review Assistant** to perform coverage review on manually designed test cases:
- **Prompt Used:** Prompted AI as a Senior QA to review test coverage across workflows, negative paths, boundary validations, and edge cases without fabricating results.
- **AI Output:** Recommended validating boundary conditions on leave advance application, session states, and cross-view attendance consistency.
- **QA Action & Validation:**
  - Explored the 15-day future-dated leave rule (`KRD-FUN-014`).
  - Cross-checked Team vs Me views which directly led to the discovery of **BUG-002**.
  - Validated regularization approvals which led directly to uncovering **BUG-003** and **BUG-004**.
- **Human-in-the-Loop Principle:** 100% of defect logging, test execution, and evidence collection were performed manually by the QA engineer.

👉 **Full prompt and review details:** [docs/AI_ASSISTED_QA.md](docs/AI_ASSISTED_QA.md) or open `Kredily_AI_Assisted.xlsx`.

---

## ⚙️ Setup & Execution Instructions

### Mobile Automation Setup:
1. **Prerequisites:**
   - JDK 17+ (or JDK 25)
   - Apache Maven 3.8+
   - Node.js & Appium 2.x:
     ```bash
     npm install -g appium
     appium driver install uiautomator2
     ```
   - Android SDK with an active emulator or USB debugging device.
2. **Compile the Framework:**
   ```bash
   cd mobile-automation
   mvn clean test-compile
   ```
3. **Execute the Suite:**
   ```bash
   # Start Appium server
   appium

   # Run tests via Maven
   mvn clean test
   ```

---

## 🏁 Final QA Recommendation

### **Quality Gate Status:** ⚠️ **CONDITIONAL PASS**
The Kredily HRMS Android application demonstrates good baseline functionality for daily clock-ins and leave requests. However, **production release is not recommended until the following defects are resolved:**
1. **BUG-004 (High):** Approving attendance regularization fails with *"Attendance log not found"*, blocking timesheet approvals.
2. **BUG-001 (Medium):** Mobile clock-in fails to capture mobile app and GPS coordinates.
3. **BUG-003 (Medium):** Regularization view maps to wrong date displaying *"Day detail unavailable"*.
4. **BUG-002 (Medium):** Discrepancy between Team (Absent) and Me (Pending) views.
5. **BUG-005 (Minor):** Continue button requires double-tap on login screen.

---

**Submitted by:**  
**Monika Shankar**  
Intern QA Engineer Candidate  
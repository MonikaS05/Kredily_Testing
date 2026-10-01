# Kredily HRMS — QA Engineer Assignment

> **Assessment Submission:** Intern QA Engineer  
> **Candidate Name:** Monika Shankar  
> **Target Application:** Kredily HRMS Android APK (v2.0)  
> **APK Link:** [Download Kredily Mobile APK](https://download.aiagent.kredily.com/static/kredily-mobile-v2.apk)  
> **Test Account:** `peoplekredily1@yopmail.com`  
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

This repository contains the end-to-end Quality Assurance deliverables for the **Kredily HRMS Android Application**. The evaluation spans manual exploratory testing, structured functional test cases, defect reporting with multimedia evidence, Appium mobile test automation, backend API testing design, and AI-assisted QA analysis.

### Evaluation Criteria Breakdown
| Evaluation Area | Weight | Coverage in this Repository |
| :--- | :---: | :--- |
| **Manual & Functional Testing** | 25% | **21 Test Cases** executed across Login, OTP, Dashboard, Attendance, Leave, Payroll, Holidays, and Expense |
| **Bug Finding & Reporting** | 20% | **5 Genuine Defects** documented with reproduction steps, severity, and screenshots/videos |
| **Mobile Automation** | 30% | **5 journeys implemented; 3 executed and passing on a real device (realme RMX3491, Android 12)** |
| **API Testing** | 10% | **Postman collection designed for Auth, Attendance and Leave; executed against the base URL (502 Bad Gateway)** |
| **AI Usage** | 10% | AI peer-review documented with prompt, generated review, validated findings, and debugging assistance |
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
│       │   │   ├── pages/LoginPage.java               <- email, Sign in with password, password flow
│       │   │   ├── pages/DashboardPage.java           <- Verified locators for the Home dashboard
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

The mobile automation suite was built using **Java 25 (compiled to release 17)**, **Appium 3.8.0**, and **UiAutomator2 8.7.0** on TestNG, structured under the Page Object Model (POM):

| Test ID | User Journey | Target Flow & Assertions | Status |
| :--- | :--- | :--- | :--- |
| **AUTO-001** | Valid Login | Enter email, tap "Sign in with password", enter password, tap Sign in, then verify Home. | **Passed** |
| **AUTO-002** | Invalid Login | Enter email, tap "Sign in with password", enter wrong password from `config.properties`, verify error feedback. | **Passed** |
| **AUTO-003** | Dashboard Validation | Starts from a logged-in session and checks Shift card, Needs you/Approvals, Team today, This week, Quick actions, and the bottom tabs. | **Passed** |
| **AUTO-004** | Attendance Check-in | Tap Clock In, verify & confirm screen (GPS, geofence, shift window), tap the bottom Clock In button, then Done screen. | **Clock-in works; final "Done" step not yet validated** |
| **AUTO-005** | Leave Application | Submit Casual Leave request (satisfying the 15-day advance rule) and verify Pending state under My Requests. | **Implemented, not yet executed** |

### 🛠️ Challenges and Fixes
During framework implementation and real-device execution on a physical **realme RMX3491 (Android 12)**, several real-world mobile automation challenges were encountered and resolved:
- **React Native UI Architecture:** The app is built with React Native where text elements frequently shift dynamically. Locators were shifted to stable `@resource-id` and accessibility attributes rather than loose text XPaths.
- **realme ADB Permission Policies:** ColorOS/realme UI blocks certain automated permissions by default. This was resolved by enabling *"Disable permission monitoring"* under Developer Options, adding `options.setCapability("appium:ignoreHiddenApiPolicyError", true);`, and utilizing `noReset=true`.
- **Session State Carry-Over:** State from previous journeys carried over between tests. Designed tests so that Dashboard and Attendance start from a known session state without conflicting with login flows.
- **BUG-005 Keyboard Trapping:** Entering credentials occasionally left the soft keyboard open, consuming subsequent taps. Fixed by programmatically calling `driver.hideKeyboard()` and implementing safe retries.
- **Device Connection & Environment:** Handled physical USB connection drops and environment setup by ensuring `ANDROID_HOME` was configured and adb server was managed cleanly.

👉 **Detailed automation setup & code:** See [mobile-automation/README.md](mobile-automation/README.md).

---

## 🌐 API Testing (Postman Collection)

A structured API test collection covering **3 core backend modules** was designed for Postman:
1. **Authentication API:**
   - `POST /api/v1/auth/login` (Positive: Valid Login, extracts Bearer token)
   - `POST /api/v1/auth/login` (Negative: Invalid password returns 401 Unauthorized)
   - `POST /api/v1/auth/login` (Negative: Missing email returns 400 Bad Request)
2. **Attendance API:**
   - `POST /api/v1/attendance/punch` (Positive: Mobile Clock-In with GPS data)
   - `POST /api/v1/attendance/punch` (Negative: Missing Auth Token returns 401)
   - `GET /api/v1/attendance/daily-status` (Positive: Fetch daily attendance summary)
   - `POST /api/v1/attendance/regularize/approve` (Negative: Invalid log ID returns 400/404, intended to mirror the behaviour observed in the app (BUG-004))
3. **Leave Management API:**
   - `GET /api/v1/leaves/balances` (Positive: Fetch Casual, Sick, Comp-off balances)
   - `POST /api/v1/leaves/apply` (Positive: Valid leave application)
   - `POST /api/v1/leaves/apply` (Negative: Advance notice violation < 15 days returns 422)
   - `POST /api/v1/leaves/apply` (Negative: Missing mandatory reason returns 400)

> **⚠️ API Documentation & Execution Note:**  
> Kredily's API is not publicly documented; these endpoints are designed, not confirmed.  
> Executed `AUTH-001` against `https://api.aiagent.kredily.com`; the response was **502 Bad Gateway** with an empty body, so assertions could not be validated.

### How to Import & Run Postman Collection:
1. Open **Postman**.
2. Click **Import** → select `api-testing/Kredily_API_Collection.postman_collection.json`.
3. Import `api-testing/Kredily_Environment.postman_environment.json`.
4. Select **Kredily HRMS Environment** in the top-right environment selector.
5. Click **Run Collection** to inspect the designed request schemas and tests.

---

## 🤖 AI-Assisted QA

Generative AI was utilized in two distinct roles during this assignment:
1. **ChatGPT (QA Review Assistant):**
   - **Prompt Used:** Prompted AI as a Senior QA to review test coverage across workflows, negative paths, boundary validations, and edge cases without fabricating results.
   - **AI Output:** Recommended validating boundary conditions on leave advance application, session states, and cross-view attendance consistency.
   - **QA Action & Validation:**
     - Explored the 15-day future-dated leave rule (`KRD-FUN-014`).
     - Cross-checked Team vs Me views which directly led to the discovery of **BUG-002**.
     - Validated regularization approvals which led directly to uncovering **BUG-003** and **BUG-004**.
2. **Debugging Assistant (Claude):**
   - AI (Claude) was also used as a debugging assistant while setting up and running the Appium framework; I executed all commands on my device and reviewed all changes.
3. **Human-in-the-Loop Principle:** 100% of defect logging, test execution on real hardware, and evidence collection were performed and verified manually by the QA engineer.

👉 **Full prompt and review details:** [docs/AI_ASSISTED_QA.md](docs/AI_ASSISTED_QA.md) or open `Kredily_AI_Assisted.xlsx`.

---

## ⚙️ Setup & Execution Instructions

### Mobile Automation Setup:
1. **Prerequisites & Device Setup:**
   - JDK 17+ (or JDK 25 compiled to release 17)
   - Apache Maven 3.8+
   - Configure `ANDROID_HOME` in environment variables pointing to Android SDK.
   - Node.js & Appium 3.8.0 with UiAutomator2 8.7.0:
     ```bash
     npm install -g appium
     appium driver install uiautomator2
     ```
   - Connect physical device (e.g. realme RMX3491) with **USB debugging enabled** and enable **"Disable permission monitoring"** in Developer Options.
   - Install the Kredily APK and confirm package (`com.kredily.mobile`) and launcher activity (`.MainActivity`).
   - Configure `mobile-automation/src/main/resources/config.properties` with `device.name` and `platform.version`.
   - **Session State Note:** Keep the phone logged in for Dashboard (`AUTO-003`) and Attendance (`AUTO-004`) tests, and logged out for Login tests (`AUTO-001`, `AUTO-002`).

2. **Compile the Framework:**
   ```bash
   cd mobile-automation
   mvn clean test-compile
   ```

3. **Execute the Suite:**
   ```bash
   # Terminal 1: Start Appium server
   appium --use-plugins=relaxed-caps

   # Terminal 2: Run all tests via Maven
   cd mobile-automation
   mvn clean test

   # Or run specific test classes:
   mvn clean test -Dtest=LoginTest
   mvn clean test -Dtest=DashboardTest
   mvn clean test -Dtest=AttendanceTest
   ```

---

## 🏁 Final QA Recommendation

### **Quality Gate Status:** ⚠️ **CONDITIONAL PASS**
The Kredily HRMS Android application demonstrates good baseline functionality for daily clock-ins and leave requests. Automation status: **3 of 5 journeys passing; remaining two pending final-step validation.**

However, **production release is not recommended until the following defects are resolved:**
1. **BUG-004 (High):** Approving attendance regularization fails with *"Attendance log not found"*, blocking timesheet approvals.
2. **BUG-001 (Medium):** Mobile clock-in fails to capture mobile app and GPS coordinates.
3. **BUG-003 (Medium):** Regularization view maps to wrong date displaying *"Day detail unavailable"*.
4. **BUG-002 (Medium):** Discrepancy between Team (Absent) and Me (Pending) views.
5. **BUG-005 (Minor):** Continue button requires double-tap on login screen.

---

**Submitted by:**  
**Monika Shankar**  
Intern QA Engineer Candidate  
# Kredily HRMS — Mobile Automation Framework

This module contains the enterprise-grade **Mobile Test Automation Suite** for the Kredily HRMS Android APK (`com.kredily.mobile`), implemented using **Java**, **Appium 2.x**, **UiAutomator2**, and **TestNG** following the **Page Object Model (POM)** architectural pattern.

---

## 1. Automated User Journeys

The framework automates the 5 high-priority business journeys specified in the assignment:

| Test ID | User Journey | Objective & Scope | Assertion Highlights |
| :--- | :--- | :--- | :--- |
| **AUTO-001** | Valid Login | Authenticate with valid employee credentials and navigate to Home. | `Assert.assertTrue(dashboardPage.isHomeDashboardLoaded())` |
| **AUTO-002** | Invalid Login | Verify incorrect password rejection without locking the account. | `Assert.assertTrue(loginPage.isErrorMessageDisplayed())` |
| **AUTO-003** | Dashboard Validation | Validate critical dashboard widgets (Shift, Approvals, Team Today, This Week, Quick Actions). | Assert all sections are visible on the Home view. |
| **AUTO-004** | Attendance / Check-In | Complete Clock In workflow, accept permissions, and verify session timer. | `Assert.assertTrue(attendancePage.isClockedIn())` |
| **AUTO-005** | Leave Application | Submit a Casual Leave request and verify it appears as `Pending` under *My Requests*. | `Assert.assertTrue(leavePage.isPendingRequestVisible())` |

---

## 2. Framework Architecture & Design Pattern

The suite follows the **Page Object Model (POM)** to ensure maintainability, reusability, and clean separation of locators from test logic:

```
mobile-automation/
├── pom.xml                                      <- Maven project dependencies
├── testng.xml                                   <- TestNG execution suite runner
├── src/main/
│   ├── java/com/kredily/automation/
│   │   ├── base/
│   │   │   └── BaseTest.java                    <- Driver lifecycle, capabilities, explicit waits
│   │   ├── pages/
│   │   │   ├── LoginPage.java                   <- Login screen actions & BUG-005 retry handling
│   │   │   ├── DashboardPage.java               <- Home dashboard elements & navigation
│   │   │   ├── AttendancePage.java              <- Clock in/out actions & timer validation
│   │   │   └── LeavePage.java                   <- Leave form, balance & request validation
│   │   └── utils/
│   │       └── ConfigReader.java                <- Configuration properties reader
│   └── resources/
│       └── config.properties                    <- Dynamic execution settings & credentials
└── src/test/
    └── java/com/kredily/automation/tests/
        ├── LoginTest.java                       <- Tests AUTO-001 and AUTO-002
        ├── DashboardTest.java                   <- Test AUTO-003
        ├── AttendanceTest.java                  <- Test AUTO-004
        └── LeaveTest.java                       <- Test AUTO-005
```

---

## 3. Prerequisites & Environment Setup

1. **Java Development Kit (JDK):** Version 17 or higher (tested with JDK 25 LTS).
2. **Apache Maven:** Version 3.8 or higher.
3. **Node.js & Appium 2.x:**
   ```bash
   npm install -g appium
   appium driver install uiautomator2
   ```
4. **Android SDK:** Configured with `ANDROID_HOME` and `platform-tools` in system `PATH`.
5. **Kredily Android APK:**
   - Download link: `https://download.aiagent.kredily.com/static/kredily-mobile-v2.apk`
   - Test Account: `peoplekredily1@yopmail.com` / `Pass@9865`

---

## 4. Configuration

Edit `src/main/resources/config.properties` or pass JVM arguments to configure the target device:

```properties
appium.server.url=http://127.0.0.1:4723/
device.name=Android Emulator
platform.name=Android
platform.version=13.0
automation.name=UiAutomator2
app.package=com.kredily.mobile
app.activity=com.kredily.mobile.MainActivity
auto.grant.permissions=true

# Test Account
test.user.email=peoplekredily1@yopmail.com
test.user.password=Pass@9865
```

---

## 5. Execution Instructions

### A. Start Appium Server
```bash
appium --use-plugins=relaxed-caps
```

### B. Launch an Android Device or Emulator
```bash
# Verify connected device
adb devices
```

### C. Run All Automation Tests via Maven
```bash
cd mobile-automation
mvn clean test
```

### D. Run Specific Test Class
```bash
mvn test -Dtest=LoginTest
```

---

## 6. Resilience & Defect Workaround Handling

During manual test exploration, **BUG-005** (*Continue button requires two taps after entering email*) was discovered. To ensure the automated test suite remains resilient and does not fail intermittently due to this application defect, `LoginPage.java` incorporates an intelligent retry mechanism that checks whether the password field has appeared; if the keyboard dismiss consumed the first tap, a second tap is dispatched automatically.

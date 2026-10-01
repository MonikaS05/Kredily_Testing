# Kredily HRMS — Mobile Automation Framework

This module contains the **Mobile Test Automation Suite** for the Kredily HRMS Android APK (`com.kredily.mobile`), implemented using **Java 25 (compiled to release 17)**, **Appium 3.8.0**, **UiAutomator2 8.7.0**, and **TestNG** following the **Page Object Model (POM)** architectural pattern.

---

## 1. Automated User Journeys & Execution Status

| Test ID | User Journey | Target Flow & Assertions | Status on Real Device (realme RMX3491) |
| :--- | :--- | :--- | :--- |
| **AUTO-001** | Valid Login | Enter email, tap "Sign in with password", enter password, tap Sign in, verify Home. | **Passed** |
| **AUTO-002** | Invalid Login | Enter email, tap "Sign in with password", enter wrong password from `config.properties`, verify error feedback. | **Passed** |
| **AUTO-003** | Dashboard Validation | Starts from a logged-in session; validates Shift card, Needs you/Approvals, Team today, This week, Quick actions, and bottom tabs. | **Passed** |
| **AUTO-004** | Attendance Check-In | Tap Clock In, Verify & confirm screen (GPS, geofence, shift window), tap bottom Clock In, then Done screen. | **Clock-in works; final "Done" step not yet validated** |
| **AUTO-005** | Leave Application | Submit Casual Leave request (satisfying 15-day advance rule) and verify Pending under My Requests. | **Implemented, not yet executed** |

---

## 2. Framework Architecture & Design Pattern

The suite follows the **Page Object Model (POM)** to ensure maintainability, reusability, and clean separation of locators from test logic:

```
mobile-automation/
├── pom.xml                                      <- Maven project dependencies (release 17)
├── testng.xml                                   <- TestNG execution suite runner
├── src/main/
│   ├── java/com/kredily/automation/
│   │   ├── base/
│   │   │   └── BaseTest.java                    <- Driver lifecycle, capabilities, explicit waits, adb permissions
│   │   ├── pages/
│   │   │   ├── LoginPage.java                   <- Email, Sign in with password, password flow, hideKeyboard
│   │   │   ├── DashboardPage.java               <- Verified locators for Home dashboard widgets
│   │   │   ├── AttendancePage.java              <- Clock in/out actions & status validation
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

## 3. Real-Device Challenges & Solutions
- **React Native Framework:** Element texts can shift; used stable `@resource-id` and accessibility properties.
- **ColorOS / realme ADB Restrictions:** Enabled "Disable permission monitoring" in Developer Options and configured `appium:ignoreHiddenApiPolicyError` and `noReset=true`.
- **Keyboard Handling:** Dismissed soft keyboard before clicking action buttons (`driver.hideKeyboard()`).
- **Session State Isolation:** Maintained separate flows for logged-out authentication checks versus active dashboard/clock-in checks.

---

## 4. Prerequisites & Environment Setup

1. **Java Development Kit (JDK):** Version 17+ (or JDK 25 compiled with release 17).
2. **Apache Maven:** Version 3.8 or higher.
3. **Android SDK:** Configured with `ANDROID_HOME` pointing to SDK directory.
4. **Node.js & Appium 3.8.0:**
   ```bash
   npm install -g appium
   appium driver install uiautomator2
   ```
5. **Physical Device Setup:**
   - Enable USB Debugging.
   - For realme/Oppo: enable "Disable permission monitoring".

---

## 5. Execution Instructions

### A. Start Appium Server
```bash
appium --use-plugins=relaxed-caps
```

### B. Verify Device Connection
```bash
adb devices
```

### C. Run All Automation Tests via Maven
```bash
cd mobile-automation
mvn clean test
```

### D. Run Specific Test Class
```bash
# Run Login Tests (Ensure app is logged out before running)
mvn clean test -Dtest=LoginTest

# Run Dashboard Test (Ensure app is logged in before running)
mvn clean test -Dtest=DashboardTest

# Run Attendance Test (Ensure app is logged in before running)
mvn clean test -Dtest=AttendanceTest
```
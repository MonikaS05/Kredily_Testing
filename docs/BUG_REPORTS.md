# Kredily HRMS — Bug Reports

**Application Under Test:** Kredily HRMS Android Mobile Application (v2.0)  
**Tester:** Monika Shankar  
**Total Defects Identified:** 5 Genuine Bugs  
**Testing Methodology:** Manual Exploratory & Functional Test Execution on Android Device / Emulator  

---

## Defect Summary Dashboard

| Bug ID | Module | Title | Severity | Priority | Defect Type | Evidence Files |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **BUG-001** | Attendance | Mobile clock-in recorded without mobile-app/location data | `Medium` | `High` | Functional / Data Integrity | `evidence/Bug1.jpg` |
| **BUG-002** | Attendance | Attendance status is inconsistent between Team and Me views | `Medium` | `High` | Functional / Data Consistency | `evidence/Bug2(1).jpg`, `Bug2(2).jpg`, `Bug2(3).jpg` |
| **BUG-003** | Attendance → Approvals | Correction request View opens the wrong attendance date | `Medium` | `High` | Functional / Navigation / Data Mapping | `evidence/Bug3(1).jpg`, `Bug3(2).jpg`, `Bug3(3).jpg` |
| **BUG-004** | Attendance → Approvals | Approving attendance correction fails and request remains Pending | `High` | `High` | Functional / Workflow Failure | `evidence/Bug4(1).jpeg`, `Bug4(2).jpg`, `Bug4(3).jpg` |
| **BUG-005** | Login / Authentication | Continue button requires two taps after entering email/mobile | `Minor` | `Medium` | UI Interaction / Event Handling | `evidence/Bug5.mp4` |

---

## Detailed Defect Reports

### BUG-001: Mobile clock-in recorded without mobile-app/location data
- **Bug ID:** `BUG-001`
- **Module:** Attendance
- **Severity:** `Medium`
- **Priority:** `High`
- **Status:** `New`
- **Defect Type:** Functional / Data Integrity
- **Preconditions:** User is logged into the Kredily mobile application; Attendance/Clock In is available; location permission is granted on the mobile device.

#### Steps to Reproduce:
1. Open Kredily mobile application.
2. Log in with a valid employee account (`peoplekredily1@yopmail.com`).
3. Tap **Clock In**.
4. Grant location permission when prompted.
5. Complete the clock-in process.
6. Open the corresponding attendance record / details.
7. Inspect Mobile App, Location, Coordinates, GPS Accuracy, and Selfie information.

#### Expected Result:
Because the clock-in punch was performed through the mobile application with location permissions enabled, the attendance record should accurately reflect the mobile-app source, physical location, latitude/longitude coordinates, and GPS accuracy.

#### Actual Result:
The attendance record displayed:
- **Mobile App:** *"Did not punch from Mobile App"*
- **Place:** *Not captured*
- **Coordinates:** *Not captured*
- **GPS Accuracy:** *Not captured*
- **Selfie:** *Not captured*  
*(Network IP and device details were captured successfully).*

#### Business Impact:
Attendance records contain incomplete and contradictory source/location data. HR and operations cannot verify whether employee clock-ins occurred at approved office locations or client sites.

#### Evidence:
- Evidence file: [`evidence/Bug1.jpg`](../evidence/Bug1.jpg)

---

### BUG-002: Attendance status is inconsistent between Team and Me views
- **Bug ID:** `BUG-002`
- **Module:** Attendance
- **Severity:** `Medium`
- **Priority:** `High`
- **Status:** `New`
- **Defect Type:** Functional / Data Consistency
- **Preconditions:** User is logged in; attendance records / correction requests exist for affected September dates.

#### Steps to Reproduce:
1. Open Attendance module.
2. Navigate to the **Team** tab view.
3. Check attendance status for the affected September dates (e.g., 22nd–24th September).
4. Observe that the affected dates are marked as **Absent**.
5. Switch to the **Me** tab view.
6. Inspect the same dates.
7. Compare individual date status with the Team view and monthly summary count.

#### Expected Result:
The same attendance record must display consistent status across both Team and Me views. If an attendance correction request is pending, both views should consistently reflect the pending regularization state rather than marking the employee as definitively Absent.

#### Actual Result:
- **Team View:** Displayed affected dates as `Absent / No punches recorded`.
- **Me View:** Displayed `Correction-requested / Pending` states for the exact same dates.
- **Me Summary Header:** Still computed and displayed `2 Absent`.

#### Business Impact:
Employees and team leads receive conflicting information regarding attendance status, leading to unnecessary confusion and disputes over attendance regularizations.

#### Evidence:
- Team View screenshot: [`evidence/Bug2(1).jpg`](../evidence/Bug2(1).jpg)
- Me View screenshot: [`evidence/Bug2(2).jpg`](../evidence/Bug2(2).jpg)
- Monthly Summary screenshot: [`evidence/Bug2(3).jpg`](../evidence/Bug2(3).jpg)

---

### BUG-003: Correction request View opens the wrong attendance date
- **Bug ID:** `BUG-003`
- **Module:** Attendance → Approvals / Regularization
- **Severity:** `Medium`
- **Priority:** `High`
- **Status:** `New`
- **Defect Type:** Functional / Navigation / Data Mapping
- **Preconditions:** Attendance correction/regularization requests are available under `Approvals → Reg`.

#### Steps to Reproduce:
1. Open Kredily application.
2. Navigate to **Attendance**.
3. Open **Approvals**.
4. Select the **Reg** (Regularization) tab.
5. Locate a pending correction request (e.g., request for 22 September).
6. Tap **View**.
7. Observe the attendance date and log details displayed.
8. Repeat the action for subsequent pending requests (e.g., 23 or 24 September).

#### Expected Result:
Tapping **View** for an attendance correction request should open the attendance detail sheet for the exact date associated with that request.

#### Actual Result:
The View action opened an unrelated date log and showed *"Day detail unavailable"*. This defect was reproduced across multiple correction requests.

#### Business Impact:
Approvers and HR managers are unable to review the actual day's punch logs or context before deciding to approve or reject a regularization request.

#### Evidence:
- Requests list screenshot: [`evidence/Bug3(1).jpg`](../evidence/Bug3(1).jpg)
- Mapped date view screenshot: [`evidence/Bug3(2).jpg`](../evidence/Bug3(2).jpg)
- Error detail screenshot: [`evidence/Bug3(3).jpg`](../evidence/Bug3(3).jpg)

---

### BUG-004: Approving attendance correction fails and request remains Pending
- **Bug ID:** `BUG-004`
- **Module:** Attendance → Approvals / Regularization
- **Severity:** `High`
- **Priority:** `High`
- **Status:** `New`
- **Defect Type:** Functional / Workflow Failure
- **Preconditions:** A pending attendance correction request is available under `Approvals → Reg`.

#### Steps to Reproduce:
1. Open Kredily application.
2. Navigate to **Attendance → Approvals → Reg**.
3. Locate a pending attendance correction request.
4. Tap the **Approve** button.
5. Observe the application response and notification banner.
6. Refresh and verify request status in the list.

#### Expected Result:
The correction request should be approved successfully, transition to `Approved` status, and update the employee's attendance record in the database.

#### Actual Result:
After tapping Approve, the application displayed an error banner *"Attendance log not found"*, and the request remained in `Pending` state. The approval transaction failed to complete.

#### Business Impact:
**High-severity functional blocker:** Approvers cannot complete attendance regularizations, blocking monthly timesheet sign-offs and payroll processing.

#### Evidence:
- Pending request screenshot: [`evidence/Bug4(1).jpeg`](../evidence/Bug4(1).jpeg)
- Error banner screenshot: [`evidence/Bug4(2).jpg`](../evidence/Bug4(2).jpg)
- Still pending screenshot: [`evidence/Bug4(3).jpg`](../evidence/Bug4(3).jpg)

---

### BUG-005: Continue button requires two taps after entering email/mobile
- **Bug ID:** `BUG-005`
- **Module:** Login / Authentication
- **Severity:** `Minor`
- **Priority:** `Medium`
- **Status:** `New`
- **Defect Type:** Functional / UI Interaction / Event Handling
- **Preconditions:** Kredily login screen is displayed.

#### Steps to Reproduce:
1. Launch Kredily mobile application.
2. Enter registered email/mobile (`peoplekredily1@yopmail.com`).
3. Tap the **Continue** button once.
4. Observe UI response.
5. Tap the **Continue** button a second time.

#### Expected Result:
Tapping **Continue** once should validate input, dismiss the soft keyboard, and transition smoothly to the password entry screen.

#### Actual Result:
The first tap only dismissed the keyboard or lost focus on the text field without triggering navigation. A second tap was required to proceed.

#### Business Impact:
Creates user friction at the initial entry point of the app, giving users an impression of sluggishness or non-responsive buttons.

#### Evidence:
- Video recording: [`evidence/Bug5.mp4`](../evidence/Bug5.mp4)

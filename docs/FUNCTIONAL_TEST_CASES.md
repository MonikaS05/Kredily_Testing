# Kredily HRMS — Functional Test Cases

**Application Under Test:** Kredily HRMS Android Mobile APK (v2.0)

**Tester Name:** Monika Shankar

**Total Test Cases:** 21 (Covering Positive, Negative, and Edge Cases)

**Execution Status:** 21 / 21 PASS (Functional workflows executed on test account)

---

## Test Execution Summary

| Module | Total Cases | Positive | Negative | Edge / Integration | Execution Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Login & Authentication | 4 | 1 | 3 | 0 | 100% Pass |
| Dashboard | 1 | 1 | 0 | 0 | 100% Pass |
| Attendance & Clock In/Out | 5 | 4 | 0 | 1 | 100% Pass |
| Leave Management | 6 | 2 | 2 | 2 | 100% Pass |
| Payroll | 1 | 1 | 0 | 0 | 100% Pass |
| Holidays | 1 | 1 | 0 | 0 | 100% Pass |
| Expense Management / Admin | 3 | 2 | 1 | 1 | 100% Pass |
| **Total** | **21** | **12** | **6** | **3** | **100% Pass** |

---

## Detailed Test Cases

### KRD-FUN-001: Login with valid credentials

- **Module:** Login
- **Test Type:** Positive
- **Preconditions:** Kredily app installed; valid employee account available
- **Test Data:** Email: peoplekredily1@yopmail.com; Password: Pass@9865
- **Test Steps:**

  1. Open Kredily app.<br>2. Enter the registered email in Email/Mobile field.<br>3. Tap Continue.<br>4. Enter the valid password.<br>5. Tap Sign in.

- **Expected Result:** User should be authenticated and redirected to Home/Dashboard.
- **Actual Result:** Login completed successfully and Home screen was displayed.
- **Status:** **PASS**

---

### KRD-FUN-002: Login with incorrect password

- **Module:** Login
- **Test Type:** Negative
- **Preconditions:** Registered employee account available
- **Test Data:** Email: peoplekredily1@yopmail.com; Password: Wrong@123
- **Test Steps:**

  1. Open login screen.<br>2. Enter registered email.<br>3. Tap Continue.<br>4. Enter incorrect password.<br>5. Tap Sign in.

- **Expected Result:** Invalid password should be rejected with an appropriate error.
- **Actual Result:** App displayed “Incorrect password. 4 attempts remaining.” and did not log in.
- **Status:** **PASS**

---

### KRD-FUN-003: Validate mandatory Email/Mobile field

- **Module:** Login
- **Test Type:** Negative
- **Preconditions:** Login screen displayed
- **Test Data:** Email/Mobile: blank
- **Test Steps:**

  1. Open login screen.<br>2. Leave Email/Mobile field empty.<br>3. Tap Sign in with password.

- **Expected Result:** Mandatory-field validation should be displayed.
- **Actual Result:** App displayed “Enter your email or mobile number” and remained on login screen.
- **Status:** **PASS**

---

### KRD-FUN-004: Login using an unregistered mobile number

- **Module:** Login / OTP
- **Test Type:** Negative
- **Preconditions:** Login screen displayed; mobile number not registered/activated
- **Test Data:** Unregistered mobile number; received OTP
- **Test Steps:**

  1. Enter an unregistered mobile number.<br>2. Continue with OTP login.<br>3. Enter the received OTP.

- **Expected Result:** System should prevent login and display an account verification error message.
- **Actual Result:** OTP was received, but app displayed “Your account is not yet verified.” and instructed activation through the Kredily Activation Link.
- **Status:** **PASS**

---

### KRD-FUN-005: Verify Dashboard after successful login

- **Module:** Dashboard
- **Test Type:** Positive
- **Preconditions:** Successful login completed
- **Test Data:** Valid employee account
- **Test Steps:**

  1. Login with valid credentials.<br>2. Observe the Home screen.<br>3. Shift, approvals, team and weekly attendance sections should be display.

- **Expected Result:** Dashboard should load employee information and available actions.
- **Actual Result:** Home dashboard loaded with QA Assessment, shift information, approvals, Team Today, This Week and Quick Actions.
- **Status:** **PASS**

---

### KRD-FUN-006: Clock in

- **Module:** Attendance
- **Test Type:** Positive
- **Preconditions:** Logged-in employee; Attendance available
- **Test Data:** Current attendance session
- **Test Steps:**

  1. From Home, locate Clock In.<br>2. Tap Clock In.<br>3. Wait for confirmation screen.<br>4. Tap Done.

- **Expected Result:** Employee should be clocked in and working timer should start.
- **Actual Result:** App displayed “Clocked in — have a great day, QA!” and Home showed Clocked in with timer.
- **Status:** **PASS**

---

### KRD-FUN-007: Clock out

- **Module:** Attendance
- **Test Type:** Positive
- **Preconditions:** Employee is clocked in and Clock Out is available
- **Test Data:** Current attendance session
- **Test Steps:**

  1. From Home, wait until Clock Out is available.<br>2. Tap Clock Out.<br>3. Wait for confirmation.<br>4. Tap Done.

- **Expected Result:** Employee should be clocked out and attendance should be recorded.
- **Actual Result:** App displayed “Clocked out — see you tomorrow, QA!” and Home showed Clocked out / Day recorded.
- **Status:** **PASS**

---

### KRD-FUN-008: Clock in again after clocking out

- **Module:** Attendance
- **Test Type:** Positive / Edge
- **Preconditions:** Employee has clocked out; Clock In becomes available
- **Test Data:** Current attendance session
- **Test Steps:**

  1. Return to Home after clock-out.<br>2. Wait until Clock In becomes available.<br>3. Tap Clock In.<br>4. Observe confirmation.

- **Expected Result:** Employee should be able to clock in again when returning to work.
- **Actual Result:** App successfully displayed Clocked in and started a new timer.
- **Status:** **PASS**

---

### KRD-FUN-009: View organisation attendance

- **Module:** Attendance
- **Test Type:** Positive
- **Preconditions:** Logged-in employee
- **Test Data:** Date: Sat 26 Sep 2026
- **Test Steps:**

  1. Tap Attendance from bottom navigation.<br>2. Observe Team tab.<br>3. Select Sat 26.<br>4. Observe employee attendance entry.

- **Expected Result:** Organisation/team attendance should be displayed for the selected date.
- **Actual Result:** Org attendance displayed Team attendance, including QA Assessment with Present status and clock-in time.
- **Status:** **PASS**

---

### KRD-FUN-010: View personal monthly attendance

- **Module:** Attendance
- **Test Type:** Positive
- **Preconditions:** Logged-in employee
- **Test Data:** Month: September 2026
- **Test Steps:**

  1. Tap Attendance.<br>2. Switch from Team to Me.<br>3. Observe September 2026 calendar.<br>4. Check attendance summary and selected date.

- **Expected Result:** Personal attendance calendar and summary should load.
- **Actual Result:** September 2026 attendance calendar loaded with Present/Late/Absent/Requested indicators and working information.
- **Status:** **PASS**

---

### KRD-FUN-011: View leave balances

- **Module:** Leave
- **Test Type:** Positive
- **Preconditions:** Logged-in employee
- **Test Data:** Leave balances
- **Test Steps:**

  1. Open All actions.<br>2. Tap Leave.<br>3. Observe Balances tab.<br>4. Check leave types and available balances.

- **Expected Result:** Available leave balances should be displayed.
- **Actual Result:** Leave screen displayed Casual, Comp Off, Sick, Earned and Loss of Pay balances.
- **Status:** **PASS**

---

### KRD-FUN-012: Apply leave with valid information

- **Module:** Leave
- **Test Type:** Positive
- **Preconditions:** Logged-in employee with available leave balance
- **Test Data:** Leave: Casual; Reason: Personal work; Future date within allowed range
- **Test Steps:**

  1. Open Leave.<br>2. Tap + Apply.<br>3. Select Casual Leave.<br>4. Enter valid future date.<br>5. Enter reason Personal work.<br>6. Tap Submit request.<br>7. Open My requests.

- **Expected Result:** Valid leave request should be submitted and appear in request history.
- **Actual Result:** Leave request appeared under My requests with Pending status and reason Personal work.
- **Status:** **PASS**

---

### KRD-FUN-013: Submit leave without reason

- **Module:** Leave
- **Test Type:** Negative
- **Preconditions:** Leave application form open
- **Test Data:** Reason: blank
- **Test Steps:**

  1. Open Leave → + Apply.<br>2. Select Casual Leave.<br>3. Keep Reason empty.<br>4. Tap Submit request.

- **Expected Result:** Mandatory reason validation should be displayed.
- **Actual Result:** App displayed “Add a reason” and did not submit the request.
- **Status:** **PASS**

---

### KRD-FUN-014: Apply future-dated leave within restricted period

- **Module:** Leave
- **Test Type:** Negative / Edge
- **Preconditions:** Leave application form open
- **Test Data:** Future date less than 15 days in advance
- **Test Steps:**

  1. Open Leave → + Apply.<br>2. Select Casual Leave.<br>3. Select a date less than 15 days in advance.<br>4. Enter reason.<br>5. Observe validation.

- **Expected Result:** Application should prevent submission according to the configured advance-leave rule.
- **Actual Result:** App displayed “Future-dated leave must be applied at least 15 day(s) in advance.”
- **Status:** **PASS**

---

### KRD-FUN-015: Apply leave exceeding available balance

- **Module:** Leave
- **Test Type:** Negative / Edge
- **Preconditions:** Leave application form open; available Casual Leave balance is 12.5 days
- **Test Data:** Requested range: 12/10/2026 to 26/10/2026; Reason: Personal work
- **Test Steps:**

  1. Open Leave → + Apply.<br>2. Select Casual Leave.<br>3. Select a date range exceeding available balance.<br>4. Enter reason Personal work.<br>5. Observe validation.

- **Expected Result:** Application should prevent requesting more leave than available balance.
- **Actual Result:** App displayed “Only 12.5 day(s) available” and prevented the excessive request.
- **Status:** **PASS**

---

### KRD-FUN-016: Verify submitted leave in My Requests

- **Module:** Leave
- **Test Type:** Positive
- **Preconditions:** A leave request has been submitted
- **Test Data:** Casual Leave; 1 day; Personal work
- **Test Steps:**

  1. Open Leave.<br>2. Tap My requests.<br>3. Observe the submitted Casual Leave request.

- **Expected Result:** Submitted request should be listed with date, duration, reason and status.
- **Actual Result:** Request was displayed with Casual Leave, 1 day, Personal work, and Pending status.
- **Status:** **PASS**

---

### KRD-FUN-017: View Payslips

- **Module:** Payroll
- **Test Type:** Positive / Environment
- **Preconditions:** Logged-in employee
- **Test Data:** Payslip module
- **Test Steps:**

  1. Open All actions.<br>2. Tap Payslips.<br>3. Observe the screen.

- **Expected Result:** Available payslips should be displayed when payroll data exists.
- **Actual Result:** App displayed “No payslips yet” and stated that salary slips appear once payroll runs.
- **Status:** **Pass**

---

### KRD-FUN-018: View holiday calendar

- **Module:** Holidays
- **Test Type:** Positive
- **Preconditions:** Logged-in employee
- **Test Data:** Month: September 2026
- **Test Steps:**

  1. Open All actions.<br>2. Tap Holidays.<br>3. Observe Calendar tab.<br>4. Check September 2026.

- **Expected Result:** Holiday calendar should load and display configured holidays.
- **Actual Result:** Calendar loaded successfully and displayed “No holidays this month.”
- **Status:** **PASS**
- **Remarks:** No holidays configured for selected month.

---

### KRD-FUN-019: Submit expense without mandatory category

- **Module:** Expense
- **Test Type:** Negative
- **Preconditions:** Logged-in employee; Expense module accessible
- **Test Data:** Amount: 0.00; Notes: blank; no category selected
- **Test Steps:**

  1. Open All actions.<br>2. Tap Expense.<br>3. Tap + New claim.<br>4. Leave Amount as 0.00.<br>5. Leave Notes empty.<br>6. Tap Submit claim.

- **Expected Result:** Application should prevent submission and show mandatory-field validation.
- **Actual Result:** App displayed “Pick an expense category” and did not submit the claim.
- **Status:** **PASS**

---

### KRD-FUN-020: Add new expense category 'Travel' from Admin options

- **Module:** Expense / Admin
- **Test Type:** Positive
- **Preconditions:** User is logged in with Admin access rights; Expense module active
- **Test Data:** Category Name: Travel
- **Test Steps:**

  1. Navigate to Expense module.<br>2. Tap on Admin option/settings.<br>3. Select Add Category.<br>4. Enter Travel in the category name field.<br>5. Tap Save / Submit.<br>6. Open + New Claim form in Expense.

- **Expected Result:** Category 'Travel' should be created successfully in Admin settings and immediately appear in the Category dropdown for new expense claims.
- **Actual Result:** Category 'Travel' was added successfully and displayed as an available option in the expense claim dropdown.
- **Status:** **PASS**

---

### KRD-FUN-021: Verify dynamic synchronization of Admin-created 'Travel' expense category to user claim options

- **Module:** Expense / Admin
- **Test Type:** Positive / Integration
- **Preconditions:** User logged in with Admin rights; Expense module configured and operational
- **Test Data:** Category Name: Travel
- **Test Steps:**

  1. Navigate to Expense module.<br>2. Tap on Admin options/settings.<br>3. Select Add Category and enter Travel.<br>4. Save the category.<br>5. Return to Expense home and tap + New Claim.<br>6. Open and see the categories.

- **Expected Result:** Newly added category 'Travel' should be successfully created in Admin settings and instantly appear as an option in the employee expense claim.
- **Actual Result:** Category 'Travel' was created in Admin and successfully populated in the + New Claim dropdown list.
- **Status:** **PASS**

---


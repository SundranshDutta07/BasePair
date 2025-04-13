Feature: Basepair User and Sample Management

  # 1. User Authentication (Login, Signup, Signout, Forgot Password)
  
  Scenario: Successful Login
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the "Login" button
    Then the user should be redirected to the homepage
    And the user should see "Interview's Project Dashboard" heading

  Scenario: Unsuccessful Login with Invalid Credentials
    Given the user is on the login page
    When the user enters invalid credentials
    And clicks the "Login" button
    Then the user should see an error message "Invalid username or password"

  Scenario: Successful Signup
    Given the user is on the login page
    When the user clicks on "Sign In" button
    And fills in all required fields with valid data
    And clicks the "START FREE TRAIL" button
    Then the user should be redirected to the login page
    And the user should see "Signup Successful" message

  Scenario: Unsuccessful Signup with Missing Fields
    Given the user is on the signup page
    When the user fills in the required fields with missing information
    And clicks the "Sign Up" button
    Then the user should see an error message "Please enter your full name./The input is not valid E-mail./Please enter your password."

 Scenario: Unsuccessful Signup with already used Email
    Given the user is on the signup page
    When the user fills in the required fields with already used email
    And clicks the "Sign Up" button
    Then the user should see an error message "This email address is already in use. If you forgot your password, please reset your password."

  Scenario: Successful Signout
    Given the user is logged in
    When the user clicks the "Sign Out" button
    Then the user should be logged out
    And the user should be redirected to the login page

  Scenario: Forgot Password Flow
    Given the user is on the forgot password page
    When the user enters a valid email address
    And clicks the "Send" button
    Then the user should see a message "Please check your e-mail inbox."
  
  Scenario: Forgot Password with Invalid Email
    Given the user is on the forgot password page
    When the user enters an invalid email address
    And clicks the "Send" button
    Then the user should see an error message "User with id 'Entered email id' not found.."

  # 2. Sample Management (Upload, Delete, Cancel, etc.)
  
  Scenario: Upload Sample Successfully
    Given the user is on the sample upload page
    When the user selects a valid sample file
    And fills in all required fields (tags, platform, genome, datatype, etc.)
    And clicks the "Upload samples" button
    Then the user should see upload bar with %
    And sample should be uploaded successfully
    And user should be navigated to samples page with a success message "Sample added successfully"
  
  Scenario: Upload Sample with Invalid File Format
    Given the user is on the sample upload page
    When the user selects an invalid file format (e.g., `.csv`)
    Then the user should not be able to see any unsupported files for selection

  Scenario: Upload Sample with Invalid File Format-Drag & Drop
    Given the user is on the sample upload page
    When the user selects an invalid file format (e.g., .pdf)
    And drag drop the file
    Then the system should not initiate the upload  
    And no feedback or error message is displayed to the user  

  Scenario: Upload Sample with Missing Fields
    Given the user is on the sample upload page
    When the user leaves a required field empty
    And clicks the "Upload samples" button
    Then the user should see an error message "This field may not be blank."

  Scenario: Upload Sample with Missing Fields-Sample Name
    Given the user is on the sample upload page
    When the user leaves a required field empty
    And clicks the "Upload samples" button
    Then the user should see an error message " The name of the sample is required."

  Scenario: Copy a Sample from Samples form
    Given the user is on the Samples page
    When the user selects a sample
    And the user clicks on the "Copy" button
    Then a new sample with the same details should appear in the sample form
    And the name should have a suffix like "Copy-of"

 Scenario: Delete a Sample from Samples form
    Given the user is logged in and on the Samples page
    When the user clicks on the "Delete" button for a sample
    Then the sample should be removed from the list
 
  Scenario: Cancel Upload During Upload Process
    Given the user has started uploading a sample
    When the user clicks the "Cancel" button
    Then the upload should be canceled
    And the user should be redirected to the samples page
    And the sample should show svg as "Upload not completed"

  Scenario: Reset Form
    Given the user is on the sample upload page
    When the user fills in all required field
    And clicks the "Reset form" button
    Then the form should be cleared
    And the user should see a New Sample screen with no sample selected
  
  Scenario: Close Form
    Given the user is on the sample upload page
    When the user clicks the "Close" button
    Then the sample form should be closed

  # 3. Project Management
  
  Scenario: Create a New Project
    Given the user is on the Dashboard page
    When the user Click on Create New Project
    And enters a project name
    And clicks the "Save" button
    Then the user should see the message "Project saved successfully."
    And created project in the project list

  Scenario: Create a New Project with Duplicate Name
    Given the user is on the create project page
    When the user enters a project name that already exists
    And clicks the "Save" button
    Then the user should see an error message "Project name already exists"

  Scenario: User edits their own project successfully
    Given the user has logged into the system
    And the user has an existing project named "MyProject"
    When the user clicks on "MyProject" from the Projects dashboard
    Then the active project should change to "MyProject"
    When the user clicks the "Edit" button
    And updates the project name
    And clicks the "Save" button
    Then the message "Project saved successfully" should appear
    And the user should be navigated back to the Projects page

  Scenario: User deletes their own project successfully
    Given the user has logged into the system
    And the user has an existing project named "MyProject"
    When the user clicks on "MyProject" from the Projects dashboard
    Then the active project should change to "MyProject"
    When the user clicks the "Delete" button
    And confirms the deletion on the popup
    Then the message "Project deleted successfully" should appear
    And the project should be removed from the Projects dashboard
  
  Scenario: Upload Sample to Restricted Project(Already created projects)
    Given the user is on the sample upload page
    When the user selects a restricted project for upload
    Then the user should see an error message "Looks like you don't have permission to add samples to 'PROJECTNAME' project. Please select another project."

  Scenario: Edit an existing sample from the Samples page
    Given the user is on the Samples page
    When the user clicks on the "Edit" icon of a sample
    And updates valid details
    And clicks on the "Save" button
    Then the sample should be updated successfully
    And a success message should be displayed

  Scenario: Delete a sample from the Samples page
    Given the user is logged in and on the Samples page
    When the user clicks on the "Delete" icon of a sample
    And confirms the deletion in the popup
    Then the sample should be deleted successfully
    And a success message should be displayed "Sample deleted successfully."
    And the sample should no longer be visible on the page

  # 4. Performance & Security

  Scenario: Project Access Restriction
    Given the user is trying to access a restricted project
    When the user attempts to access the project
    Then the user should see an error message "Access denied"

  Scenario: Unauthorized Access to Modify Samples in Restricted Project
    Given the user does not have permission to a certain project
    When the user attempts to edit or delete a sample from that project
    Then the system should prevent the action
    And display an error message "Access Denied"

  Scenario: New user cannot edit or delete a project not created by them
    Given User_A has created a project named "ProjectX"
    And User_B is a registered user and logs into the system
    When User_B navigates to the Projects dashboard
    And User_B tries to access the "Edit" or "Delete" action for "ProjectX"
    Then the system should not allow User_B to edit or delete the project

  Scenario: Prevent multiple logins across tabs
    Given User is logged in on Tab A
    When User opens Tab B and logs in with same credentials
    Then User should be logged out from Tab A
    And A message "You have been logged out due to login from another location" should appear


  # 5. UI/UX Testing
  
  Scenario: UI Consistency on Project Page
    Given the user is on the project page
    When the user inspects the UI elements
    Then all buttons should be aligned and styled according to the design specifications

  Scenario: Clear Error Message on Invalid Upload
    Given the user selects an invalid file for upload
    When the user clicks the "Upload" button
    Then the user should see a clear error message "Looks you are trying to upload a file format not supported by Basepair"

  Scenario: No Feedback on Invalid Drop Area
    Given the user attempts to drag a file into an invalid drop area
    When the user drops the file
    Then there should be no feedback or indication to the user

  # 6. Boundary & Input Validation

  Scenario: Invalid Input in Numeric Fields
    Given the user is on the sample upload page
    When the user enters non-numeric values in the size field
    Then the user should see an error message "Please input a valid integer number."

  Scenario: Minimum and Maximum Field Length Validation for Project Name
    Given the user is on the project creation page
    When the user enters a project name with more than 50 characters
    Then the user should see an error message "Project name cannot exceed 50 characters"

  Scenario: Minimum and Maximum Field Length Validation for Insert Size
    Given the user is on the sample form
    When the user enters a Insert size having 21+ digits
    Then the user should see an error message "Please input a valid integer number."
    And the input field displays e for 21+ input
    And the input field displays infinity for 23+ input

  # 7. API Testing (Sample Upload API)

  Scenario: Successful Sample Upload via API
    Given the user has a valid API token
    When the user sends a POST request to the sample upload API with valid data
    Then the user should receive a 200 OK response
    And the response should contain the message "Sample uploaded successfully"
  
  Scenario: Invalid Sample Upload via API
    Given the user has a valid API token
    When the user sends a POST request with invalid data (e.g., unsupported file- .pdf)
    Then the user should receive a 400 Bad Request response
    And the response should contain the message "Unsupported file format"

  # 8. Cross-Browser Testing

  Scenario: Upload Sample on Chrome
    Given the user is on the sample upload page using Google Chrome
    When the user selects a valid sample file and clicks "Upload"
    Then the sample should be uploaded successfully

  Scenario: Upload Sample on Firefox
    Given the user is on the sample upload page using Mozilla Firefox
    When the user selects a valid sample file and clicks "Upload"
    Then the sample should be uploaded successfully

  Scenario: Verify Upload Sample on Safari
    Given the user is on the sample upload page using Safari
    When the user selects a valid file and clicks "Upload"
    Then the sample should be uploaded successfully


  # 9. Automation Testing

  Scenario: Upload a sample and verify it's listed under the correct project
    Given the user navigates to the Basepair login page
    When the user enters valid credentials and logs in
    And the user clicks on the "Upload" button
    And the user selects a valid file from the local system
    And the user fills in the required details
    And the user clicks on the "Upload Samples" button
    Then a success message should be displayed
    And the user navigates to the "Samples" page for the project
    Then the uploaded sample with the same file name should be listed
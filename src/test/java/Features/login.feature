Feature: Login Medplus

Scenario: login the application and add ICD 
Given user logged in and moved to manage
And clicked ICD
Then clicked add
And provided ICDname,ICD number,ICD type
Then clicked submit
Then Verified page header

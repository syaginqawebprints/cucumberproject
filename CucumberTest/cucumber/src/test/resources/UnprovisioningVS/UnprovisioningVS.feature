Feature: Unprovisioning Virtual Server
Description: Print all available test names

Scenario:  Unprovisioning Virtual Server
Given Open and Login to Application
And Open Stack page 
And Search Virtual Server for Delete
And Delete Virtual Server
And Close the browser
And Print test finished
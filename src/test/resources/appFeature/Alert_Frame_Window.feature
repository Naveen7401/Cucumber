Feature: Alerts,Frames & Window Tab cases

Scenario: Browser windows handling
Given Click on the Alert,frame & Windows tab
When  Clicking on the browser windows tab
And Clicking the New Tab
Then Check the tab is opened

Scenario: Browser windows handling
Given Click on the Alert,frame & Windows tab
When  Clicking on the browser windows tab
And Clicking the New Window
Then Check the New Window is opened

Scenario: Browser windows handling
Given Click on the Alert,frame & Windows tab
When Clicking on the browser windows tab
And Clicking the New Window Message button
Then Check the message is displayed
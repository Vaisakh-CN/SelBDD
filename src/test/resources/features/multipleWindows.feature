Feature: Handle multiple windows and Tabs

Scenario Outline: Verify content in new window

Given User is in landing page		
When User clicks on new Window button
Then Verify New Window is opened 
And Veify the content in new window contains "<text1>" and "<text2>"
Examples: 
			| text1 | text2 |
			| Basic Controls | in HTML |
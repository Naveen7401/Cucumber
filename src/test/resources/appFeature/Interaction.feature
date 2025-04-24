Feature: Interaction
Scenario: Resizeable
Given Clicking the interaction tab
When Cilcking the Resizeable
And Resizing the box


Scenario: Horizontal scroll
Given Clicking the widgets dropdown
When Clicking the horizontal scroll Dropdown
And Scrolling horizontal action

Scenario: Draggable
Given Clicking the interaction tab
When Clicking Draggable tab
When Clicking Axis Restricted
Then Dragging the X Axis
Then Dragging the Y Axis
@smoke
  Feature: F06_HomeSlider | user could click on one of slider and go to page where is be detailed of slider

    Scenario: user could go to page relative to detailed slider successfully

      When user could select from sliders is Nokia
      Then verify that the details of first slider for Nokia Lumia is displayed

    Scenario: user could go to page relative to detailed slider successfully

      When user could select from sliders is Iphone
     Then verify that the details of Second slider for iPhone is displayed
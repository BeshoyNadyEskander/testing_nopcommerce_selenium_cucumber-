@smoke

  Feature:  F07_followUs | users could open followUs links

    Scenario: user opens facebook link to follow us

      Given user can scroll down page to reach follow us buttons
      When user can click on facebook sign to open facebook link
      Then verify that page of nopcommerce in facebook is opened

    Scenario: user opens twitter link

      Given user can scroll down page to reach follow us buttons
      When user can click on twitter sign to open twitter link
      Then verify that page of nopcommerce in twitter is opened


    Scenario: user opens rss link

      Given user can scroll down page to reach follow us buttons
      When user can click on rss sign to open rss link
      Then verify that page of nopcommerce in rss is opened


    Scenario: user opens youtube link

      Given user can scroll down page to reach follow us buttons
      When user can click on youtube sign to open youtube link
      Then verify that page of nopcommerce in youtube is opened
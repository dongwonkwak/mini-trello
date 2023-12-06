Feature: Signing up to the Mini Trello

  Username should be 6-30 characters long. can be any combination of letters, numbers, or symbols.
  Password should be 6-16 characters long.

  Rule: User must provide a valid username
    Scenario Outline: Only valid username should be accepted
      Given Jane is not a Mini Trello Member
      When she tries to register with a username of <username>
      Then the username should be <Accepted/Rejected> with the message "<Reason>"

      Examples: username should be accepted
        | username              | Accepted/Rejected   | Reason  |
        | johndoe               | Accepted            |         |
        | sweet_kristy          | Accepted            |         |
        | fairy.princess.kristy | Accepted            |         |

      Examples: Invalid username should be rejected
        | username                            | Accepted/Rejected | Reason                | Note      |
        | jun                                 | Rejected          | Username is not valid | too short |
        | personallyvictimizedbyreginageorge  | Rejected          | Username is not valid | too long  |

  Rule: User must provide a valid email address
    Scenario Outline: Only valid email should be accepted
      Given Jane is not a Mini Trello Member
      When she tries to register with an email of <email>
      Then the email should be <Accepted/Rejected> with the message "<Reason>"

      Examples: email should be accept
        | email               | Accepted/Rejected | Reason  |
        | johndoe@example.com | Accepted          |         |

      Examples: Invalid email should be rejected
        | email               | Accepted/Rejected | Reason              |
        | test                | Rejected          | Email is not valid  |
# AdjustGov

An Android and web application encouraging civic engagement through crowdsourcing, a hackathon project for Silicon Hacks 2017.

## Objective

AdjustGov is a social media app, a game, but also much more. Through crowdsourced data collection, we empower individuals to improve their communities by raising awareness about important issues, and help governments maintain positive relationships with it's citizens by encouraging transparency.

Users of the app report issues and concerns that they encounter in their daily life. This information is broadcasted to others in their general area, who can furthur spread the message. On a macro scale, this information is collated into a web interface, allowing government agencies and other authorities to see what their constituents feel is important.

## Implementation

We wrote an Android application that incorporates the Google Maps API to allow the user to select a location pertaining to their issue. We then uploaded this information to a Firebase hosted database (through REST API's) which would propagate the data to anyone with the app installed. Finally, we created a view-only web inteface for governments to easily access and analyze the data.

## Beyond Silicon Hacks 2017

- We initially planned to have richer detail for issues, such as photos and ratings
- We were not able to fully implement location filtering
- We would have liked to incorporate Google OAuth signin for easier access and to allow vote authentification
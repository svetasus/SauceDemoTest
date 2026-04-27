# SauceDemoTest Selenium UI Automation: E-Commerce Flow

## Overview
This repository contains a UI automation script built as a foundational portfolio project for the EPAM QA Automation program. It automates a critical user journey (Login $\rightarrow$ Inventory $\rightarrow$ Cart Validation) on the standard Sauce Labs demonstration e-commerce application.

## Tech Stack
Language: Java (JDK 21 LTS)

Tool: Selenium WebDriver (v4)

Build Tool: Maven

## Automated Scenarios
Authentication: Verifies successful login using valid credentials.

State Management: Verifies that adding an item to the cart correctly updates the global UI cart badge counter.

Cart Validation: Navigates to the cart page and verifies that correct item metadata (Name) was passed to the checkout screen.


## Testing Best Practices Applied
Clean Code: Elements are stored in descriptive variables rather than using nested chaining to improve code readability and maintainability.

Safe Teardown: Implemented try-catch-finally blocks to guarantee driver.quit() is executed, preventing memory leaks from orphaned ChromeDriver instances.

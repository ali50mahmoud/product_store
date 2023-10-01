# product_store  { Amazon Product Cart Automation }


This project automates the process of adding products to the cart on the Amazon website under specific conditions using Java, Selenium WebDriver,Cucumber  and Java Rest-Assured framework

## Overview
This project contains automation test cases implemented in Selenium-Java for automating Amazon Egypt's website and Java Rest-Assured framework for testing endpoints related to the Foodics Dev environment. The Selenium-Java automation script simulates a user's interaction with the Amazon website, including logging in, filtering products, adding them to the cart, and selecting the payment method. The Java Rest-Assured framework is used to test endpoints related to Foodics Dev.

## Prerequisites
- Java Development Kit (JDK) installed
- Maven installed
- WebDriver compatible with your browser installed (e.g., ChromeDriver)

## Getting Started

### Selenium-Java Automation
1. Clone this repository to your local machine:

```bash
git clone <repository_url>
```

2. Navigate to the Selenium-Java folder:

```bash
cd Selenium-Java
```

3. Install project dependencies:

```bash
mvn clean install
```

4. Run the Selenium-Java automation script:

```bash
mvn test
```

### Java Rest-Assured Framework
1. Clone this repository to your local machine:

```bash
git clone <repository_url>
```

2. Navigate to the Java Rest-Assured folder:

```bash
cd Java-Rest-Assured
```

3. Install project dependencies:

```bash
mvn clean install
```

4. Run the test cases:

```bash
mvn test
```

## Folder Structure
- `Selenium-Java` folder contains the Selenium-Java automation scripts.
- `Java-Rest-Assured` folder contains the Java Rest-Assured framework and test cases.

## Test Cases
### Selenium-Java Automation
1. **Test Case 1: Login to Amazon and Filter Video Games**
   - Open Amazon Egypt.
   - Login.
   - Open "All" menu.
   - Click on "Video Games" and choose "All Video Games."
   - Add filters for "Free Shipping" and "New."
   - Sort products by price: high to low.
   - Add products with a cost below 15k EGP to the cart.

2. **Test Case 2: Add Address and Payment Method**
   - Ensure that products are added to the cart.
   - Add an address.
   - Choose "Cash" as the payment method.
   - Verify the total amount of items is correct, including shipping fees.

### Java Rest-Assured Framework
1. **Test Case 1: Login to Foodics Dev**
   - Send a POST request to `https://pay2.foodics.dev/cp_internal/login`.
   - Use the provided credentials.
   - Validate the response.

2. **Test Case 2: Check User Information**
   - Send a GET request to `https://pay2.foodics.dev/cp_internal/whoami`.
   - Use the provided token.
   - Validate the response.

## Coding Standards
- Code follows Java coding standards.
- Meaningful variable and method names.
- Use of comments for code clarification.
- Proper project structure.

## Notes
- The Selenium-Java automation script only automates the process up to the point of adding products to the cart and selecting the payment method. No actual order placement occurs.
- Test cases can be extended, and additional scenarios can be added as needed.

## Author
Ali Mahmoud


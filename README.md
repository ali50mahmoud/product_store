# product_store  { Amazon Product Cart Automation }


This project automates the process of adding products to the cart on the Amazon website under specific conditions using Java, Selenium WebDriver, and Cucumber.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)
- [Contact](#contact)

## Installation

1. Clone the repository:
   ```shell
   git clone https://github.com/yourusername/amazon-product-cart-automation.git
   ```

2. Import the project into your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Install necessary dependencies using a build tool like Maven.

## Usage

1. Run Cucumber tests using a test runner (e.g., JUnit).

2. Create and modify feature files in the `src/test/resources/features` directory to define scenarios for adding products to the cart on Amazon under specific conditions.

3. Implement step definitions and corresponding logic in Java under `src/test/java/stepDefinitions`.

## Features

- Utilizes Selenium WebDriver for browser automation.
- Implements BDD scenarios using Gherkin syntax in feature files.
- Integrates Cucumber to execute BDD scenarios and generate reports.
- Includes tests for adding products to the cart on Amazon under specific conditions.

## Example Scenario: Adding Products to Cart on Amazon

### Scenario:
- **Given** the user is on the Amazon product page
- **When** the product is available for purchase
- **And** the product price is within the specified budget
- **Then** the user adds the product to the cart

## Contributing

If you'd like to contribute to this project, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature/your-feature`.
3. Make your changes and commit them: `git commit -m 'Add a new feature'`.
4. Push to the branch: `git push origin feature/your-feature`.
5. Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- Thanks to the Cucumber and Selenium communities for their valuable contributions.

## Contact

For inquiries, contact [Your Name] at [contact email].

---

Feel free to customize the feature scenario based on your specific conditions for adding products to the cart on Amazon. Also, replace `[Your Name]`, `[contact email]`, and other placeholders with the appropriate details for your project.

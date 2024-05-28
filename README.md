# Facebook Marketplace Automation

## Project Overview

This project aims to automate the posting of products on Facebook Marketplace by providing an image path and generating an attractive marketing description for the product using the ChatGPT API.

## Requirements

- **Operating System**: Windows
  - The system uses features specific to the Windows file management system.
- **Keyboard Layout**: Spanish - QWERTY
  - The keyboard layout must be set to Spanish - QWERTY for writing certain characters in the image file path, such as ( :, \\ ) in `C:\\images`.

## Setup Instructions


1. **Clone the Repository**
   ```sh
   git clone https://github.com/Brando333/Facebook_marketplace_posting.git
   cd Facebook_marketplace_posting

 2. **Set Keyboard Layout to Spanish - QWERTY**

- On Windows, you can set the keyboard layout by going to:
  - `Settings` > `Time & Language` > `Language` > `Preferred languages`
  - Add or select `Spanish (Spain)` with the QWERTY layout.

3. **Configure Facebook Credentials and Product File Path**

- Open the `User` class in the `app` package and set your Facebook username, password, and the product file path.

```java
package app;

public class User {
    public static String user = "your_username";
    public static String pass = "your_password";
    public static String productsPath = "C:\\products\\";
}
   

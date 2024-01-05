# NopCommerce UI Test Automation

## Giới Thiệu

Dự án thực hiện tự động hóa kiểm thử giao diện người dùng (UI) cho trang web NopCommerce. Một số chức năng được kiểm thử bao gồm: Register, Login, Wishlist, Order, Search,... Dự án sử dụng Selenium WebDriver, TestNG.
Link Website: https://demo.nopcommerce.com/

## Cấu Trúc Thư Mục

- `src/main/java`: Chứa các module 
  - `src/main/java/common`: chứa các common class như BasePage, BaseTest ,Global_Constant
  - `src/main/java/PageObject`: chứa các page class
  - `src/main/java/PageUIs`: Tập hợp các locator - đại diện cho element/ đối tượng trong các page
- `src/test/java/Nopcommerce`: Chứa mã nguồn của các test.
- `src/test/Resource`: chứa các file như RunTestcase.xml, log4j.xml,..
- Các thư mục khác: BrowserDriver, ScriptLog,..

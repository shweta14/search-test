Project created for Adding search tests for Springer Link, It is using Java, Selenium Web Driver & Cucumber framework to run the tests  
By default it is using Selenium HTML Unit Web driver to run the tests, but this can be changed to browser specific web driver

For Chrome Driver you will have to set VM option for path of Chrome.exe and replace HtmlUnitDriver with ChromeDriver class
E.g,
-Dwebdriver.chrome.driver=C:\apps\chromedriver.exe (Path of chromedriver.exe file)
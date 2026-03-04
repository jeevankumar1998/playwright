const {test,expect} = require("@playwright/test")
 
test("Verifying login functionality",async({page})=>{
  await page.goto("https://www.saucedemo.com/")
  await page.waitForTimeout(3000)
  await page.locator("//input[@placeholder='Username']").fill("standard_user")
   await page.waitForTimeout(3000)
  await page.locator("//input[@placeholder='Password']").fill("secret_sauce")
  await page.waitForTimeout(3000)
  await page.locator("//input[@type='submit']").click()
})
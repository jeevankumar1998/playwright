// package utils;

// public class AllureFeatureOnlyListener {

//     public class AllureFeatureOnlyListener extends AllureTestNg {

//     @Override
//     protected void beforeTestMethod(io.qameta.allure.testng.AllureTestNg.AllureTestResultListener context, Object testInstance) {
//         TestResult testResult = context.getTestResult();
//         if (testResult != null && testResult.getName().contains("TestRunner")) {
//             // Remove the Surefire wrapper suite from Allure report
//             Allure.getLifecycle().removeTest(testResult.getUuid());
//         }
//         super.beforeTestMethod(context, testInstance);
//     }

// }

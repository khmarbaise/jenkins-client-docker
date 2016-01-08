package com.offbytwo.jenkins.integration;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class MethodListener
    implements IInvokedMethodListener
{

    private String getClassNameWithoutPackage( String canonicalName )
    {
        int lastIndexOf = canonicalName.lastIndexOf( '.' );
        return canonicalName.substring( lastIndexOf + 1 );
    }

    @Override
    public void beforeInvocation( IInvokedMethod method, ITestResult testResult )
    {
        if ( method.isTestMethod() )
        {
            ITestNGMethod testMethod = method.getTestMethod();
            String classNameWithoutPackage = getClassNameWithoutPackage( testMethod.getTestClass().getName() );
            System.out.print( classNameWithoutPackage + ": " + testMethod.getMethodName() + "..." );
        }
    }

    @Override
    public void afterInvocation( IInvokedMethod method, ITestResult testResult )
    {
        if ( method.isTestMethod() )
        {
            if ( testResult.isSuccess() )
            {
                System.out.println( "Done." );
            }
            else
            {
                System.out.println( "FAILURE." );
            }
        }
    }

}

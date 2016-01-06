package com.offbytwo.jenkins.integration;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MethodListener
    implements IInvokedMethodListener
{

    @Override
    public void beforeInvocation( IInvokedMethod method, ITestResult testResult )
    {
        if ( method.isTestMethod() )
        {
            String fullClassName = method.getTestMethod().getTestClass().getName();
            int lastIndexOf = fullClassName.lastIndexOf( '.' );
            String className = fullClassName.substring( lastIndexOf + 1 );
            System.out.print( className + ": " + method.getTestMethod().getMethodName() + "..." );
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

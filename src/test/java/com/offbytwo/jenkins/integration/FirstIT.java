package com.offbytwo.jenkins.integration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offbytwo.jenkins.JenkinsServer;

public class FirstIT
{
    private JenkinsServer js;

    @BeforeMethod
    public void beforeMethod()
    {
        js = new JenkinsServer( Constant.JENKINS_URI );
    }

    @Test
    public void firstTest()
    {
        System.out.println( "Start checking..." );
        while (!js.isRunning()) {
            try
            {
                System.out.print( "." );
                Thread.sleep( 1000L );
            }
            catch ( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println( "Running..." );
    }
}

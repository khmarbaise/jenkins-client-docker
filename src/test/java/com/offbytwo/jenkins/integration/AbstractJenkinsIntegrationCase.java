package com.offbytwo.jenkins.integration;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.offbytwo.jenkins.JenkinsServer;

@Listeners( { MethodListener.class } )
public class AbstractJenkinsIntegrationCase
{

    protected static JenkinsServer jenkinsServer;

    @BeforeSuite
    public void waitUntilJenkinsHasBeenStartedUp()
    {
        jenkinsServer = new JenkinsServer( Constant.JENKINS_URI );
        System.out.print( "Wait until Jenkins is started..." );
        while ( !jenkinsServer.isRunning() )
        {
            try
            {
                System.out.print( "." );
                Thread.sleep( 1000L );
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
        System.out.println( "done." );
    }

}

package com.offbytwo.jenkins.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.ComputerSet;

public class FirstIT
{
    private JenkinsServer js;

    @BeforeTest
    public void beforeTest()
    {
        js = new JenkinsServer( Constant.JENKINS_URI );
        System.out.print( "Start checking..." );
        while ( !js.isRunning() )
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
        System.out.println( "Running" );
    }

    @Test( )
    public void firstTest()
        throws IOException
    {
        ComputerSet computerSet = js.getComputerSet();
        assertThat( computerSet.getBusyExecutors() ).isEqualTo( 0 );
    }
}

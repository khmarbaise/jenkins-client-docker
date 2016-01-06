package com.offbytwo.jenkins.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offbytwo.jenkins.model.Computer;
import com.offbytwo.jenkins.model.Job;

public class NoExecutorStartedGetComputersIT
    extends AbstractJenkinsIntegrationCase
{

    private Map<String, Computer> computers;

    @BeforeMethod
    public void beforeMethod()
        throws IOException
    {
        computers = jenkinsServer.getComputers();
    }

    @Test
    public void numberOfComputersIsEqualOne()
    {
        assertThat( computers ).hasSize( 1 );
    }

    @Test
    public void getNameShouldReturnMaster()
    {
        String key = computers.keySet().iterator().next();
        assertThat( computers.get( key ).getDisplayName() ).isEqualTo( "master" );
    }
}

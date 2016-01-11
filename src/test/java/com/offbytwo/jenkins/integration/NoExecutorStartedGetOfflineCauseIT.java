package com.offbytwo.jenkins.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offbytwo.jenkins.model.ComputerSet;
import com.offbytwo.jenkins.model.ComputerWithDetails;
import com.offbytwo.jenkins.model.OfflineCause;

public class NoExecutorStartedGetOfflineCauseIT
    extends AbstractJenkinsIntegrationCase
{

    private OfflineCause offlineCause;

    @BeforeMethod
    public void beforeMethod()
        throws IOException
    {
        ComputerSet computerSet = jenkinsServer.getComputerSet();
        List<ComputerWithDetails> computerList = computerSet.getComputer();
        ComputerWithDetails computer = computerList.get( 0 );
        ComputerWithDetails details = computer.details();
        OfflineCause offlineCause2 = computer.getOfflineCause();
        offlineCause = jenkinsServer.getComputerSet().getComputer().get( 0 ).getOfflineCause();
    }

    /**
     * This is a timestamp so really can't make a test which compares to a real value. TODO: Think about this...
     */
    @Test
    public void getTimestampShouldReturnNonZero()
    {
        assertThat( offlineCause.getTimestamp() ).isNotZero();
    }

    @Test
    public void getDescriptionShouldReturnTheAppropriateMessage()
    {
        assertThat( offlineCause.getDescription() ).isEqualTo( "Disconnected by anonymous : I have set offline manually." );
    }
}

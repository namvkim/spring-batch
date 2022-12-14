//package com.example.tasklet;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.batch.core.ExitStatus;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.test.JobLauncherTestUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static junit.framework.TestCase.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = BatchConfiguration.class)
//public class TaskletsTest {
//    @Autowired
//    private JobLauncherTestUtils jobLauncherTestUtils;
//
//    @Test
//    public void givenTaskletsJob_whenJobEnds_thenStatusCompleted()
//            throws Exception {
//
//        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
//        assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
//    }
//}

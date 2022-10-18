package com.example.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.List;

public class LinesWriter implements Tasklet, StepExecutionListener {

    private List<Product> lines;
    private FileUtils fu;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.lines = (List<Product>) executionContext.get("lines");
        fu = new FileUtils("output.csv");
        System.out.println("Lines Writer initialized.");
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
            for (Product line : lines) {
                fu.writeLine(line);
                System.out.println("Wrote line " + line.toString());
            }
            return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
            fu.closeWriter();
            System.out.println("Lines Writer ended.");
            return ExitStatus.COMPLETED;
    }
}

package com.example.tasklet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataReader implements Tasklet, StepExecutionListener {

    private final Logger logger = LoggerFactory
            .getLogger(DataReader.class);

    private List<Product> lines;

    @Autowired
    private ProductService productService;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        lines = new ArrayList<>();
        logger.debug("Lines Reader initialized.");
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution,
                                ChunkContext chunkContext) throws Exception {
        lines = productService.getProducts();
        System.out.println(lines.get(0).toString());
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        stepExecution
                .getJobExecution()
                .getExecutionContext()
                .put("lines", this.lines);
        logger.debug("Lines Reader ended.");
        return ExitStatus.COMPLETED;
    }
}

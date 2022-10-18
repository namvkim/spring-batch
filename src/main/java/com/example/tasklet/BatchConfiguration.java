package com.example.tasklet;

//import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.Jackson2ExecutionContextStringSerializer;
import org.springframework.batch.core.repository.dao.XStreamExecutionContextStringSerializer;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.HibernateCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

//import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration  {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private DataReader dataReader;

    @Autowired
    DataSource dataSource;

//    @Autowired
//    private  DataSource dataSource;

    @Bean
    public Job job() {
        return jobs
                .get("taskletsJob")
                .start(readLines())
                .next(processLines())
                .next(writeLines())
                .build();
    }

    @Bean
    protected Step readLines() {
        System.out.println("step1");
        return steps
//                .get("readLines").chunk(3).reader(itemReader()).writer(itemWriter())
//                .tasklet(dataReader)
                .get("readLines")
                .tasklet(new MessageTasklet("fadsfsf"))
                .build();
    }

    @Bean
    protected Step processLines() {
        System.out.println("step2");
        return steps
                .get("processLines")
                .tasklet(new MessageTasklet("fakdshf"))
                .build();
    }

//    @Bean
//    public ItemWriter<? super Object> itemWriter() {
//        return emps -> {
//            System.out.println("\nWriting chunk to console");
//            for (Object emp : emps) {
//                System.out.println(emp);
//            }
//        };
//    }

    @Bean
    protected Step writeLines() {
        System.out.println("step3");
        return steps
                .get("writeLines")
                .tasklet(new MessageTasklet("fadshifi"))
                .build();
    }

//    @Bean
//    public void messageTasklet(){
//        System.out.println("heihihi");
////        MessageTasklet messageTasklet = new MessageTasklet("hello");
////        return  null;
//    }

//    @Bean
//    public JdbcCursorItemReader<Product> itemReader() {
//        JdbcCursorItemReader itemReade = new JdbcCursorItemReader();
//        itemReade.setDataSource(dataSource());
//        itemReade.setName("productReader");
//        itemReade.setSql("select id, name from product");
//        itemReade.setRowMapper(new CustomerCreditRowMapper());
//
//        return itemReade;
////        return new JdbcCursorItemReaderBuilder<Product>()
////                .dataSource(dataSource())
////                .name("productReader")
////                .sql("select id, name from product")
////                .rowMapper(new CustomerCreditRowMapper())
////                .build();
//
//    }

}


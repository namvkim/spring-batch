//package com.example.tasklet;
//
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.support.SimpleJobLauncher;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
//import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////
////        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost:3306/tasklet_data");
////        dataSource.setUsername("root");
////        dataSource.setPassword("1234");
////
////        return dataSource;
//        return  DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/tasklet_data")
//                .username("root")
//                .password("1234")
//                .build();
//
//    }
////    @Bean
////    public JobRepository jobRepository() throws Exception {
////        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
////        factory.setDataSource(dataSource());
////        factory.setTransactionManager(transactionManager());
////        return factory.getObject();
////    }
//
////    @Bean
////    public PlatformTransactionManager transactionManager() {
////        return new ResourcelessTransactionManager();
////    }
//
////    @Bean
////    public JobLauncher jobLauncher() throws Exception {
////        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
////        jobLauncher.setJobRepository(jobRepository());
////        return jobLauncher;
////    }
//
//}

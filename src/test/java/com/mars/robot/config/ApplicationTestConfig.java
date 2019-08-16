package com.mars.robot.config;

import com.mars.robot.RobotApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RobotApplication.class)
public class ApplicationTestConfig {
}

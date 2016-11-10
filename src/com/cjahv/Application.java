package com.cjahv;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 入口
 * Created by jahv on 2016/11/10.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.sshp.config", "com.cjahv"})
public class Application {

}

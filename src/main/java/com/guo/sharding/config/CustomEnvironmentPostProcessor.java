package com.guo.sharding.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @Date: 2021/2/24 15:44
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final String SHARDING_PREFIX = "sharding-config";

    //Properties对象
    private final Properties properties = new Properties();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        // 获取配置得classpath目录
        String shardingClassPath = environment.getProperty("sharding.classpath-dir");
        System.out.println("============shardingClassPath"+shardingClassPath);
        if (StringUtils.isEmpty(shardingClassPath)) {
            shardingClassPath = SHARDING_PREFIX;
        }

        // sharding配置文件
        String shardingConfigFiles = environment.getProperty("sharding.config-file");
        System.out.println("============shardingConfigFils"+shardingConfigFiles);
        if (!StringUtils.isEmpty(shardingConfigFiles)) {

            String[] shardingConfigFileArr = shardingConfigFiles.split(",");

            //循环添加
            for (String shardingConfigFile : shardingConfigFileArr) {

                //从classpath路径下面查找文件
                String filePath = shardingClassPath + "/" + shardingConfigFile + ".properties";

                Resource resource = new ClassPathResource(filePath);
                //加载成PropertySource对象，并添加到Environment环境中
                environment.getPropertySources().addLast(loadProfiles(resource));
            }
        }

    }

    //加载单个配置文件
    private PropertySource<?> loadProfiles(Resource resource) {
        if (!resource.exists()) {
            throw new IllegalArgumentException("资源" + resource + "不存在");
        }
        try {
            //从输入流中加载一个Properties对象
            properties.load(resource.getInputStream());
            return new PropertiesPropertySource(resource.getFilename(), properties);
        }catch (IOException ex) {
            throw new IllegalStateException("加载配置文件失败" + resource, ex);
        }
    }
}
